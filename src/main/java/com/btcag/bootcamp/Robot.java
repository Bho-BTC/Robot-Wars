package com.btcag.bootcamp;

import com.btcag.bootcamp.Buffs.Buffs;

import java.util.Scanner;

public class Robot {
    private int x;
    private int y;
    private String avatar;

    private int MaxLifePoints = 1;
    private int MaxEnergy = 1;
    private int MaxShield = 1;

    private int currentHp;
    private int currentEnergy;
    private int currentShield;
    private int dmg = 1;
    private int range = 1;
    private int areaOfEffect = 1;
    private int accuracy = 1;
    private int skillPoints = 10;
    private int movement = 3;

    public Buffs buffs;


    public Robot() {
        buffs = new Buffs();
        RobotView.chooseRobotAvatar(this, "Geben sie ein zugelassenes ASCII Zeichen an, mit dem der Roboter auf dem Spielfeld ausgegeben soll.");
        System.out.println();
        getStats();
        this.currentHp = MaxLifePoints;
        this.currentEnergy = MaxEnergy;
        this.currentShield = MaxShield;


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

    public int getMaxLifePoints() {
        return MaxLifePoints;
    }

    public int getMaxEnergy() {
        return MaxEnergy;
    }

    public int getMaxShield() {
        return MaxShield;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public int getCurrentShield() {
        return currentShield;
    }

    public int getDmg() {
        return dmg;
    }

    public int getRange() {
        return range;
    }

    public int getAreaOfEffect() {
        return areaOfEffect;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getMovement() {
        return movement;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setMaxLifePoints(int maxLifePoints) {
        MaxLifePoints = maxLifePoints;
    }

    public void setMaxEnergy(int maxEnergy) {
        MaxEnergy = maxEnergy;
    }

    public void setMaxShield(int maxShield) {
        MaxShield = maxShield;
    }

    public void setCurrentEnergy(int currentEnergy) {
        this.currentEnergy = currentEnergy;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public void setCurrentShield(int currentShield) {
        this.currentShield = currentShield;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public void setAreaOfEffect(int areaOfEffect) {
        this.areaOfEffect = areaOfEffect;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public final void getStats(Robot robot) {
        Scanner scanner = new Scanner(System.in);
        int in;
        while (skillPoints > 0) {
            do {
                System.out.println("Geben sie an welchen Stat sie erhöhen wollen. Sie haben noch " + skillPoints + " übrig.");
                System.out.println("(1) Leben: " + robot.getMaxLifePoints());
                System.out.println("(2) Energie: " + robot.getMaxEnergy());
                System.out.println("(3) Schild: " + robot.getMaxShield());
                System.out.println("(4) Schaden: " + robot.getDmg());
                System.out.println("(5) Reichweite: " + robot.getRange());
                System.out.println("(6) Fläche: " + robot.getAreaOfEffect());
                System.out.println("(7) Zielgenauigkeit: " + robot.getAccuracy());
                in = scanner.nextInt();
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

        System.out.println("Leben: " + robot.getMaxLifePoints());
        System.out.println("Energie: " + robot.getMaxLifePoints());
        System.out.println("Schild: " + robot.getMaxShield());
        System.out.println("Schaden: " + robot.getDmg());
        System.out.println("Reichweite: " + robot.getRange());
        System.out.println("Fläche: " + robot.getAreaOfEffect());
        System.out.println("Zielgenauigkeit: " + robot.getAccuracy());
        System.out.println();
    }


    public void printStats() {
        System.out.println("Stats von " + this.avatar);
        System.out.println("HP: " + this.currentHp + "/" + this.MaxLifePoints);
        System.out.println("Energy: " + this.currentEnergy + "/" + this.MaxEnergy);
        System.out.println("Shield: " + this.currentShield + "/" + this.MaxShield);
        System.out.println("Damage: " + this.dmg);
        System.out.println("Range: " + this.range);
        System.out.println("AreaOfEffect: " + this.areaOfEffect);
        System.out.println("Accuracy: " + this.accuracy);
        System.out.println();
        if (this.buffs.dmgBuff.getIsActive()) {
            System.out.println("Dmg Buff is active");
        }
        if (this.buffs.rangeBuff.getIsActive()) {
            System.out.println("Range Buff is active");
        }
        System.out.println();
    }



}
