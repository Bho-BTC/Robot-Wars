package com.btcag.bootcamp.Maps;

import com.btcag.bootcamp.Obstacles.Obstacles;
import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.Robots.Robot;

public class MapView {
    public static void drawMap(Map map, Robot robot1, Robot robot2, PowerUp[] powerUps) {
        int countY = 1;
        int countX = 1;
        String wallAvatar = Walls.Wall1.key;
        String powerUpAvatar = "" + powerUps[0].getAvatar();
        String out;
        while (countY <= map.field.length) {
            System.out.println();
            while (countX <= map.field[1].length) {

                if (MapValidation.isWall(countX, countY)) {
                    out = wallAvatar;
                } else if (MapValidation.isPowerUp(countX, countY, powerUps)) {
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
