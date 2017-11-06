package com.devguys.itrevolutionhackaton.data;

import android.content.SharedPreferences;

import com.devguys.itrevolutionhackaton.PreferencesManager;
import com.devguys.itrevolutionhackaton.models.Account;

public class PreferencesManagerImpl implements PreferencesManager {

    private SharedPreferences preferences;

    public PreferencesManagerImpl(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public void clearSettings() {
        preferences.edit().clear().apply();
    }

    @Override
    public void saveUserAccount(Account account) {

    }

    @Override
    public Account loadUserAccount() {
        return null;
    }
}
