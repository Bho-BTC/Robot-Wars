package com.btcag.bootcamp;

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
    private int actionPoints = 1;

    public Robot() {
        chooseRobotAvatar("Geben sie ein zugelassenes ASCII Zeichen an, mit dem der Roboter auf dem Spielfeld ausgegeben soll.");
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


    public void hit(Robot targetRobot) {
        if (targetRobot.currentShield < this.dmg) {
            targetRobot.currentHp -= (this.dmg - targetRobot.currentShield);
        } else {
            targetRobot.currentShield -= this.dmg;
        }
        System.out.println("Du hast den Roboter " + targetRobot.avatar + " getroffen. ");
    }


    //-----------------------------------------Holt sich ein Zeichen langen Input vom Nutzer, benötigt Nachricht zum Auffordern------------------------------------------
    public void chooseRobotAvatar(String message) {
        //-----------------------------------------------Robot Auswahl-------------------------------------------------,
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println(message);
            input = scanner.nextLine();
        } while (input.length() > 1);
        this.avatar = input;
    }

    public final void getStats() {
        Scanner scanner = new Scanner(System.in);
        int in;
        while (skillPoints > 0) {
            do {
                System.out.println("Geben sie an welchen Stat sie erhöhen wollen. Sie haben noch " + skillPoints + " übrig.");
                System.out.println("(1) Leben: " + this.MaxLifePoints);
                System.out.println("(2) Energie: " + this.MaxEnergy);
                System.out.println("(3) Schild: " + this.MaxShield);
                System.out.println("(4) Schaden: " + this.dmg);
                System.out.println("(5) Reichweite: " + this.range);
                System.out.println("(6) Fläche: " + this.areaOfEffect);
                System.out.println("(7) Zielgenauigkeit: " + this.accuracy);
                in = scanner.nextInt();
            } while (in != 1 && in != 2 && in != 3 && in != 4 && in != 5 && in != 6 && in != 7);
            switch (in) {
                case 1:
                    this.MaxLifePoints++;
                    break;

                case 2:
                    this.MaxEnergy++;
                    break;

                case 3:
                    this.MaxShield++;
                    break;

                case 4:
                    this.dmg++;
                    break;

                case 5:
                    this.range++;
                    break;

                case 6:
                    this.areaOfEffect++;
                    break;

                case 7:
                    this.accuracy++;
                    break;
            }
            skillPoints--;
        }
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

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }
}
