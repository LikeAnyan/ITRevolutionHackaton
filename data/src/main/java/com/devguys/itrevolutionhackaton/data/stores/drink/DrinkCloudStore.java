package com.devguys.itrevolutionhackaton.data.stores.drink;

import com.devguys.itrevolutionhackaton.data.models.DrinkModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import rx.Observable;

public class DrinkCloudStore implements DrinkStore {

    private FirebaseAuth mAuth;
    private DatabaseReference database;

    public DrinkCloudStore(FirebaseAuth auth, FirebaseDatabase database) {
        this.mAuth = auth;
        this.database = database.getReference();
    }

    @Override
    public Observable<Void> saveDrink(DrinkModel drink) {
        return Observable.create(subscriber -> {
            if(mAuth.getCurrentUser() != null) {
                UUID uuid = UUID.randomUUID();
                DatabaseReference userRef = database.child("drinks").child(mAuth.getCurrentUser().getUid());
                userRef.push().setValue(uuid.toString());

                Map<String, Object> details = new HashMap<>();
                details.put("type", drink.getType());
                details.put("endTime", drink.getEndTime());
                details.put("startTime", drink.getStartTime());
                details.put("alcoholTurnovers", drink.getAlcoholTurnovers());
                details.put("milliliters", drink.getMilliliters());

                DatabaseReference drinksRef = userRef.child(uuid.toString());
                drinksRef.updateChildren(details);

                // update UI
                subscriber.onNext(null);
                subscriber.onCompleted();
            } else subscriber.onError(new Throwable("You don't sign in!"));
        });
    }

    @Override
    public Observable<List<DrinkModel>> getDrinkList() {
        return Observable.create(subscriber -> {
            if(mAuth.getCurrentUser() != null) {
                List<DrinkModel> drinkModels = new ArrayList<>();

                DatabaseReference drinks = database.child("drinks").child(mAuth.getCurrentUser().getUid());
                drinks.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            if(data.getKey().indexOf("-") != 0) {
                                DrinkModel model = data.getValue(DrinkModel.class);
                                drinkModels.add(model);
                            }
                        }

                        // update UI
                        subscriber.onNext(drinkModels);
                        subscriber.onCompleted();
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {}
                });

            } else subscriber.onError(new Throwable("You don't sign in!"));
        });
    }
}
