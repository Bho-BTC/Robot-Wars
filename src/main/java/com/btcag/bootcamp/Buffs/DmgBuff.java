package com.btcag.bootcamp.Buffs;

public class DmgBuff {
    private final int buffValue = 2;
    private boolean isActive = false;


    public boolean getIsActive() {
        return isActive;
    }

    public int getBuffValue() {
        return buffValue;
    }

    public void setActive(boolean activity) {
        this.isActive = activity;
    }

}
