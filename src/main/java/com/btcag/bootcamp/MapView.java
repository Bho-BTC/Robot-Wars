package com.btcag.bootcamp;

import com.btcag.bootcamp.PowerUps.PowerUps;

public class MapView {
    protected int maxX;
    protected int maxY;

    public MapView(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public void drawMap(Robot robot1, Robot robot2, PowerUps powerUps) {
        int countY = 1;
        int countX = 1;
        String out;
        while (countY <= maxY) {
            System.out.println();
            while (countX <= maxX) {
                if (countY == powerUps.getShieldPowerUp().getY() && countX == powerUps.getShieldPowerUp().getX()) {
                    out = powerUps.getShieldPowerUp().getAvatar();
                }else if (countY == powerUps.getRangePowerUp().getY() && countX == powerUps.getRangePowerUp().getX()) {
                    out = powerUps.getRangePowerUp().getAvatar();
                } else if (countY == powerUps.getDmgPowerUp().getY() && countX == powerUps.getDmgPowerUp().getX()) {
                    out = powerUps.getDmgPowerUp().getAvatar();
                } else if (countY == robot1.getY() && countX == robot1.getX()) {
                    out = " " + robot1.getAvatar() + " ";

                } else if (countY == robot2.getY() && countX == robot2.getX()) {
                    out = " " + robot2.getAvatar() + " ";

                } else {
                    out = "   ";
                }
                System.out.print("[" + out + "] ");
                countX++;
            }
            countY++;
            countX = 1;
        }
        System.out.println();
    }


}
