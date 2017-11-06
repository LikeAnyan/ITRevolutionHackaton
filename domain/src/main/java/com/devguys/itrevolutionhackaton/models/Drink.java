package com.devguys.itrevolutionhackaton.models;

@SuppressWarnings("unused")
public class Drink {
    private double milliliters;
    private double alcoholTurnovers;
    private long startTime; // timestamp in mills when user drunk
    private long endTime; // timestamp in mills when alcohol effect will be removed
    private int type; // for UI

    public Drink() {

    }

    public Drink(double milliliters, double alcoholTurnovers, long startTime, long endTime, int type) {
        this.milliliters = milliliters;
        this.alcoholTurnovers = alcoholTurnovers;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
    }

    public Drink (double milliliters, double alcoholTurnovers, long startTime, int type){
        this.milliliters = milliliters;
        this.alcoholTurnovers = alcoholTurnovers;
        this.startTime = startTime;
        this.type = type;
    }

    public Drink(double milliliters, double alcoholTurnovers){
        this.milliliters = milliliters;
        this.alcoholTurnovers = alcoholTurnovers;
        this.startTime = 0;
        this.endTime = 0;
        this.type = 0;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public void setMilliliters(double milliliters) {
        this.milliliters = milliliters;
    }

    public void setAlcoholTurnovers(double alcoholTurnovers) {
        this.alcoholTurnovers = alcoholTurnovers;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getMilliliters() {
        return milliliters;
    }

    public double getAlcoholTurnovers() {
        return alcoholTurnovers;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public int getType() {
        return type;
    }
}
