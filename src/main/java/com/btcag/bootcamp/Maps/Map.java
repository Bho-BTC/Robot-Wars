package com.btcag.bootcamp.Maps;

import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.PowerUps.PowerUp;

public class Map {

    protected char[] arrayVersion;
    protected int maxX;
    protected int maxY;
    protected char powerUpChar = 63;
    protected char wallChar = '/';
    protected char robotChar = 'R';


    public Map(int maxX, int maxY) {
        this.arrayVersion = new char[maxX * maxY];
        this.maxX = maxX;
        this.maxY = maxY;

        arrayVersion[96] = powerUpChar;
        arrayVersion[112] = powerUpChar;
        arrayVersion[128] = powerUpChar;

        arrayVersion[85] = wallChar;
        arrayVersion[95] = wallChar;
        arrayVersion[100] = wallChar;
        arrayVersion[110] = wallChar;

        arrayVersion[105] = robotChar;
        arrayVersion[119] = robotChar;
    }

    public char getPowerUpChar() {
        return powerUpChar;
    }

    public char getWallChar() {
        return wallChar;
    }

    public char getRobotChar() {
        return robotChar;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public char getSpace(int x, int y) {
        return arrayVersion[(y - 1) * maxX + x];
    }

    public void setSpaceYX(int x, int y, char s) {
        arrayVersion[(y - 1) * maxX + x] = s;
    }
}
