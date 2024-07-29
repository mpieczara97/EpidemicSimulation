package com.example.EpidemicSimulation.simulation.application.port;

import com.example.EpidemicSimulation.simulation.domain.Simulation;

import java.util.List;

import static java.util.Collections.emptyList;

public interface SimulationUseCase {

    List<Simulation> findAll();

    Simulation addSimulation(CreateSimulationCommand command);

    UpdateSimulationResponse updateSimulationSize(UpdateSimulationCommand command);

    void removeSimulationById(Long id);

    class CreateSimulationCommand {
        String name;
        int populationSize;

        public Simulation toSimulation() {
            return new Simulation(name, populationSize);
        }
    }

    class UpdateSimulationCommand {
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPopulationSize() {
            return populationSize;
        }

        public void setPopulationSize(int populationSize) {
            this.populationSize = populationSize;
        }

        Long id;
        String name;
        int populationSize;

        public UpdateSimulationCommand(Long id, String name, int populationSize) {
            this.id = id;
            this.name = name;
            this.populationSize = populationSize;
        }

        public Simulation updateFields(Simulation simulation) {
            if (name != null) {
                simulation.setName(name);
            }
            if (populationSize != 0) {
                simulation.setPopulationSize(populationSize);
            }
            return  simulation;
        }
    }

    class UpdateSimulationResponse {
        public static UpdateSimulationResponse SUCCESS = new UpdateSimulationResponse(true, emptyList());

        public UpdateSimulationResponse(boolean success, List<String> errors) {
            this.success = success;
            this.errors = errors;
        }

        boolean success;
        List<String> errors;
    }
}
