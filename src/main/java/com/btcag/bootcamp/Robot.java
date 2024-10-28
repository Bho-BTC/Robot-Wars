package com.btcag.bootcamp;

import java.util.Scanner;

public class Robot {
    int x;
    int y;
    String Avatar;

    int MaxLifePoints =1;
    int MaxEnergy = 1;
    int MaxShield = 1;

    int currentHp;
    int currentEnergy;
    int currentShield;
    int dmg = 1;
    int range = 1;
    int areaOfEffect = 1;
    int accuracy= 1;
    int skillPoints =10;

    public Robot(){
        chooseRobotAvatar("Geben sie ein zugelassenes ASCII Zeichen an, mit dem der Roboter auf dem Spielfeld ausgegeben soll.");
        System.out.println();
        getStats();

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
        this.Avatar = input;
    }

    public final void getStats(){
        Scanner scanner = new Scanner(System.in);
        int in;
        while(skillPoints >0){
            do {
                System.out.println("Geben sie an welchen Stat sie erhöhen wollen. Sie haben noch "+ skillPoints + " übrig.");
                System.out.println("(1) Leben: "+ this.MaxLifePoints);
                System.out.println("(2) Energie: "+ this.MaxEnergy);
                System.out.println("(3) Schild: "+ this.MaxShield);
                System.out.println("(4) Schaden: "+ this.dmg);
                System.out.println("(5) Reichweite: "+ this.range);
                System.out.println("(6) Fläche: "+ this.areaOfEffect);
                System.out.println("(7) Zielgenauigkeit: "+ this.accuracy);
                in=scanner.nextInt();
            }while (in !=1 && in !=2 && in !=3 && in !=4 && in !=5 && in !=6 && in !=7);
                switch(in){
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
        statsSet(MaxLifePoints, MaxEnergy, MaxShield);
    }

    public void statsSet(int hp, int energy, int shield){
        this.currentHp = hp;
        this.currentEnergy = energy;
        this.currentShield = shield;
    }

}
