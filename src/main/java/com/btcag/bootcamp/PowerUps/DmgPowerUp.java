package com.btcag.bootcamp.PowerUps;

import com.btcag.bootcamp.Robot;

import java.util.Random;

public class DmgPowerUp {

    private int x = 0;
    private int y = 0;
    private final String avatar = "(D)";


    public DmgPowerUp(Robot robot, Robot robot2) {
        rerollXY(robot, robot2);

    }

    public void rerollXY(Robot robot1, Robot robot2) {
        Random random = new Random();
        int tempX;
        int tempY;
        do {
            do {
                tempX = random.nextInt(1, 15);
            } while (x == tempX);
            x = tempX;


            do {
                tempY = random.nextInt(1, 15);
            } while (y == tempY);
            y = tempY;
        } while (tempX == robot1.getX() && tempY == robot1.getY() || tempX == robot2.getX() && tempY == robot2.getY());
    }

    public void pickedUpBy(Robot robot, Robot robot2) {

        if (!robot.buffs.dmgBuff.getIsActive()) {
            robot.buffs.dmgBuff.setActive(true);
            robot.setDmg(robot.getDmg() + robot.buffs.dmgBuff.getBuffValue());
            this.rerollXY(robot, robot2);
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat das Damage PowerUp aufgehoben.");
        }else{
            System.out.println();
            System.out.println("Der Roboter " + robot.getAvatar() + " hat bereits ein Damage PowerUp.");
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
