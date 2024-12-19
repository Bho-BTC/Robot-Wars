package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Hibernate.Enums.MoveType;
import com.btcag.bootcamp.Maps.Map;
import com.btcag.bootcamp.Maps.MapView;
import com.btcag.bootcamp.Move.Move;
import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.PowerUps.PowerUpController;
import com.btcag.bootcamp.RobotPowerUp.RobotPowerUpController;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.Robots.RobotController;
import com.btcag.bootcamp.Robots.RobotView;
import com.btcag.bootcamp.User.User;

public class GameController {

    public static void takeTurn(Map map, User mainUser, Robot mainRobot, Robot[] robots, PowerUp[] powerUps, Walls[] walls) {
        while (mainRobot.getMovesLeft() > 0 && !GameValidationController.checkWin(robots)) {
            GameController.makeMove(mainRobot, robots, mainUser, map, powerUps, walls);

            mainRobot.setMovesLeft(mainRobot.getMovesLeft() - 1);
        }
        RobotPowerUpController.updateBuffs(mainRobot);
        mainRobot.setMovesLeft(mainRobot.getMovement());
        mainRobot.setHasAttackedThisRound(false);
    }

    public static void makeMove(Robot turningRobot, Robot[] robots, User user, Map map, PowerUp[] powerUps, Walls[] walls) {
        Move newMove = new Move();
        newMove.setUserId(user.getUserId());

        RobotView.printStats(turningRobot);
        String actionType = GameView.getActionType(user.getName(), turningRobot);


        switch (actionType) {
            //Bewegen
            case "1":

                newMove.setMoveType(MoveType.MOVE);
                newMove.setAlignment(GameView.getMoveDirection(turningRobot, robots, user.getName(), walls));
                break;

            //Angreifen
            case "2":
                newMove.setMoveType(MoveType.ATTACK);
                newMove.setAlignment(turningRobot.getAlignment());
                break;
            //Manuell Ausrichten
            case "3":
                //RobotController.align(turningRobot, GameView.getAlignDirection(user.getName()));
                newMove.setMoveType(MoveType.ALIGN);
                newMove.setAlignment(GameView.getAlignDirection(user.getName()));
                break;

            case "4":
                newMove.setMoveType(MoveType.END);
                newMove.setAlignment(turningRobot.getAlignment());
                break;

            case "5":
                newMove.setMoveType(MoveType.SURRENDER);
                newMove.setAlignment(turningRobot.getAlignment());
                break;
        }

        executeMove(newMove, turningRobot, robots, walls);

        checkPowerUp(turningRobot, powerUps);
        MapView.drawMap(map, robots, powerUps, walls);

    }

    public static void executeMove(Move move, Robot turningRobot, Robot[] robots, Walls[] walls) {
        switch (move.getMoveType()) {
            case MOVE:
                RobotController.moveRobot(turningRobot, move.getAlignment());
                break;

            case ATTACK:
                RobotController.attack(turningRobot, robots, walls);
                break;

            case ALIGN:
                RobotController.align(turningRobot, move.getAlignment());
                break;

            case END:
                RobotController.endTurn(turningRobot);
                break;

            case SURRENDER:
                RobotController.endSelfRobot(turningRobot);
                break;
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
