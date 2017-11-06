package com.devguys.itrevolutionhackaton.util.helpers;

import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Drink;
import com.devguys.itrevolutionhackaton.util.AlgorithmUtills;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;

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

    public static double getReductionCoefficient(boolean male, long birthdayTime){
        int diffYears = getDiffYears(new Date(birthdayTime), new Date(System.currentTimeMillis()));
        if(diffYears > 16){
            return male ? 0.7 : 0.6;
        } else{
            return male ? 0.59: 0.55;
        }
    }

    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(YEAR) - a.get(YEAR);
        if (a.get(MONTH) > b.get(MONTH) ||
                (a.get(MONTH) == b.get(MONTH) && a.get(DATE) > b.get(DATE))) {
            diff--;
        }
        return diff;
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
