package com.devguys.itrevolutionhackaton.data;

import android.content.SharedPreferences;

import com.devguys.itrevolutionhackaton.PreferencesManager;
import com.devguys.itrevolutionhackaton.models.Account;
import com.google.gson.Gson;

public class PreferencesManagerImpl implements PreferencesManager {

    private static final String ACCOUNT_INFO = "account_info";

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
        String json = new Gson().toJson(account);
        preferences.edit().putString(ACCOUNT_INFO, json).apply();
    }

    @Override
    public Account loadUserAccount() {
        String json = preferences.getString(ACCOUNT_INFO, null);
        return json == null ? null : new Gson().fromJson(json, Account.class);
    }
}
