package com.example.EpidemicSimulation.simulation.db;

import com.example.EpidemicSimulation.simulation.domain.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SimulationJpaRepository extends JpaRepository<Simulation, Long> {
}
