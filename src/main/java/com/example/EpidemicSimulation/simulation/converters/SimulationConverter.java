package com.example.EpidemicSimulation.simulation.converters;

import com.example.EpidemicSimulation.simulation.domain.Simulation;
import com.example.EpidemicSimulation.simulation.dto.SimulationDto;

public class SimulationConverter {

    private SimulationConverter() {

    }

   public static SimulationDto toDto(final Simulation simulation) {
        final SimulationDto simulationDto = new SimulationDto();
        simulationDto.setName(simulation.getName());
        simulationDto.setPopulationSize(simulation.getPopulationSize());
        return simulationDto;
    }
}
