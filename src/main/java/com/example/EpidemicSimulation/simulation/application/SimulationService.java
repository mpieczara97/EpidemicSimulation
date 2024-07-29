package com.example.EpidemicSimulation.simulation.application;

import com.example.EpidemicSimulation.simulation.application.port.SimulationUseCase;
import com.example.EpidemicSimulation.simulation.db.SimulationJpaRepository;
import com.example.EpidemicSimulation.simulation.domain.Simulation;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
class SimulationService implements SimulationUseCase {

    private final SimulationJpaRepository repository;

    SimulationService(SimulationJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Simulation> findAll() {
        return repository.findAll();
    }

    @Override
    public Simulation addSimulation(CreateSimulationCommand command) {
        Simulation simulation = command.toSimulation();
        return repository.save(simulation);
    }

    @Override
    public UpdateSimulationResponse updateSimulationSize(UpdateSimulationCommand command) {
        return repository.findById(command.getId())
                .map(simulation -> {
                    Simulation updatedSimulation = command.updateFields(simulation);
                    repository.save(updatedSimulation);
                    return UpdateSimulationResponse.SUCCESS;
                })
                .orElseGet(() -> new UpdateSimulationResponse(false,
                        Collections.singletonList("Simulation not found with id: " + command.getId())));
    }

    @Override
    public void removeSimulationById(Long id) {
        repository.deleteById(id);
    }
}
