package com.btcag.bootcamp.Maps;

import com.btcag.bootcamp.Obstacles.Obstacles;
import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.Robots.Robot;

public class MapView {
    public static void drawMap(Map map, Robot robot1, Robot robot2, PowerUp[] powerUps) {
        int countY = 1;
        int countX = 1;
        char wallAvatar = Walls.Wall1.key;
        char powerUpAvatar = powerUps[0].getAvatar();
        char out;
        while (countY <= map.maxY) {
            System.out.println();
            while (countX <= map.maxX) {
                if (MapValidation.isWall(countX, countY)) {
                    out = wallAvatar;
                } else if (MapValidation.isPowerUp(countX, countY, powerUps)) {
                    out = powerUpAvatar;
                } else if (countY == robot1.getY() && countX == robot1.getX()) {
                    out = robot1.getAvatar();

                } else if (countY == robot2.getY() && countX == robot2.getX()) {
                    out = robot2.getAvatar();

                } else {
                    out = ' ';
                }
                if (out == wallAvatar) {
                    System.out.print("[" + out + out + out + "] ");
                } else {
                    System.out.print("[ " + out + " ] ");
                }
                map.arrayVersion[(countY - 1) * map.maxX + countX-1] = out;
                countX++;
            }
            countY++;
            countX = 1;
        }
        for (char space : map.arrayVersion){
            System.out.print(space);
        }
        System.out.println();
    }


}
