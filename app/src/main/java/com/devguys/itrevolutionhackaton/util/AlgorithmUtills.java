package com.devguys.itrevolutionhackaton.util;

import android.util.Log;

import com.devguys.itrevolutionhackaton.models.Drink;

/**
 * Created by sergeyboy on 04.11.17.
 */

@SuppressWarnings({"javadoc", "unused"})
public class AlgorithmUtills {
    private final static String TAG = AlgorithmUtills.class.getName();

    private final static double SPIRT_DENSITY = 0.789;

    private AlgorithmUtills(){

    }

    /**
     * @param grams
     * @param density grams/milliliters
     * @return
     */
    public static double transformToMilliliters(double grams, double density){
        if(density == 0d){
            Log.e(TAG, "transformToMilliliters, division by 0! Density: " + density);
            return 0;
        }
        return grams/density;
    }

    /**
     * @param milliliters
     * @param density grams/milliliters
     * @return
     */
    public static double transformToGrams(double milliliters, double density){
        return milliliters * density;
    }

    /**
     *
     * @param drinkMilliliters
     * @param alcoholTurnovers maxValue 1
     * @return
     */
    public static double getClearAlcohol(double drinkMilliliters, double alcoholTurnovers){
        return drinkMilliliters * alcoholTurnovers;
    }

    public static double getClearAlcoholInGrams(double drinkMilliliters, double alcoholTurnovers){
        double clearAlcoholInMilliliters = getClearAlcohol(drinkMilliliters, alcoholTurnovers);
        return transformToGrams(clearAlcoholInMilliliters, SPIRT_DENSITY);
    }

    public static double getClearAlcoholInGrams(Drink drink){
        return getClearAlcoholInGrams(drink.getMilliliters(), drink.getAlcoholTurnovers());
    }

    /**
     *
     * @param clearAlcoholInGrams
     * @param weight
     * @param reductionCoefficient
     * @return how much alc. in blood
     */
    public static double widmarkAlgorithm(double clearAlcoholInGrams, double weight, double reductionCoefficient){
        if(weight == 0d || reductionCoefficient == 0d){
            Log.e(TAG, "widmarkAlgorithm, division by 0! Weight: " + weight + ", reductionCoefficient: " + reductionCoefficient);
            return 0;
        }
        double result = (clearAlcoholInGrams - (clearAlcoholInGrams * 0.3)) / (weight * reductionCoefficient);
        if(result >= 0d){
            return result;
        } else{
            return 0;
        }
    }

    public static double improvedWidmarkAlgorithm(double clearAlcoholInGrams, double weight, double reductionCoefficient, long startTimeStamp, long currentTimeStamp){
        double result = widmarkAlgorithm(clearAlcoholInGrams, weight, reductionCoefficient) - ((reductionCoefficient / 10 + 0.1d) * getHoursFromMilliseconds(currentTimeStamp - startTimeStamp));
        if(result >= 0d){
            return result;
        } else{
            return 0;
        }
    }

    public static double widmarkAlgorithmCurrentTime(double clearAlcoholInGrams, double weight, double reductionCoefficient, long startTimestamp){
        return improvedWidmarkAlgorithm(clearAlcoholInGrams, weight, reductionCoefficient, startTimestamp, System.currentTimeMillis());
    }

    public static int getHoursFromMilliseconds(long milliseconds){
        return (int) (milliseconds / 3600000);
    }

    public static long getMillisecondsFromHours(int hours){
        return (long) hours * 3600000;
    }

    public static double widmarkAlgorithm(double weight, double reductionCoefficient, Drink... drinks){
        double result = 0d;
        for(Drink drink : drinks){
            result += widmarkAlgorithm(getClearAlcoholInGrams(drink), weight, reductionCoefficient);
        }
        return result;
    }

    public static double improvedWidmarkAlgorithm(double weight, double reductionCoefficient, long startTimestamp, long currentTimestamp, Drink... drinks){
        double result = 0d;
        for(Drink drink : drinks){
            result += improvedWidmarkAlgorithm(getClearAlcoholInGrams(drink), weight, reductionCoefficient, startTimestamp, currentTimestamp);
        }
        return result;
    }

    public static double widmarkAlgorithmCurrentTime(double weight, double reductionCoefficient, long startTimestamp, Drink... drinks){
        long currentTimestamp = System.currentTimeMillis();
        return improvedWidmarkAlgorithm(weight, reductionCoefficient, startTimestamp, currentTimestamp, drinks);
    }

    public static int getAlcoEndTimeInHours(double weight, double reductionCoefficient, Drink... drinks){
        return (int) (widmarkAlgorithm(weight, reductionCoefficient, drinks) / (reductionCoefficient / 10 + 0.1d));
    }
}
