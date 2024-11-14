package com.btcag.bootcamp.PowerUps;

import com.btcag.bootcamp.Robots.Robot;

import java.util.Random;

public class RangePowerUpController {

    public static void rerollXY(Robot robot1, Robot robot2, PowerUps powerUps) {
        Random random = new Random();
        int tempX;
        int tempY;
        do {
            do {
                tempX = random.nextInt(1, 15);
            } while (powerUps.getRangePowerUp().getX() == tempX);
            powerUps.getRangePowerUp().setX(tempX);


            do {
                tempY = random.nextInt(1, 15);
            } while (powerUps.getRangePowerUp().getY() == tempY);
            powerUps.getRangePowerUp().setY(tempY);
        } while (tempX == robot1.getX() && tempY == robot1.getY() || tempX == robot2.getX() && tempY == robot2.getY() ||
                tempX == powerUps.getDmgPowerUp().getX() && tempY == powerUps.getDmgPowerUp().getY() ||
                tempX == powerUps.getShieldPowerUp().getX() && tempY == powerUps.getShieldPowerUp().getY());


    }

    public static void pickedUpBy(Robot robot, Robot robot2, PowerUps powerUps) {
        if(!robot.buffs.rangeBuff.getIsActive()) {
            robot.buffs.rangeBuff.setActive(true);
            robot.setRange(robot.getRange() + robot.buffs.rangeBuff.getBuffValue());
            rerollXY(robot, robot2, powerUps);
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat das Range PowerUp aufgehoben.");
        }else{
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits eine Range PowerUp.");
            rerollXY(robot, robot2, powerUps);
        }
    }





}
