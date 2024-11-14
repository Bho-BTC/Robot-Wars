package com.btcag.bootcamp.Robots;

import com.btcag.bootcamp.Buffs.Buffs;

public class Robot {
    private int x;
    private int y;
    private String avatar;

    private int MaxLifePoints = 1;
    private int MaxEnergy = 1;
    private int MaxShield = 1;

    private int currentHp;
    private int currentEnergy;
    private int currentShield;
    private int dmg = 1;
    private int range = 1;
    private int areaOfEffect = 1;
    private int accuracy = 1;
    private int skillPoints = 10;
    private int movement = 3;

    public Buffs buffs;


    public Robot() {
        buffs = new Buffs();
        RobotView.chooseRobotAvatar(this, "Geben sie ein zugelassenes ASCII Zeichen an, mit dem der Roboter auf dem Spielfeld ausgegeben soll.");
        RobotController.getStats(this);
        this.currentHp = MaxLifePoints;
        this.currentEnergy = MaxEnergy;
        this.currentShield = MaxShield;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getAvatar() {
        return avatar;
    }

    public int getMaxLifePoints() {
        return MaxLifePoints;
    }

    public int getMaxEnergy() {
        return MaxEnergy;
    }

    public int getMaxShield() {
        return MaxShield;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public int getCurrentShield() {
        return currentShield;
    }

    public int getDmg() {
        return dmg;
    }

    public int getRange() {
        return range;
    }

    public int getAreaOfEffect() {
        return areaOfEffect;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getMovement() {
        return movement;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setMaxLifePoints(int maxLifePoints) {
        MaxLifePoints = maxLifePoints;
    }

    public void setMaxEnergy(int maxEnergy) {
        MaxEnergy = maxEnergy;
    }

    public void setMaxShield(int maxShield) {
        MaxShield = maxShield;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setCurrentShield(int currentShield) {
        this.currentShield = currentShield;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setAreaOfEffect(int areaOfEffect) {
        this.areaOfEffect = areaOfEffect;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getSkillPoints() {
        return skillPoints;
    }
}
