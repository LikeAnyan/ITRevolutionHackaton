package com.devguys.itrevolutionhackaton.util.drink;

import android.support.annotation.IntDef;

import java.util.Hashtable;

/**
 * Created by sergey on 05.11.17.
 */

public class DrinkDataset {
    public static final int TYPE_KVASS = 1;
    public static final int TYPE_BEER_LIGHT = 2;
    public static final int TYPE_BEER_DARK = 3;
    public static final int TYPE_VINE = 4;
    public static final int TYPE_TINCTURE = 5;
    public static final int TYPE_LIQUOR = 6;
    public static final int TYPE_VODKA = 7;
    public static final int TYPE_TEQUILA = 8;
    public static final int TYPE_BRANDY = 9;
    public static final int TYPE_WHISKEY_LIGHT = 10;
    public static final int TYPE_WHISKEY_MEDIUM = 11;
    public static final int TYPE_WHISKEY_HARD = 12;
    public static final int TYPE_RUM = 13;
    public static final int TYPE_ABSINTHE = 14;
    public static final int TYPE_OTHER = 15;

    @IntDef({TYPE_KVASS, TYPE_BEER_LIGHT, TYPE_BEER_DARK, TYPE_VINE, TYPE_TINCTURE, TYPE_LIQUOR, TYPE_VODKA,
            TYPE_TEQUILA, TYPE_BRANDY, TYPE_WHISKEY_LIGHT, TYPE_WHISKEY_MEDIUM, TYPE_WHISKEY_HARD, TYPE_RUM,
            TYPE_ABSINTHE, TYPE_OTHER})
    public @interface DrinkType{}

    private static Hashtable<Integer, DrinkDataset> drinks;

    static {
        drinks = new Hashtable<>();
        drinks.put(TYPE_KVASS, new DrinkDataset(0.007, 0.016d, 0.026d));
        drinks.put(TYPE_BEER_LIGHT, new DrinkDataset(0.03d, 0.05d, 0.06d));
        drinks.put(TYPE_BEER_DARK, new DrinkDataset(0.07d, 0.18d, 0.025d));
        drinks.put(TYPE_VINE, new DrinkDataset(0.05d, 0.12d, 0.2d));
        drinks.put(TYPE_TINCTURE, new DrinkDataset(0.18d, 0.25d, 0.35d));
        drinks.put(TYPE_LIQUOR, new DrinkDataset(0.15d, 0.43d, 0.75d));
        drinks.put(TYPE_VODKA, new DrinkDataset(0.35d, 0.4d, 0.5d));
        drinks.put(TYPE_TEQUILA, new DrinkDataset(0.32d, 0.4d, 0.6d));
        drinks.put(TYPE_BRANDY, new DrinkDataset(0.4d, 0.5d, 0.6d));
        drinks.put(TYPE_WHISKEY_LIGHT, new DrinkDataset(0.4d, 0.4d, 0.4d));
        drinks.put(TYPE_WHISKEY_MEDIUM, new DrinkDataset(0.43d, 0.43d, 0.43d));
        drinks.put(TYPE_WHISKEY_HARD, new DrinkDataset(0.46d, 0.46d, 0.68d));
        drinks.put(TYPE_RUM, new DrinkDataset(0.35d, 0.35d, 0.8d));
        drinks.put(TYPE_ABSINTHE, new DrinkDataset(0.35d, 0.5d, 0.8d));
        drinks.put(TYPE_OTHER, new DrinkDataset(0.007d, 0.18d, 0.85d));
    }

    public static DrinkDataset getDrinkDataSet(@DrinkType int drinkType){
        return drinks.get(drinkType);
    }

    private final double alcoholTurnoversMin;
    private final double alcoholTurnoversRecommend;
    private final double alcoholTurnoversMax;

    private DrinkDataset(double alcoholTurnoversMin, double alcoholTurnoversRecommend, double alcoholTurnoversMax) {
        this.alcoholTurnoversMin = alcoholTurnoversMin;
        this.alcoholTurnoversRecommend = alcoholTurnoversRecommend;
        this.alcoholTurnoversMax = alcoholTurnoversMax;
    }

    public double getAlcoholTurnoversMin() {
        return alcoholTurnoversMin;
    }

    public double getAlcoholTurnoversRecommend() {
        return alcoholTurnoversRecommend;
    }

    public double getAlcoholTurnoversMax() {
        return alcoholTurnoversMax;
    }
}
