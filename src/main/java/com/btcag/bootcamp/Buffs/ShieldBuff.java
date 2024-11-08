package com.btcag.bootcamp.Buffs;

public class ShieldBuff {
    private final int buffValue = 2;
    private boolean isActive = false;


    public boolean getIsActive() {
        return isActive;
    }

    public int getBuffValue() {
        return buffValue;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }
}