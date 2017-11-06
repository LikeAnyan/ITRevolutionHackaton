package com.devguys.itrevolutionhackaton;

import com.devguys.itrevolutionhackaton.models.Account;

public interface PreferencesManager {

    void clearSettings();

    void saveUserAccount(Account account);

    Account loadUserAccount();
}
