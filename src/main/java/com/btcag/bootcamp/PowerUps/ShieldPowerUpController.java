package com.btcag.bootcamp.PowerUps;

import com.btcag.bootcamp.Robot;

import java.util.Random;

public class ShieldPowerUpController {

    public static void rerollXY(Robot robot1, Robot robot2, PowerUps powerUps) {
        Random random = new Random();
        int tempX;
        int tempY;
        do {
            do {
                tempX = random.nextInt(1, 15);
            } while (powerUps.getShieldPowerUp().getX() == tempX);
            powerUps.getShieldPowerUp().setX(tempX);


            do {
                tempY = random.nextInt(1, 15);
            } while (powerUps.getShieldPowerUp().getY() == tempY);
            powerUps.getShieldPowerUp().setY(tempY);
        } while (tempX == robot1.getX() && tempY == robot1.getY() || tempX == robot2.getX() && tempY == robot2.getY() ||
                tempX == powerUps.getDmgPowerUp().getX() && tempY == powerUps.getDmgPowerUp().getY() ||
                tempX == powerUps.getRangePowerUp().getX() && tempY == powerUps.getRangePowerUp().getY());


    }

    public static void pickedUpBy(Robot robot, Robot robot2, PowerUps powerUps) {
        robot.setCurrentShield(robot.getCurrentShield() + robot.buffs.shieldBuff.getBuffValue());
        rerollXY(robot, robot2, powerUps);
        System.out.println();
        System.out.println("Der Roboter " + robot.getAvatar() + " hat das Range PowerUp aufgehoben.");
    }

}
