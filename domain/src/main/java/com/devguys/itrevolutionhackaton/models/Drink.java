package com.devguys.itrevolutionhackaton.models;

public class Drink {
    private double grams;
    private double density;
    private double alcoholTurnovers;

    public Drink(double grams, double density, double alcoholTurnovers) {
        this.grams = grams;
        this.density = density;
        this.alcoholTurnovers = alcoholTurnovers;
    }

    public double getGrams() {
        return grams;
    }

    public double getDensity() {
        return density;
    }

    public double getAlcoholTurnovers() {
        return alcoholTurnovers;
    }
}
