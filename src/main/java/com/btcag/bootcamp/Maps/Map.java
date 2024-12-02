package com.btcag.bootcamp.Maps;

public class Map {

    protected char[][] field;
    protected int maxX;
    protected int maxY;

    public Map (int maxX, int maxY) {
        this.field = new char[maxY][maxX];
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
        return field[y][x];
    }

    public void setSpaceYX (int x, int y, char s) {
        field[y][x] = s;
    }
}
