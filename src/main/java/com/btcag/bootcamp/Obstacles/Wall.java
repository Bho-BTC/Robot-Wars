package com.btcag.bootcamp.Obstacles;

public class Wall extends Obstacles {

    public Wall(int x, int y, char avatar, boolean real) {
        this.x = x;
        this.y = y;
        this.avatar = avatar;
        this.onField = real;
    }

    public char getAvatar() {
        return avatar;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
