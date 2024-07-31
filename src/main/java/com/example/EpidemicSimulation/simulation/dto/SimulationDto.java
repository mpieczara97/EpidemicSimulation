package com.example.EpidemicSimulation.simulation.dto;

import java.util.List;

public class SimulationDto {
    private Long id;
    private String name;
    private int populationSize;
    private int initialInfected;
    private double reproductionNumber;
    private double mortalityRate;
    private int daysRecovery;
    private int daysToDeath;
    private int simulationDays;
    private List<SimulationResultDto> simulationResultDtoList;

    public int getInitialInfected() {
        return initialInfected;
    }

    public void setInitialInfected(int initialInfected) {
        this.initialInfected = initialInfected;
    }

    public double getReproductionNumber() {
        return reproductionNumber;
    }

    public void setReproductionNumber(double reproductionNumber) {
        this.reproductionNumber = reproductionNumber;
    }

    public double getMortalityRate() {
        return mortalityRate;
    }

    public void setMortalityRate(double mortalityRate) {
        this.mortalityRate = mortalityRate;
    }

    public int getDaysRecovery() {
        return daysRecovery;
    }

    public void setDaysRecovery(int daysRecovery) {
        this.daysRecovery = daysRecovery;
    }

    public int getDaysToDeath() {
        return daysToDeath;
    }

    public void setDaysToDeath(int daysToDeath) {
        this.daysToDeath = daysToDeath;
    }

    public int getSimulationDays() {
        return simulationDays;
    }

    public void setSimulationDays(int simulationDays) {
        this.simulationDays = simulationDays;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<SimulationResultDto> getSimulationResultDtoList() {
        return simulationResultDtoList;
    }

    public void setSimulationResultDtoList(List<SimulationResultDto> simulationResultDtoList) {
        this.simulationResultDtoList = simulationResultDtoList;
    }
}
