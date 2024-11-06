package com.btcag.bootcamp;

import com.btcag.bootcamp.PowerUps.DmgPowerUp;

public class Map {
    protected int maxX;
    protected int maxY;

    public Map(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void drawMap(Robot robot1, Robot robot2, DmgPowerUp dmgPowerUp) {
        int countY = 1;
        int countX = 1;
        String out;
        while (countY <= maxY) {
            System.out.println();
            while (countX <= maxX) {
                if (countY == dmgPowerUp.getY()  && countX == dmgPowerUp.getX()) {
                    out = dmgPowerUp.getAvatar();
                }else if (countY == robot1.getY() && countX == robot1.getX()) {
                    out = " " + robot1.getAvatar() + " ";

                } else if (countY == robot2.getY() && countX == robot2.getX()) {
                    out = " " + robot2.getAvatar() + " ";

                } else {
                    out = "   ";
                }
                System.out.print("["+out+"] ");
                countX++;
            }
            countY++;
            countX = 1;
        }
        System.out.println();
    }


}
