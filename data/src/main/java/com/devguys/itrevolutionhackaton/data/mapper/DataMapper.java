package com.devguys.itrevolutionhackaton.data.mapper;

import com.devguys.itrevolutionhackaton.data.models.AccountModel;
import com.devguys.itrevolutionhackaton.data.models.DrinkModel;
import com.devguys.itrevolutionhackaton.models.Account;
import com.devguys.itrevolutionhackaton.models.Drink;

import java.util.ArrayList;
import java.util.List;

public class DataMapper {

    public static Account transform(AccountModel accountModel) {
        Account account = new Account();

        if(accountModel != null) {
            account.setAvatar(accountModel.getAvatar());
            account.setMale(accountModel.isMale());
            account.setBirthday(accountModel.getBirthday());
            account.setUserName(accountModel.getUserName());
            account.setWeight(accountModel.getWeight());
        }

        return account;
    }

    public static AccountModel transform(Account account) {
        AccountModel accountModel = new AccountModel();

        if(account != null) {
            accountModel.setAvatar(account.getAvatar());
            accountModel.setMale(account.isMale());
            accountModel.setBirthday(account.getBirthday());
            accountModel.setUserName(account.getUserName());
            accountModel.setWeight(account.getWeight());
        }

        return accountModel;
    }

    public static DrinkModel transform(Drink drink) {
        DrinkModel drinkModel = new DrinkModel();

        if (drink != null) {
            drinkModel.setAlcoholTurnovers(drink.getAlcoholTurnovers());
            drinkModel.setEndTime(drink.getEndTime());
            drinkModel.setStartTime(drink.getStartTime());
            drinkModel.setMilliliters(drink.getMilliliters());
            drinkModel.setType(drink.getType());
        }

        return drinkModel;
    }

    public static Drink transform(DrinkModel drinkModel) {
        Drink drink = new Drink();

        if (drinkModel != null) {
            drink.setAlcoholTurnovers(drinkModel.getAlcoholTurnovers());
            drink.setEndTime(drinkModel.getEndTime());
            drink.setStartTime(drinkModel.getStartTime());
            drink.setMilliliters(drinkModel.getMilliliters());
            drink.setType(drinkModel.getType());
        }

        return drink;
    }

    public static List<Drink> transform(List<DrinkModel> drinkModels) {
        List<Drink> drinks = new ArrayList<>();

        if(drinkModels != null && !drinkModels.isEmpty()) {
            for (DrinkModel drinkModel : drinkModels) {
                if(drinkModel != null)
                    drinks.add(transform(drinkModel));
            }
        }

        return drinks;
    }
}
