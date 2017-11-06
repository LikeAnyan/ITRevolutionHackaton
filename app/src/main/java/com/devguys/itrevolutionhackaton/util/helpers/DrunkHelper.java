package com.devguys.itrevolutionhackaton.util.helpers;

import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Drink;
import com.devguys.itrevolutionhackaton.util.AlgorithmUtills;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sergey on 06.11.17.
 */

@SuppressWarnings("javadoc")
public class DrunkHelper {
    private DrunkHelper(){

    }

    public static double getAlcoholInBlood(Account account, List<Drink> drinkList){
        return AlgorithmUtills.widmarkAlgorithmCurrentTime(account.getWeight(), account.getReductionCoefficient(), drinkList);
    }

    /**
     *
     * @param account
     * @param drinks
     * @return in hours
     */
    public static int getDrunkTimeLeft(Account account, Drink... drinks){
        return (int) (AlgorithmUtills.widmarkAlgorithm(account.getWeight(), account.getReductionCoefficient(), drinks) / account.getReductionCoefficient());
    }

    public static List<PieEntry> getBeverageDrink(List<Drink> drinkList){
        Map map = getTypedDrinksMap(drinkList);
        List<PieEntry> pieEntries = new ArrayList<>();
        for(Object key : map.keySet()){
            pieEntries.add(new PieEntry((float) map.get(key), String.valueOf(key)));
        }
        return pieEntries;
    }

    public static Map getTypedDrinksMap(List<Drink> drinkList){
        Map map = new HashMap();
        for(Drink drink : drinkList){
            if(map.containsKey(drink.getType())){
                map.put(drink.getType(), (float) map.get(drink.getType()) + (float) drink.getMilliliters());
            } else{
                map.put(drink.getType(), (float) drink.getMilliliters());
            }
        }
        return map;
    }
}
