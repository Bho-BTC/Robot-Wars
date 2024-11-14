package com.btcag.bootcamp.PowerUps;

import com.btcag.bootcamp.Robots.Robot;

import java.util.Random;

public class DmgPowerUpController {

    public static void rerollXY(Robot robot1, Robot robot2, PowerUps powerUps) {
        Random random = new Random();
        int tempX;
        int tempY;
        do {
            do {
                tempX = random.nextInt(1, 15);
            } while (powerUps.getDmgPowerUp().getX() == tempX);
            robot1.setX(tempX);


            do {
                tempY = random.nextInt(1, 15);
            } while (powerUps.getDmgPowerUp().getY() == tempY);
            powerUps.getDmgPowerUp(). setY(tempY);
        } while (tempX == robot1.getX() && tempY == robot1.getY() || tempX == robot2.getX() && tempY == robot2.getY() ||
                tempX == powerUps.getRangePowerUp().getX() && tempY == powerUps.getRangePowerUp().getY() ||
                tempX == powerUps.getShieldPowerUp().getX() && tempY == powerUps.getShieldPowerUp().getY());
    }

    public  static void pickedUpBy(Robot robot, Robot robot2, PowerUps powerUps) {

        if (!robot.buffs.dmgBuff.getIsActive()) {
            robot.buffs.dmgBuff.setActive(true);
            robot.setDmg(robot.getDmg() + robot.buffs.dmgBuff.getBuffValue());
            rerollXY(robot, robot2, powerUps );
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat das Damage PowerUp aufgehoben.");
        }else{
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits ein Damage PowerUp.");
            rerollXY(robot, robot2, powerUps);
        }

    }






}
