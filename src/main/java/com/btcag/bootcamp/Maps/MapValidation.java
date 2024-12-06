package com.btcag.bootcamp.Maps;

import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.PowerUps.PowerUp;

public class MapValidation {

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



}
