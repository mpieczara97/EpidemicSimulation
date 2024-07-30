package com.example.EpidemicSimulation.simulation.service;

import com.example.EpidemicSimulation.simulation.domain.Simulation;
import com.example.EpidemicSimulation.simulation.dto.SimulationDto;

import java.util.List;
import java.util.Optional;

public interface SimulationService {

    List<Simulation> findAll();

    Simulation addSimulation(SimulationDto simulationDto);

    Optional<Simulation> findById(Long id);

    void removeSimulationById(Long id);

}
