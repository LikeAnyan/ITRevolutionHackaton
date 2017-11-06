package com.devguys.itrevolutionhackaton.models;

@SuppressWarnings("unused")
public class Account {

    private String userName; // sets by user
    private String avatar;
    private long birthday; // sets by user, need to determinate y.o., has influence on reductionCoefficient
    private boolean male; // sets by user, has influence on reductionCoefficient
    private double weight; // sets by user, has influence on reductionCoefficient
    private double reductionCoefficient; // sets by app, used in algorithm's
    private boolean useDevicesFingerprint; // sets by user in app to determinate use device's fingerprint or no

    public Account() {

    }

    public Account(String userName, long birthday, boolean male, double weight, double reductionCoefficient, boolean useDevicesFingerprint) {
        this.userName = userName;
        this.birthday = birthday;
        this.male = male;
        this.weight = weight;
        this.reductionCoefficient = reductionCoefficient;
        this.useDevicesFingerprint = useDevicesFingerprint;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setReductionCoefficient(double reductionCoefficient) {
        this.reductionCoefficient = reductionCoefficient;
    }

    public void setUseDevicesFingerprint(boolean useDevicesFingerprint) {
        this.useDevicesFingerprint = useDevicesFingerprint;
    }

    public String getUserName() {
        return userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public long getBirthday() {
        return birthday;
    }

    public boolean isMale() {
        return male;
    }

    public double getWeight() {
        return weight;
    }

    public double getReductionCoefficient() {
        return reductionCoefficient;
    }

    public boolean isUseDevicesFingerprint() {
        return useDevicesFingerprint;
    }
}
