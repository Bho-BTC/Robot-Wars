package com.btcag.bootcamp.PowerUps;

import com.btcag.bootcamp.Robot;

import java.util.Random;

public class RangePowerup {

    private int x = 0;
    private int y = 0;
    private final String avatar = "(R)";




    public void rerollXY(Robot robot1, Robot robot2, PowerUps powerUps) {
        Random random = new Random();
        int tempX;
        int tempY;
        do {
            do {
                tempX = random.nextInt(1, 15);
            } while (this.x == tempX);
            this.x = tempX;


            do {
                tempY = random.nextInt(1, 15);
            } while (this.y == tempY);
            this.y = tempY;
        } while (tempX == robot1.getX() && tempY == robot1.getY() || tempX == robot2.getX() && tempY == robot2.getY() ||
                tempX == powerUps.getDmgPowerUp().getX() && tempY == powerUps.getDmgPowerUp().getY() ||
                tempX == powerUps.getShieldPowerUp().getX() && tempY == powerUps.getShieldPowerUp().getY());


    }

    public void pickedUpBy(Robot robot, Robot robot2, PowerUps powerUps) {
        if(!robot.buffs.rangeBuff.getIsActive()) {
            robot.buffs.rangeBuff.setActive(true);
            robot.setRange(robot.getRange() + robot.buffs.rangeBuff.getBuffValue());
            this.rerollXY(robot, robot2, powerUps);
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat das Range PowerUp aufgehoben.");
        }else{
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits eine Range PowerUp.");
            rerollXY(robot, robot2, powerUps);
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getAvatar() {
        return avatar;
    }



}
