package com.devguys.itrevolutionhackaton.util.drink;

import com.devguys.itrevolutionhackaton.models.Drink;
import com.devguys.itrevolutionhackaton.util.AlgorithmUtills;

/**
 * Created by sergey on 05.11.17.
 */

public class DrinkFactory {
    public static Drink createDrink(double weight, double reductionCoefficient, double milliliters, double alcoholTurnovers, @DrinkDataset.DrinkType int drinkType){
        return createDrink(weight, reductionCoefficient, milliliters, alcoholTurnovers, drinkType, System.currentTimeMillis());
    }

    public static Drink createDrink(double weight, double reductionCoefficient,
                                    double milliliters, double alcoholTurnovers, @DrinkDataset.DrinkType int drinkType,
                                    long startInMillis){
        Drink drink = new Drink(milliliters, alcoholTurnovers, startInMillis, drinkType);
        drink.setEndTime(startInMillis + AlgorithmUtills.getMillisecondsFromHours(AlgorithmUtills.getAlcoEndTimeInHours(weight, reductionCoefficient, drink)));
        return drink;
    }
}
