package com.devguys.itrevolutionhackaton.view.fingerprint;

import com.devguys.itrevolutionhackaton.base.CoreView;

/**
 * Created by sergey on 06.11.17.
 */

public interface FingerprintView extends CoreView {
    void onAuthSuccess();
    void onAuthFailed();
    void onLogout();
}
