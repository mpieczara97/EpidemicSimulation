package com.example.EpidemicSimulation.simulation.service;

import com.example.EpidemicSimulation.simulation.domain.Simulation;
import com.example.EpidemicSimulation.simulation.dto.SimulationDto;

import java.util.List;

public interface SimulationService {

    List<Simulation> findAll();

    Simulation addSimulation(SimulationDto simulationDto);

    Simulation updateSimulation(Long id, SimulationDto simulationDto);

    SimulationDto findById(Long id);

    void removeSimulationById(Long id);

}
