package com.btcag.bootcamp.RobotPowerUp;

import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.PowerUps.PowerUpController;
import com.btcag.bootcamp.Robots.Robot;

public class RobotPowerUpController {


    public static void applyDmgPowerUp (Robot robot, PowerUp powerUp, int dmg) {
        if (!robot.isDmgBuffActive()) {
            robot.setDmgBuffActive(true);
            robot.setDmg(robot.getDmg() + PowerUpController.makeRandomBuffValue(dmg));
            powerUp.setOnField(false);
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat ein Damage PowerUp aufgehoben.");
        } else {
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits ein Damage PowerUp.");
            powerUp.setOnField(false);
        }
    }

    public  static void applyRangePowerUp (Robot robot, PowerUp powerUp, int range) {
        if (!robot.isRangeBuffActive()) {
            robot.setRangeBuffActive(true);
            robot.setRange(robot.getRange() + PowerUpController.makeRandomBuffValue(range));
            powerUp.setOnField(false);
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat ein Range PowerUp aufgehoben.");
        } else {
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits ein Range PowerUp.");
            powerUp.setOnField(false);
        }
    }

    public static void applyMovementPowerUp (Robot robot, PowerUp powerUp, int movement) {
        if (!robot.isMovementBuffActive()) {
            robot.setMovementBuffActive(true);
            robot.setMovement(robot.getMovement() + PowerUpController.makeRandomBuffValue(movement));
            powerUp.setOnField(false);
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat ein Movement PowerUp aufgehoben.");
        } else {
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits ein Movement PowerUp.");
            powerUp.setOnField(false);
        }
    }






}
