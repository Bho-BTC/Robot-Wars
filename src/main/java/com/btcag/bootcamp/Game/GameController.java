package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Maps.Map;
import com.btcag.bootcamp.Maps.MapView;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.PowerUps.PowerUpController;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.Robots.RobotController;
import com.btcag.bootcamp.Robots.RobotView;
import com.btcag.bootcamp.User.User;
import com.btcag.bootcamp.Robots.alignment;

public class GameController {


    public static void moveRobot(Robot robot, String key) {
        for( alignment direction: alignment.values()) {
            if(key.equals(direction.key)) {
                robot.setY(robot.getY() + direction.y);
                robot.setX(robot.getX() + direction.x);
            }
        }

    }




    public static void turn(Robot turningRobot, Robot notTurningRobot, String playerName, Map map, PowerUp[] powerUps) {
        RobotView.printStats(turningRobot);

        String direction = GameView.getDirectionInput(turningRobot, notTurningRobot, playerName);
        switch (direction) {
            case "Q":
                moveRobot(turningRobot, direction);
//                turningRobot.setY(turningRobot.getY() + (alignment.NORTH_WEST.y));
//                turningRobot.setX(turningRobot.getX() + (alignment.NORTH_WEST.x));
                break;

            case "W":
                moveRobot(turningRobot, "W");
                // turningRobot.setY(turningRobot.getY() - 1);
                break;

            case "E":
                moveRobot(turningRobot, "E");
//                turningRobot.setY(turningRobot.getY() - 1);
//                turningRobot.setX(turningRobot.getX() + 1);
                break;

            case "A":
                moveRobot(turningRobot, "A");
//                turningRobot.setX(turningRobot.getX() - 1);
                break;

            case "D":
                moveRobot(turningRobot, "D");
//                turningRobot.setX(turningRobot.getX() + 1);
                break;

            case "Y":
                moveRobot(turningRobot, "Y");
//                turningRobot.setY(turningRobot.getY() + 1);
//                turningRobot.setX(turningRobot.getX() - 1);
                break;

            case "S":
                moveRobot(turningRobot, "S");
//                turningRobot.setY(turningRobot.getY() + 1);
                break;

            case "X":
                moveRobot(turningRobot, "X");
//                turningRobot.setY(turningRobot.getY() + 1);
//                turningRobot.setX(turningRobot.getX() + 1);
                break;

            case "P":
                break;
        }
        checkPowerUp(turningRobot, notTurningRobot, powerUps);
        MapView.drawMap(map, turningRobot, notTurningRobot, powerUps);
    }


    public static boolean afterTurnRangeCheck(Robot turningRobot, Robot notTurningRobot, String playerName) {
        if (GameValidationController.inRange(turningRobot, notTurningRobot )) {
            if(GameView.askWantAttack(playerName)){
                RobotController.hit(turningRobot, notTurningRobot);
                System.out.println();
                return true;
            }

        }
        System.out.println();
        return false;
    }


    public static void checkPowerUp(Robot robot, Robot robot2, PowerUp[] powerUps) {
        for (PowerUp powerUp : powerUps) {
            if(powerUp.isOnField() && powerUp.getY() == robot.getY() && powerUp.getX() == robot.getX()) {
                PowerUpController.pickedUpBy(robot, powerUp);
            }
        }
    }




    public static String getWinner(Robot robot1, Robot robot2, User user1, User user2) {
        if (robot1.getCurrentHp() < 1 && robot1.getCurrentHp() < robot2.getCurrentHp()) {
            return user2.getName();
        } else if (robot2.getCurrentHp() < 1 && robot2.getCurrentHp() < robot1.getCurrentHp()) {
            return user1.getName();
        } else {
            return "unentschieden";
        }
    }


}
