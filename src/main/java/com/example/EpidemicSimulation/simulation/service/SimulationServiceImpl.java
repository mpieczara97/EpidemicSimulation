package com.example.EpidemicSimulation.simulation.service;

import com.example.EpidemicSimulation.simulation.db.SimulationJpaRepository;
import com.example.EpidemicSimulation.simulation.domain.Simulation;
import com.example.EpidemicSimulation.simulation.dto.SimulationDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
class SimulationServiceImpl implements SimulationService {

    private final SimulationJpaRepository repository;

    SimulationServiceImpl(SimulationJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Simulation> findAll() {
        return repository.findAll();
    }

    @Override
    public Simulation addSimulation(SimulationDto simulationDto) {
        final Simulation simulation = new Simulation();
        simulation.setName(simulationDto.getName());
        simulation.setPopulationSize(simulationDto.getPopulationSize());
        return repository.save(simulation);
    }

    @Override
    public Optional<Simulation> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void removeSimulationById(Long id) {
        repository.deleteById(id);
    }
}
