package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Maps.Map;
import com.btcag.bootcamp.Maps.MapView;
import com.btcag.bootcamp.PowerUps.DmgPowerUpController;
import com.btcag.bootcamp.PowerUps.PowerUps;
import com.btcag.bootcamp.PowerUps.RangePowerUpController;
import com.btcag.bootcamp.PowerUps.ShieldPowerUpController;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.Robots.RobotController;
import com.btcag.bootcamp.Robots.RobotView;
import com.btcag.bootcamp.User.User;

public class GameController {


    public static void turn(Robot turningRobot, Robot notTurningRobot, String playerName, PowerUps powerUps, Map map) {
        MapView.drawMap(map, turningRobot, notTurningRobot, powerUps);
        RobotView.printStats(turningRobot);

        String direction = GameView.getDirectionInput(turningRobot, notTurningRobot, playerName);
        switch (direction) {
            case "Q":
                turningRobot.setY(turningRobot.getY() - 1);
                turningRobot.setX(turningRobot.getX() - 1);
                break;

            case "W":
                turningRobot.setY(turningRobot.getY() - 1);
                break;

            case "E":
                turningRobot.setY(turningRobot.getY() - 1);
                turningRobot.setX(turningRobot.getX() + 1);
                break;

            case "A":
                turningRobot.setX(turningRobot.getX() - 1);
                break;

            case "D":
                turningRobot.setX(turningRobot.getX() + 1);
                break;

            case "Y":
                turningRobot.setY(turningRobot.getY() + 1);
                turningRobot.setX(turningRobot.getX() - 1);
                break;

            case "S":
                turningRobot.setY(turningRobot.getY() + 1);
                break;

            case "X":
                turningRobot.setY(turningRobot.getY() + 1);
                turningRobot.setX(turningRobot.getX() + 1);
                break;

            case "P":
                break;
        }
        checkDmgPowerUp(turningRobot, notTurningRobot, powerUps);
        checkShieldPowerUp(turningRobot, notTurningRobot, powerUps);
        checkRangePowerUp(turningRobot, notTurningRobot, powerUps);
    }


    public static void afterTurnRangeCheck(Robot turningRobot, Robot notTurningRobot, Map map, PowerUps powerUps) {
        MapView.drawMap(map, turningRobot, notTurningRobot, powerUps);
        if (GameValidationController.inRange(turningRobot, notTurningRobot )) {
            RobotController.hit(turningRobot, notTurningRobot);
            System.out.println();

        }
    }


    public static void checkDmgPowerUp(Robot robot, Robot robot2, PowerUps powerUps) {
        if (robot.getX() == powerUps.getDmgPowerUp().getX() && robot.getY() == powerUps.getDmgPowerUp().getY()) {
            DmgPowerUpController.pickedUpBy(robot, robot2, powerUps);
        }
    }

    public static void checkRangePowerUp(Robot robot, Robot robot2, PowerUps powerUps) {
        if (robot.getX() == powerUps.getRangePowerUp().getX() && robot.getY() == powerUps.getRangePowerUp().getY()) {
            RangePowerUpController.pickedUpBy(robot, robot2, powerUps);
        }
    }

    public static void checkShieldPowerUp(Robot robot, Robot robot2, PowerUps powerUps) {
        if (robot.getX() == powerUps.getShieldPowerUp().getX() && robot.getY() == powerUps.getShieldPowerUp().getY()) {
            ShieldPowerUpController.pickedUpBy(robot, robot2, powerUps);
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
