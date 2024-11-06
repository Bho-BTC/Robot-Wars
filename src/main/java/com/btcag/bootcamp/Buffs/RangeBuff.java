package com.btcag.bootcamp.Buffs;

public class RangeBuff {
    private final int buffValue = 1;
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
