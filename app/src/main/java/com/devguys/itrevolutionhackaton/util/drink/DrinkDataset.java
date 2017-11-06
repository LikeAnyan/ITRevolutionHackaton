package com.devguys.itrevolutionhackaton.util.drink;

import android.content.res.Resources;
import android.support.annotation.IntDef;

import com.devguys.itrevolutionhackaton.ITRevolutionApp;
import com.devguys.itrevolutionhackaton.R;

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

    public static @DrinkType int getType(String name){
        if(name.equals(getName(TYPE_KVASS))){
            return TYPE_KVASS;
        } else if(name.equals(getName(TYPE_BEER_LIGHT))){
            return TYPE_BEER_LIGHT;
        } else if(name.equals(getName(TYPE_BEER_DARK))){
            return TYPE_BEER_DARK;
        } else if(name.equals(getName(TYPE_VINE))){
            return TYPE_VINE;
        } else if(name.equals(getName(TYPE_TINCTURE))){
            return TYPE_TINCTURE;
        } else if(name.equals(getName(TYPE_LIQUOR))){
            return TYPE_LIQUOR;
        } else if(name.equals(getName(TYPE_VODKA))){
            return TYPE_VODKA;
        } else if(name.equals(getName(TYPE_TEQUILA))){
            return TYPE_TEQUILA;
        } else if(name.equals(getName(TYPE_BRANDY))){
            return TYPE_BRANDY;
        } else if(name.equals(getName(TYPE_WHISKEY_LIGHT))){
            return TYPE_WHISKEY_LIGHT;
        } else if(name.equals(getName(TYPE_WHISKEY_MEDIUM))){
            return TYPE_WHISKEY_MEDIUM;
        } else if(name.equals(getName(TYPE_WHISKEY_HARD))){
            return TYPE_WHISKEY_HARD;
        } else if(name.equals(getName(TYPE_RUM))){
            return TYPE_RUM;
        } else if(name.equals(getName(TYPE_ABSINTHE))){
            return TYPE_ABSINTHE;
        } else{
            return TYPE_OTHER;
        }
    }

    public static String getName(@DrinkType int drinkType) {
        Resources resources = ITRevolutionApp.get().getResources();
        switch (drinkType) {
            case TYPE_KVASS:
                return resources.getString(R.string.kvas);
            case TYPE_BEER_LIGHT:
                return resources.getString(R.string.beer_light);
            case TYPE_BEER_DARK:
                return resources.getString(R.string.beer_dark);
            case TYPE_VINE:
                return resources.getString(R.string.vine);
            case TYPE_TINCTURE:
                return resources.getString(R.string.tincture);
            case TYPE_LIQUOR:
                return resources.getString(R.string.liquor);
            case TYPE_VODKA:
                return resources.getString(R.string.vodka);
            case TYPE_TEQUILA:
                return resources.getString(R.string.tequila);
            case TYPE_BRANDY:
                return resources.getString(R.string.brandy);
            case TYPE_WHISKEY_LIGHT:
                return resources.getString(R.string.whiskey_light);
            case TYPE_WHISKEY_MEDIUM:
                return resources.getString(R.string.whiskey_medium);
            case TYPE_WHISKEY_HARD:
                return resources.getString(R.string.whiskey_hard);
            case TYPE_RUM:
                return resources.getString(R.string.rum);
            case TYPE_ABSINTHE:
                return resources.getString(R.string.absinthe);
            case TYPE_OTHER:
                return resources.getString(R.string.other);
        }

        return "Other";
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
