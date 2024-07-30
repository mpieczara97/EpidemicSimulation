package com.example.EpidemicSimulation.simulation.dto;

public class SimulationDto {
    private String name;
    private int populationSize;

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
}
