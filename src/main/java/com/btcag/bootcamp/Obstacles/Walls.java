package com.btcag.bootcamp.Obstacles;

public enum Walls {
    Wall1(5, 7, "///"),
    Wall2(5, 6, "///"),
    Wall3(5, 5, "//"),
    Wall4(10, 5, "///"),
    Wall5(10, 6, "///"),
    Wall6(10, 7, "///"),
    Wall7(7, 6, "///"),
    Wall8(7, 8, "///"),
    ;

    public final int x;
    public final int y;
    public final String key;

    Walls(int x, int y, String key) {
        this.x = x;
        this.y = y;
        this.key = key;

    }

}
