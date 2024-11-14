package com.btcag.bootcamp.Maps;

public class Map {


    protected int maxX;
    protected int maxY;

    public Map (int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }


    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }
}
