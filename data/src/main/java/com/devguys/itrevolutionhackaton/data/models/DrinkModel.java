package com.devguys.itrevolutionhackaton.data.models;

public class DrinkModel {

    private double milliliters;
    private double alcoholTurnovers;
    private long startTime;
    private long endTime;
    private int type;


    public double getMilliliters() {
        return milliliters;
    }

    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }

    public double getAlcoholTurnovers() {
        return alcoholTurnovers;
    }

    public void setAlcoholTurnovers(double alcoholTurnovers) {
        this.alcoholTurnovers = alcoholTurnovers;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
