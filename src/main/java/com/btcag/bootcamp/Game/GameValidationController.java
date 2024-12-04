package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.PowerUps.PowerUpController;
import com.btcag.bootcamp.Robots.Robot;

public class GameValidationController {

    public static boolean checkWin(Robot robot1, Robot robot2) {
        return !(robot1.getCurrentHp() > 0) || !(robot2.getCurrentHp() > 0);
    }

    public static boolean validDirection(String direction, Robot turningRobot, Robot notTurningRobot) {
        if (!direction.equals("Q") && !direction.equals("W") && !direction.equals("E")
                && !direction.equals("A") && !direction.equals("S") && !direction.equals("D")
                && !direction.equals("Y") && !direction.equals("X") && !direction.equals("P")) {
            return false;//wenn Richtung nicht W, A, S, D oder P dann falsch
        }
        switch (direction) {
            case "Q":
                if (turningRobot.getX() - 1 == notTurningRobot.getX() && turningRobot.getY() - 1 == notTurningRobot.getY()
                        || turningRobot.getX() - 1 < 1 || turningRobot.getY() - 1 < 1) {
                    return false;
                }
                break;

            case "W":
                if (turningRobot.getY() - 1 == notTurningRobot.getY() && turningRobot.getX() == notTurningRobot.getX() || turningRobot.getY() - 1 < 1) {
                    return false;
                }
                break;

            case "E":
                if (turningRobot.getX() + 1 == notTurningRobot.getX() && turningRobot.getY() - 1 == notTurningRobot.getY()
                        || turningRobot.getX() + 1 > 15 || turningRobot.getY() - 1 < 1) {
                    return false;
                }
                break;

            case "A":
                if (turningRobot.getX() - 1 == notTurningRobot.getX() && turningRobot.getY() == notTurningRobot.getY() || turningRobot.getX() - 1 < 1) {
                    return false;
                }
                break;

            case "D":
                if (turningRobot.getX() + 1 == notTurningRobot.getX() && turningRobot.getY() == notTurningRobot.getY() || turningRobot.getX() + 1 > 15) {
                    return false;
                }
                break;

            case "Y":
                if (turningRobot.getX() - 1 == notTurningRobot.getX() && turningRobot.getY() + 1 == notTurningRobot.getY()
                        || turningRobot.getX() - 1 < 1 || turningRobot.getY() + 1 > 15) {
                    return false;
                }
                break;

            case "X":
                if (turningRobot.getX() + 1 == notTurningRobot.getX() && turningRobot.getY() + 1 == notTurningRobot.getY()
                        || turningRobot.getX() + 1 > 15 || turningRobot.getY() + 1 > 15) {
                    return false;
                }
                break;


            case "S":
                if (turningRobot.getY() + 1 == notTurningRobot.getY() && turningRobot.getX() == notTurningRobot.getX() || turningRobot.getY() + 1 > 15) {
                    return false;
                }
                break;


            case "P":
                break;
        }
        return true;
    }






    public static boolean inRange(Robot robot1, Robot robot2) {
        //check ob robot2 x in range von robot1 x ist
        //Rechts und Oben
        if ((robot1.getX() + robot1.getRange() >= robot2.getX() && robot2.getX() >= robot1.getX()) && (robot1.getY() + robot1.getRange() >= robot2.getY() && robot2.getY() >= robot1.getY())
                //Rechts und Unten
                || (robot1.getX() + robot1.getRange() >= robot2.getX() && robot2.getX() >= robot1.getX()) && (robot1.getY() - robot1.getRange() <= robot2.getY() && robot2.getY() <= robot1.getY())
                //Rechts und Oben
                || (robot1.getX() - robot1.getRange() <= robot2.getX() && robot2.getX() <= robot1.getX()) && (robot1.getY() + robot1.getRange() >= robot2.getY() && robot2.getY() >= robot1.getY())
                //Links und Unten
                || (robot1.getX() - robot1.getRange() <= robot2.getX() && robot2.getX() <= robot1.getX()) && (robot1.getY() - robot1.getRange() <= robot2.getY() && robot2.getY() <= robot1.getY())) {
            //Links und Oben
            return true;
        } else {
            return false;
        }
    }


}
