package com.btcag.bootcamp.Buffs;

public class ShieldRegen {
    private final int buffValue = 2;
    private boolean isActive =false;


    public boolean getIsActive() {
        return isActive;
    }

    public int getBuffValue() {
        return buffValue;
    }

    public void setActive(int active) {
        this.isActive = true;
    }
}
