package com.example.EpidemicSimulation.simulation.db;

import com.example.EpidemicSimulation.simulation.domain.SimulationDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimulationDayRepository extends JpaRepository<SimulationDay, Long> {
    List<SimulationDay> findBySimulationId(Long simulationId);
}
