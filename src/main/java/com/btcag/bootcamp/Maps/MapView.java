package com.btcag.bootcamp.Maps;

import com.btcag.bootcamp.Obstacles.Obstacles;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.Robots.Robot;
import org.testng.collections.CollectionUtils;

public class MapView {


    protected static String checkForObstacle(int countX, int countY, Obstacles[] obstacles) {
        for(Obstacles obstacle : obstacles) {
            if( countY == obstacle.getY() && countX == obstacle.getX() && obstacle.isOnField()) {
               return ""+ obstacle.getAvatar();
            }

        }

    }


    public static void drawMap(Map map, Robot robot1, Robot robot2, PowerUp[] powerUps, Obstacles[] obstacles) {
        int countY = 1;
        int countX = 1;
        String out;
        while (countY <= map.field.length) {
            System.out.println();
            while (countX <= map.field[1].length) {


                if (countY == powerUps[0].getY() && countX == powerUps[0].getX() && powerUps[0].isOnField()) {
                    out = "" + powerUps[0].getAvatar();
                } else if (countY == powerUps[1].getY() && countX == powerUps[1].getX() && powerUps[1].isOnField()) {
                    out = "" + powerUps[1].getAvatar();
                } else if (countY == powerUps[2].getY() && countX == powerUps[2].getX() && powerUps[2].isOnField()) {
                    out = "" + powerUps[2].getAvatar();
                } else if (countY == robot1.getY() && countX == robot1.getX()) {
                    out = "" + robot1.getAvatar();

                } else if (countY == robot2.getY() && countX == robot2.getX()) {
                    out = "" + robot2.getAvatar();

                } else {
                    out = " ";
                }
                System.out.print("[ " + out + " ] ");
                countX++;
            }
            countY++;
            countX = 1;
        }
        System.out.println();
    }


}
