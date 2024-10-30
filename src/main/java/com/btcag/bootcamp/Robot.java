package com.btcag.bootcamp;

import java.util.Scanner;

public class Robot {
    protected int x;
    protected int y;
    protected String avatar;

    protected int MaxLifePoints = 1;
    protected int MaxEnergy = 1;
    protected int MaxShield = 1;

    protected int currentHp;
    protected int currentEnergy;
    protected int currentShield;
    protected int dmg = 1;
    protected int range = 1;
    protected int areaOfEffect = 1;
    protected int accuracy = 1;
    protected int skillPoints = 10;

    public Robot() {
        chooseRobotAvatar("Geben sie ein zugelassenes ASCII Zeichen an, mit dem der Roboter auf dem Spielfeld ausgegeben soll.");
        System.out.println();
        getStats();
        this.currentHp = MaxLifePoints;
        this.currentEnergy = MaxEnergy;
        this.currentShield = MaxShield;

    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String getAvatar(){
        return avatar;
    }
    public int getMaxLifePoints(){
        return MaxLifePoints;
    }
    public int getMaxEnergy(){
        return MaxEnergy;
    }
    public int getMaxShield(){
        return MaxShield;
    }
    public int getCurrentHp(){
        return currentHp;
    }
    public int getCurrentEnergy(){
        return currentEnergy;
    }
    public int getCurrentShield(){
        return currentShield;
    }
    public int getDmg(){
        return dmg;
    }
    public int getRange(){
        return range;
    }
    public int getAreaOfEffect(){
        return areaOfEffect;
    }
    public int getAccuracy(){
        return accuracy;
    }



    public void hit(Robot targetRobot){
        if(targetRobot.currentShield<this.dmg){
            targetRobot.currentHp -= (this.dmg-targetRobot.currentShield);
        } else  {
            targetRobot.currentShield -= this.dmg;
        }
        System.out.println("Du hast den Roboter "+targetRobot.avatar+" getroffen. ");
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
        System.out.println("HP: " + this.currentHp+"/"+this.MaxLifePoints);
        System.out.println("Energy: " + this.currentEnergy+"/"+this.MaxEnergy);
        System.out.println("Shield: " + this.currentShield+"/"+this.MaxShield);
        System.out.println("Damage: " + this.dmg);
        System.out.println("Range: " + this.range);
        System.out.println("AreaOfEffect: " + this.areaOfEffect);
        System.out.println("Accuracy: " + this.accuracy);
        System.out.println();
    }





}
