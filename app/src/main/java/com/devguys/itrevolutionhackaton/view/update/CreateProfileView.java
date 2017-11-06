package com.devguys.itrevolutionhackaton.view.update;

import com.devguys.itrevolutionhackaton.base.CoreView;

public interface CreateProfileView extends CoreView {

    void updateProfileSucceeded();

    void updateProfileFailed(String message);
}
