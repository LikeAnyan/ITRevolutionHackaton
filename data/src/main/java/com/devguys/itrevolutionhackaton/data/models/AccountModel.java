package com.devguys.itrevolutionhackaton.data.models;

public class AccountModel {

    private long id;
    private String userName; // sets by user
    private long birthday; // sets by user, need to determinate y.o., has influence on reductionCoefficient
    private boolean male; // sets by user, has influence on reductionCoefficient
    private double weight; // sets by user, has influence on reductionCoefficient
    private double reductionCoefficient; // sets by app, used in algorithm's
    private boolean useDevicesFingerprint; // sets by user in app to determinate use device's fingerprint or no


}
