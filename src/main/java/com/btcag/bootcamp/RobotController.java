package com.btcag.bootcamp;

public class RobotController {


    public static void hit(Robot robot, Robot targetRobot) {
        int tempDmg = robot.getDmg();

        if (targetRobot.getCurrentShield() < tempDmg) {
            tempDmg -= targetRobot.getCurrentShield();
            targetRobot.setCurrentShield(0);
            targetRobot.setCurrentHp(targetRobot.getCurrentHp()-tempDmg);
        } else {
            targetRobot.setCurrentShield(targetRobot.getCurrentShield()-tempDmg);;
        }
        if (robot.buffs.dmgBuff.getIsActive()) {
            robot.buffs.dmgBuff.setActive(false);
            robot.setDmg( robot.getDmg()-robot.buffs.dmgBuff.getBuffValue());
        }
        RobotView.printHitMessage(targetRobot);
    }


}
