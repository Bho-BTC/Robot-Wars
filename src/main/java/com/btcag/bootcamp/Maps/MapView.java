package com.btcag.bootcamp.Maps;

import com.btcag.bootcamp.Obstacles.Obstacles;
import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.Robots.RobotController;

public class MapView {
    public static void drawMap(Map map, Robot[] robots, PowerUp[] powerUps, Walls[] walls) {
        int countY = 0;
        int countX = 0;
        char wallAvatar = '/';
        char powerUpAvatar = powerUps[0].getAvatar();
        char out;
        while (countY < map.maxY) {
            System.out.println();
            while (countX < map.maxX) {
                if (MapValidation.isWall(countX, countY, walls)) {
                    out = wallAvatar;
                } else if (MapValidation.isPowerUp(countX, countY, powerUps)) {
                    out = powerUpAvatar;
                } else if (MapValidation.isRobot(countX,countY,robots)) {
                    out = RobotController.getRobotOnXY(countX,countY,robots).getAvatar();

                } else {
                    out = ' ';
                }
                if (out == wallAvatar) {
                    System.out.print("[" + out + out + out + "] ");
                } else {
                    System.out.print("[ " + out + " ] ");
                }

                countX++;
            }
            countY++;
            countX = 0;
        }
        for (char space : map.arrayVersion){
            System.out.print(space);
        }
        System.out.println();
    }


}
