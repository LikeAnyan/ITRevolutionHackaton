package com.devguys.itrevolutionhackaton.data.mapper;

import com.devguys.itrevolutionhackaton.data.models.AccountModel;
import com.devguys.itrevolutionhackaton.models.Account;

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
}
