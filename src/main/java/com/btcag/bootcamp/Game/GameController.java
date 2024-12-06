package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Maps.Map;
import com.btcag.bootcamp.Maps.MapView;
import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.PowerUps.PowerUpController;
import com.btcag.bootcamp.RobotPowerUp.RobotPowerUpController;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.Robots.RobotController;
import com.btcag.bootcamp.Robots.RobotView;
import com.btcag.bootcamp.Robots.alignment;
import com.btcag.bootcamp.User.User;

public class GameController {

    public static void takeTurn(Map map, User mainUser, Robot mainRobot, Robot enemyRobot, PowerUp[] powerUps) {
        while (mainRobot.getMovesLeft() > 0) {
            GameController.takeAction(mainRobot, enemyRobot, mainUser.getName(), map, powerUps);

            mainRobot.setMovesLeft(mainRobot.getMovesLeft() - 1);
        }
        RobotPowerUpController.updateBuffs(mainRobot);
        mainRobot.setMovesLeft(mainRobot.getMovement());
        mainRobot.setHasAttackedThisRound(false);
    }



    public static void takeAction(Robot turningRobot, Robot notTurningRobot, String playerName, Map map, PowerUp[] powerUps) {
        RobotView.printStats(turningRobot);
        String actionType = GameView.getActionType(turningRobot, playerName);

        switch (actionType) {
            //Bewegen
            case "1":
                move(turningRobot, notTurningRobot, playerName, map, powerUps, GameView.getMoveDirection(turningRobot, notTurningRobot, playerName));
                break;

            //Angreifen
            case "2":
                if (turningRobot.isHasAttackedThisRound()) {
                    takeAction(turningRobot, notTurningRobot, playerName, map, powerUps);
                } else {
                    attack(turningRobot, notTurningRobot);
                }
                break;
            //Manuell Ausrichten
            case "3":
                align(turningRobot, GameView.getAlignDirection(turningRobot, GameView.getAlignDirection(turningRobot, playerName)));
                break;
        }
        checkPowerUp(turningRobot, powerUps);
        MapView.drawMap(map, turningRobot, notTurningRobot, powerUps);
    }


    public static void align(Robot turningRobot, String direction) {
        for (alignment alignment : alignment.values()) {
            if (direction.equals(alignment.key)) {
                turningRobot.setAlignment(alignment);
            }
        }
    }


    public static void attack(Robot turningRobot, Robot notTurningRobot) {
        turningRobot.setHasAttackedThisRound(true);
        if (GameValidationController.aligned(turningRobot, notTurningRobot)) {
            RobotController.hit(turningRobot, notTurningRobot);
            System.out.println();
        }
    }


    public static void move(Robot turningRobot, Robot notTurningRobot, String playerName, Map map, PowerUp[] powerUps, String direction) {

        switch (direction) {
            case "P":
                break;

            default:
                RobotController.moveRobot(turningRobot, direction);
        }

    }


    public static void checkPowerUp(Robot robot, PowerUp[] powerUps) {
        for (PowerUp powerUp : powerUps) {
            if (powerUp.isOnField() && powerUp.getY() == robot.getY() && powerUp.getX() == robot.getX()) {
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
