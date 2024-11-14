package com.btcag.bootcamp.Robots;

public class RobotController {


    public static void hit(Robot robot, Robot targetRobot) {
        int tempDmg = robot.getDmg();

        if (targetRobot.getCurrentShield() < tempDmg) {
            tempDmg -= targetRobot.getCurrentShield();
            targetRobot.setCurrentShield(0);
            targetRobot.setCurrentHp(targetRobot.getCurrentHp()-tempDmg);
        } else {
            targetRobot.setCurrentShield(targetRobot.getCurrentShield()-tempDmg);
        }
        if (robot.buffs.dmgBuff.getIsActive()) {
            robot.buffs.dmgBuff.setActive(false);
            robot.setDmg( robot.getDmg()-robot.buffs.dmgBuff.getBuffValue());
        }
        RobotView.printHitMessage(targetRobot);
    }


    public static void getStats(Robot robot) {
        int in;
        while (robot.getSkillPoints() > 0) {
            do {
                in = RobotView.getSkillpointInput(robot);
            } while (in != 1 && in != 2 && in != 3 && in != 4 && in != 5 && in != 6 && in != 7);
            switch (in) {
                case 1:
                    robot.setMaxLifePoints(robot.getMaxLifePoints()+1);
                    break;

                case 2:
                    robot.setMaxEnergy(robot.getMaxEnergy()+1);
                    break;

                case 3:
                    robot.setMaxShield(robot.getMaxShield()+1);
                    break;

                case 4:
                    robot.setDmg(robot.getDmg()+1);
                    break;

                case 5:
                    robot.setRange(robot.getRange()+1);
                    break;

                case 6:
                    robot.setAreaOfEffect(robot.getAreaOfEffect()+1);
                    break;

                case 7:
                    robot.setAccuracy(robot.getAccuracy()+1);
                    break;
            }
            robot.setSkillPoints(robot.getSkillPoints()-1);
        }

    }


}
