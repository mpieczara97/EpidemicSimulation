package com.example.EpidemicSimulation.simulation.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class SimulationDay {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @Cascade({CascadeType.ALL})
    private Simulation simulation;

    private int day;
    private int susceptible;
    private int infected;
    private int dead;
    private int recovered;

    public SimulationDay() {
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getSusceptible() {
        return susceptible;
    }

    public void setSusceptible(int susceptible) {
        this.susceptible = susceptible;
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
}
