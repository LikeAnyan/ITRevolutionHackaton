package com.devguys.itrevolutionhackaton.models;

@SuppressWarnings("unused")
public class Drink {
    private final double milliliters;
    private final double alcoholTurnovers;
    private final long startTime; // timestamp in mills when user drunk
    private long endTime; // timestamp in mills when alcohol effect will be removed
    private final int type; // for UI

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

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }
}
