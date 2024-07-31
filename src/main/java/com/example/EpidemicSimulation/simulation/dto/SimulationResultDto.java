package com.example.EpidemicSimulation.simulation.dto;

public class SimulationResultDto {
    private int day;
    private int susceptible;
    private int infected;
    private int dead;
    private int recovered;

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
}
