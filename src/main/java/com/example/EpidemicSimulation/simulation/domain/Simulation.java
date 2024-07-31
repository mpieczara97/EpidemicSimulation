package com.example.EpidemicSimulation.simulation.domain;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Simulation {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int populationSize;
    private int initialInfected;
    private double reproductionNumber;
    private double mortalityRate;
    private int daysRecovery;
    private int daysToDeath;
    private int simulationDays;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int susceptible;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int infected;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int dead;

    @Column(nullable = false, columnDefinition = "integer default 0")
    private int recovered;

    @Column(nullable = false, columnDefinition = "double precision default 0")
    private double incidenceRate;

    @OneToMany(mappedBy="simulation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SimulationDay> simulationDayList;

    public Simulation() {
    }

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

    public int getSusceptible() {
        return susceptible;
    }

    public void setSusceptible(int susceptible) {
        this.susceptible = susceptible;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public int getDead() {
        return dead;
    }

    public void setDead(int dead) {
        this.dead = dead;
    }

    public int getRecovered() {
        return recovered;
    }

    public void setRecovered(int recovered) {
        this.recovered = recovered;
    }

    public double getIncidenceRate() {
        return incidenceRate;
    }

    public void setIncidenceRate(double incidenceRate) {
        this.incidenceRate = incidenceRate;
    }

    public List<SimulationDay> getSimulationDayList() {
        return simulationDayList;
    }

    public void setSimulationDayList(List<SimulationDay> simulationDayList) {
        this.simulationDayList = simulationDayList;
    }
}
