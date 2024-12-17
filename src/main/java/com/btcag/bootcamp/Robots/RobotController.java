package com.btcag.bootcamp.Robots;

import com.btcag.bootcamp.Game.GameValidationController;
import com.btcag.bootcamp.Move.Move;

public class RobotController {
    public static void moveRobot(Robot robot, alignment direction) {
                robot.setAlignment(direction);
                robot.setY(robot.getY() + direction.y);
                robot.setX(robot.getX() + direction.x);
    }



    public static void endTurn(Robot turningRobot) {
        turningRobot.setMovesLeft(0);
    }

    public static void endSelfRobot(Robot turningRobot) {
        turningRobot.setCurrentHp(0);
        endTurn(turningRobot);
    }


    public static void align(Robot turningRobot, alignment alignment) {
                turningRobot.setAlignment(alignment);
    }

    public static void attack(Robot turningRobot, Robot notTurningRobot) {
        turningRobot.setHasAttackedThisRound(true);
        if (GameValidationController.aligned(turningRobot, notTurningRobot)) {
            RobotController.hit(turningRobot, notTurningRobot);
            System.out.println();
        }
    }


    public static void hit(Robot robot, Robot targetRobot) {
        int tempDmg = robot.getDmg();

            targetRobot.setCurrentHp(targetRobot.getCurrentHp() - tempDmg);


        RobotView.printHitMessage(targetRobot);
    }


    public static void getStats(Robot robot) {
        int in;
        while (robot.getSkillPoints() > 0) {
            do {
                in = RobotView.getSkillpointInput(robot);
            } while (in != 1 && in != 2 && in != 3 && in != 4 );
            switch (in) {
                case 1:
                    robot.setMaxLifePoints(robot.getMaxLifePoints() + 1);
                    break;


                case 2:
                    robot.setDmg(robot.getDmg() + 1);
                    break;

                case 3:
                    robot.setRange(robot.getRange() + 1);
                    break;


                case 4:
                    robot.setMovement(robot.getMovement() + 1);
                    break;
            }
            robot.setSkillPoints(robot.getSkillPoints() - 1);
        }
        RobotView.printFinalStats(robot);

    }


}
