package com.example.EpidemicSimulation.simulation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Simulation {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int populationSize;
    private double incidenceRate;
    private double mortalityRate;
    private int daysRecovery;
    private int daysToDeath;
    private int simulationDays;

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

    public double getIncidenceRate() {
        return incidenceRate;
    }

    public void setIncidenceRate(double incidenceRate) {
        this.incidenceRate = incidenceRate;
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
}
