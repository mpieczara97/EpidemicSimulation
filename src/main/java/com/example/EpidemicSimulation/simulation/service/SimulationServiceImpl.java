package com.example.EpidemicSimulation.simulation.service;

import com.example.EpidemicSimulation.simulation.converters.SimulationConverter;
import com.example.EpidemicSimulation.simulation.converters.SimulationResultsConverter;
import com.example.EpidemicSimulation.simulation.db.SimulationDayRepository;
import com.example.EpidemicSimulation.simulation.db.SimulationJpaRepository;
import com.example.EpidemicSimulation.simulation.domain.Simulation;
import com.example.EpidemicSimulation.simulation.domain.SimulationDay;
import com.example.EpidemicSimulation.simulation.dto.SimulationDto;
import com.example.EpidemicSimulation.simulation.dto.SimulationResultDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class SimulationServiceImpl implements SimulationService {

    private final SimulationJpaRepository repository;
    private final SimulationDayRepository simulationDayRepository;

    SimulationServiceImpl(SimulationJpaRepository repository, SimulationDayRepository simulationDayRepository) {
        this.repository = repository;
        this.simulationDayRepository = simulationDayRepository;
    }

    @Override
    public List<Simulation> findAll() {
        return repository.findAll();
    }

    @Override
    public Simulation addSimulation(SimulationDto simulationDto) {
        Simulation simulation = SimulationConverter.fromDto(simulationDto);
        simulation = repository.save(simulation);
        runSimulation(simulation);
        return simulation;
    }

    @Override
    public Simulation updateSimulation(Long id, SimulationDto simulationDto) {
        return repository.findById(id)
                .map(existingSimulation -> {
                    Simulation updatedSimulation = SimulationConverter.fromDto(simulationDto);
                    updatedSimulation.setId(existingSimulation.getId());
                    return repository.save(updatedSimulation);
                })
                .orElseThrow(() -> new RuntimeException("Simulation not found"));
    }

    @Override
    public SimulationDto findById(Long id) {
        Optional<Simulation> simulationOpt = repository.findById(id);
        if (simulationOpt.isPresent()) {
            Simulation simulation = simulationOpt.get();
            SimulationDto simulationDto = SimulationConverter.toDto(simulation);

            List<SimulationDay> simulationDayList = simulationDayRepository.findBySimulationId(id);
            List<SimulationResultDto> simulationResultDtoList = new ArrayList<>();

            for (SimulationDay simulationDay : simulationDayList) {
                SimulationResultDto simulationResultDto = SimulationResultsConverter.toDto(simulationDay);
                simulationResultDtoList.add(simulationResultDto);
            }

            simulationDto.setSimulationResultDtoList(simulationResultDtoList);
            return simulationDto;
        }
        return null;
    }

    @Override
    public void removeSimulationById(Long id) {
        repository.deleteById(id);
    }

    private void runSimulation(Simulation simulation) {
        int totalPopulation = simulation.getPopulationSize();
        int[] infectedDays = new int[simulation.getSimulationDays() + 1];
        infectedDays[0] = simulation.getInitialInfected();
        simulation.setInfected(simulation.getInitialInfected());
        simulation.setSusceptible(totalPopulation - simulation.getInitialInfected());
        simulation.setDead(0);
        simulation.setRecovered(0);

        for (int day = 1; day <= simulation.getSimulationDays(); day++) {
            runDailySimulation(simulation, day, infectedDays);
        }
    }

    private void runDailySimulation(Simulation simulation, int day, int[] infectedDays) {
        int newDeaths = 0;
        int newRecoveries = 0;

        if (day > simulation.getDaysToDeath()) {
            newDeaths = (int) (infectedDays[day - simulation.getDaysToDeath()] * simulation.getMortalityRate());
        }

        if (day > simulation.getDaysRecovery()) {
            newRecoveries = (int) (infectedDays[day - simulation.getDaysRecovery()] * (1 - simulation.getMortalityRate()));
        }

        newDeaths = Math.min(newDeaths, simulation.getInfected());
        newRecoveries = Math.min(newRecoveries, simulation.getInfected() - newDeaths);

        int newInfections = (int) (simulation.getInfected() * simulation.getReproductionNumber());
        newInfections = Math.min(newInfections, simulation.getSusceptible());

        simulation.setSusceptible(simulation.getSusceptible() - newInfections);
        simulation.setInfected(simulation.getInfected() + newInfections - newDeaths - newRecoveries);
        simulation.setDead(simulation.getDead() + newDeaths);
        simulation.setRecovered(simulation.getRecovered() + newRecoveries);

        infectedDays[day] = newInfections;

        SimulationDay simulationDay = new SimulationDay();
        simulationDay.setSimulation(simulation);
        simulationDay.setDay(day);
        simulationDay.setSusceptible(simulation.getSusceptible());
        simulationDay.setInfected(simulation.getInfected());
        simulationDay.setDead(simulation.getDead());
        simulationDay.setRecovered(simulation.getRecovered());

        simulationDayRepository.save(simulationDay);
    }
}
