package com.btcag.bootcamp.Maps;

public class Map {

    protected char[] arrayVersion;
    protected int maxX;
    protected int maxY;

    public Map (int maxX, int maxY) {
        this.arrayVersion = new char[maxX*maxY];
        this.maxX = maxX;
        this.maxY = maxY;
    }


    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public char getSpace (int x, int y) {
        return arrayVersion[(y-1)*maxX + x];
    }

    public void setSpaceYX (int x, int y, char s) {
        arrayVersion[(y-1)*maxX + x] = s;
    }
}
