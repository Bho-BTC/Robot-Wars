package com.btcag.bootcamp.PowerUps;

import com.btcag.bootcamp.Robots.Robot;

import java.util.Random;

public class PowerUpController {


    public static int makeRandomBuffValue(int value) {
        Random random = new Random();

        int temp = random.nextInt(101);

        if (temp > 10) {
            return value;
        } else {
            return value * -1;
        }
    }

    public static void update(PowerUp powerUp) {
        if (!powerUp.isOnField()) {
            powerUp.setRoundsToRespawn(powerUp.getRoundsToRespawn() - 1);
            if (powerUp.getRoundsToRespawn() == 0) {
                powerUp.setOnField(true);
            }
        }
    }


    public static String chooseImpactedValue(PowerUp powerUp) {
        Random random = new Random();
        int temp = random.nextInt(100);

        if (temp > 66) {
            return "Dmg";
        } else if (temp > 33) {
            return "Range";
        } else {
            return "Movement";
        }

    }

    public static void pickedUpBy(Robot robot, PowerUp mainPowerUp) {

        String type = chooseImpactedValue(mainPowerUp);

        if (type.equals("Dmg")) {
            if (!robot.isDmgBuffActive()) {
                robot.setDmgBuffActive(true);
                robot.setDmg(robot.getDmg() + PowerUpController.makeRandomBuffValue(2));
                mainPowerUp.setOnField(false);
                System.out.println();
                System.out.println("Der Roboter " + robot.getAvatar() + " hat ein Damage PowerUp aufgehoben.");
            } else {
                System.out.println();
                System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits ein Damage PowerUp.");
                mainPowerUp.setOnField(false);
            }
        } else if (type.equals("Range")) {
            if (!robot.isRangeBuffActive()) {
                robot.setRangeBuffActive(true);
                robot.setRange(robot.getRange() + PowerUpController.makeRandomBuffValue(1));
                mainPowerUp.setOnField(false);
                System.out.println();
                System.out.println("Der Roboter " + robot.getAvatar() + " hat ein Range PowerUp aufgehoben.");
            } else {
                System.out.println();
                System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits ein Range PowerUp.");
                mainPowerUp.setOnField(false);
            }
        } else if (type.equals("Movement")) {
            if (!robot.isMovementBuffActive()) {
                robot.setMovementBuffActive(true);
                robot.setMovement(robot.getMovement() + PowerUpController.makeRandomBuffValue(1));
                mainPowerUp.setOnField(false);
                System.out.println();
                System.out.println("Der Roboter " + robot.getAvatar() + " hat ein Movement PowerUp aufgehoben.");
            } else {
                System.out.println();
                System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits ein Movement PowerUp.");
                mainPowerUp.setOnField(false);
            }
        }
    }
}
