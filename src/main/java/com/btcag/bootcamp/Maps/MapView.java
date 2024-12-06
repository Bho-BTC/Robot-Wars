package com.btcag.bootcamp.Maps;

import com.btcag.bootcamp.Obstacles.Obstacles;
import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.Robots.Robot;

public class MapView {


    protected static boolean isWall(int countX, int countY) {
        for (Walls wall : Walls.values()) {
            if (countY == wall.y && countX == wall.x) {
                return true;
            }
        }
        return false;
    }


    protected static boolean isPowerUp(int countX, int countY, PowerUp[] powerUps) {
        for (PowerUp powerUp : powerUps) {
            if (countY == powerUp.getY() && countX == powerUp.getX() && powerUp.isOnField()) {
                return true;
            }
        }
        return false;
    }


    public static void drawMap(Map map, Robot robot1, Robot robot2, PowerUp[] powerUps) {
        int countY = 1;
        int countX = 1;
        String wallAvatar = Walls.Wall1.key;
        String powerUpAvatar = "" + powerUps[0].getAvatar();
        String out;
        while (countY <= map.field.length) {
            System.out.println();
            while (countX <= map.field[1].length) {

                if (isWall(countX, countY)) {
                    out = wallAvatar;
                } else if (isPowerUp(countX, countY, powerUps)) {
                    out = " " + powerUpAvatar + " ";
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
