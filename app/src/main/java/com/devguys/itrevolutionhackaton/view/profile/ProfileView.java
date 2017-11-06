package com.devguys.itrevolutionhackaton.view.profile;

import com.devguys.itrevolutionhackaton.base.CoreView;
import com.devguys.itrevolutionhackaton.models.Drink;

import java.util.List;

/**
 * Created by sergey on 05.11.17.
 */

public interface ProfileView extends CoreView {

    void updateStatistic(List<Drink> drinks);

    void updateBloodLevel(List<Drink> drinks);
}
