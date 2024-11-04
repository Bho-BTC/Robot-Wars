package com.btcag.bootcamp;

public class Map {
    protected int maxX;
    protected int maxY;

    public Map(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void drawMap(Robot robot1, Robot robot2) {
        int countY = 1;
        int countX = 1;
        while (countY <= maxY) {
            System.out.println();
            while (countX <= maxX) {
                if (countY == robot1.getY() && countX == robot1.getX()) {
                    System.out.print("[ " + robot1.getAvatar() + " ] ");
                    countX++;
                } else if (countY == robot2.getY() && countX == robot2.getX()) {
                    System.out.print("[ " + robot2.getAvatar() + " ] ");
                    countX++;
                } else {
                    System.out.print("[   ] ");
                    countX++;
                }
            }
            countY++;
            countX = 1;
        }
        System.out.println();
    }















}
