package com.devguys.itrevolutionhackaton.data.stores.drink;

import com.devguys.itrevolutionhackaton.data.models.DrinkModel;

import java.util.List;

import rx.Observable;

public interface DrinkStore {

    Observable<Void> saveDrink(DrinkModel drink);

    Observable<List<DrinkModel>> getDrinkList();
}
