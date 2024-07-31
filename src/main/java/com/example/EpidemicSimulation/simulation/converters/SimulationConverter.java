package com.example.EpidemicSimulation.simulation.converters;

import com.example.EpidemicSimulation.simulation.domain.Simulation;
import com.example.EpidemicSimulation.simulation.dto.SimulationDto;

public class SimulationConverter {

    private SimulationConverter() {

    }

   public static SimulationDto toDto(final Simulation simulation) {
        final SimulationDto simulationDto = new SimulationDto();
        simulationDto.setId(simulation.getId());
        simulationDto.setName(simulation.getName());
        simulationDto.setPopulationSize(simulation.getPopulationSize());
        simulationDto.setInitialInfected(simulation.getInitialInfected());
        simulationDto.setReproductionNumber(simulation.getReproductionNumber());
        simulationDto.setMortalityRate(simulation.getMortalityRate());
        simulationDto.setDaysRecovery(simulation.getDaysRecovery());
        simulationDto.setDaysToDeath(simulation.getDaysToDeath());
        simulationDto.setSimulationDays(simulation.getSimulationDays());
        return simulationDto;
    }

    public static Simulation fromDto(final SimulationDto simulationDto) {
        final Simulation simulation = new Simulation();
        if (simulationDto.getName() != null) {
            simulation.setName(simulationDto.getName());
        }
        if (simulationDto.getPopulationSize() != 0) {
            simulation.setPopulationSize(simulationDto.getPopulationSize());
        }
        simulation.setId(simulationDto.getId());
        simulation.setInitialInfected(simulationDto.getInitialInfected());
        simulation.setReproductionNumber(simulationDto.getReproductionNumber());
        simulation.setMortalityRate(simulationDto.getMortalityRate());
        simulation.setDaysRecovery(simulationDto.getDaysRecovery());
        simulation.setDaysToDeath(simulationDto.getDaysToDeath());
        simulation.setSimulationDays(simulationDto.getSimulationDays());
        return simulation;
    }
}
