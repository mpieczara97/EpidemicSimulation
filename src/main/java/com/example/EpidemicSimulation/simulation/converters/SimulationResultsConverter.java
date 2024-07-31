package com.example.EpidemicSimulation.simulation.converters;

import com.example.EpidemicSimulation.simulation.domain.SimulationDay;
import com.example.EpidemicSimulation.simulation.dto.SimulationResultDto;

public class SimulationResultsConverter {

    private SimulationResultsConverter() {

    }

    public static SimulationResultDto toDto(final SimulationDay simulationDay) {
        final SimulationResultDto simulationResultDto = new SimulationResultDto();
        simulationResultDto.setRecovered(simulationDay.getRecovered());
        simulationResultDto.setDay(simulationDay.getDay());
        simulationResultDto.setDead(simulationDay.getDead());
        simulationResultDto.setInfected(simulationDay.getInfected());
        simulationResultDto.setSusceptible(simulationDay.getSusceptible());
        return simulationResultDto;
    }
}
