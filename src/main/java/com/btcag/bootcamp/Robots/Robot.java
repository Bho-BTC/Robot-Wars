package com.btcag.bootcamp.Robots;

import com.btcag.bootcamp.Maps.Map;

public class Robot {
    private int x;
    private int y;
    private char avatar;
    private boolean dmgBuffActive;
    private boolean rangeBuffActive;
    private boolean movementBuffActive;

    private alignment alignment;
    private boolean hasAttackedThisRound = false;

    private int dmgBuffDuration;
    private int rangeBuffDuration;
    private int movementBuffDuration;

    private int gainedDmg;
    private int gainedRange;
    private int gainedMovement;

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
    private int movesLeft = movement;


    public int getMovesLeft() {
        return movesLeft;
    }

    public void setMovesLeft(int movesLeft) {
        this.movesLeft = movesLeft;
    }

    public Robot(int x, int y, Map map) {
        this.alignment = com.btcag.bootcamp.Robots.alignment.NORTH;
        this.x = x;
        this.y = y;
        RobotView.chooseRobotAvatar(this, "Geben sie ein zugelassenes ASCII Zeichen an, mit dem der Roboter auf dem Spielfeld ausgegeben soll.");
        RobotController.getStats(this);
        this.currentHp = MaxLifePoints;
        this.currentEnergy = MaxEnergy;
        this.currentShield = MaxShield;
        this.movesLeft = movement;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getAvatar() {
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

    public void setAvatar(char avatar) {
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

    public boolean isDmgBuffActive() {
        return dmgBuffActive;
    }

    public boolean isRangeBuffActive() {
        return rangeBuffActive;
    }

    public boolean isMovementBuffActive() {
        return movementBuffActive;
    }

    public void setDmgBuffActive(boolean dmgBuffActive) {
        this.dmgBuffActive = dmgBuffActive;
    }

    public void setRangeBuffActive(boolean rangeBuffActive) {
        this.rangeBuffActive = rangeBuffActive;
    }

    public void setMovementBuffActive(boolean movementBuffActive) {
        this.movementBuffActive = movementBuffActive;
    }

    public void setMovement(int movement) {
        this.movement = movement;
    }

    public int getGainedDmg() {
        return gainedDmg;
    }

    public int getGainedRange() {
        return gainedRange;
    }

    public int getGainedMovement() {
        return gainedMovement;
    }

    public void setGainedDmg(int gainedDmg) {
        this.gainedDmg = gainedDmg;
    }

    public void setGainedRange(int gainedRange) {
        this.gainedRange = gainedRange;
    }

    public void setGainedMovement(int gainedMovement) {
        this.gainedMovement = gainedMovement;
    }

    public void setDmgBuffDuration(int dmgBuffDuration) {
        this.dmgBuffDuration = dmgBuffDuration;
    }

    public void setRangeBuffDuration(int rangeBuffDuration) {
        this.rangeBuffDuration = rangeBuffDuration;
    }

    public void setMovementBuffDuration(int movementBuffDuration) {
        this.movementBuffDuration = movementBuffDuration;
    }

    public int getDmgBuffDuration() {
        return dmgBuffDuration;
    }

    public int getRangeBuffDuration() {
        return rangeBuffDuration;
    }

    public int getMovementBuffDuration() {
        return movementBuffDuration;
    }

    public boolean isHasAttackedThisRound() {
        return hasAttackedThisRound;
    }

    public void setHasAttackedThisRound(boolean hasAttackedThisRound) {
        this.hasAttackedThisRound = hasAttackedThisRound;
    }

    public com.btcag.bootcamp.Robots.alignment getAlignment() {
        return alignment;
    }

    public void setAlignment(com.btcag.bootcamp.Robots.alignment alignment) {
        this.alignment = alignment;
    }
}