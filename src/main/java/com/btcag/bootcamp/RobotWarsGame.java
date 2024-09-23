package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWarsGame {
    public static void main(String[] args) {

        //------------------------------------------Intro---------------------------------------------------
        Scanner scanner = new Scanner(System.in);
        String Username;

        do {
            System.out.println("Bitte geben sie Ihren Nutzernamen ein. Mehr als vier zeichen und weniger als 16:");
            Username = scanner.nextLine();
        } while (Username.length() > 16 || Username.length() < 4);


        System.out.println("Willkommen bei Robot Wars");
        System.out.println("          __");
        System.out.println("         |==|");
        System.out.println("       __|__|__");
        System.out.println("      |  O O  |");
        System.out.println("      |_______|");
        System.out.println("      /       \\");
        System.out.println("     /         \\");
        System.out.println("    /___________\\");
        System.out.println("   |             |");
        System.out.println("   |  |       |  |");
        System.out.println("   |  |       |  |");
        System.out.println("   |  |       |  |");
        System.out.println("   |__|       |__|");
        System.out.println("          " + Username);


        //-----------------------------------------------Robot Auswahl-------------------------------------------------


        String[] robot1 = {
                "  [ ]   ",
                " /|_|\\  ",
                "  | |   ",
                " /   \\  "
        };

        String[] robot2 = {
                "   .-.   ",
                " /|o o|\\",
                "/ | O | \\",
                "   \\_/  "
        };

        String[] robot3 = {
                "         ",
                "   /\\_/\\ ",
                "( o.o )  ",
                "  > ^ <   "
        };


        int chosenRobot;

        do {
            System.out.println();
            System.out.println("Wählen sie Ihren Roboter");
            System.out.println("   1            2           3");
            int i = 0;
            while (i < robot1.length) {
                System.out.print(robot1[i] + "    " + robot2[i] + "    " + robot3[i]);
                System.out.println();
                i++;
            }

            System.out.println();
            chosenRobot = scanner.nextInt();
        } while (chosenRobot > 4 || chosenRobot < 0);
        System.out.println();
        System.out.println("Sie haben Roboter " + chosenRobot + " gewählt.");
        boolean robotchosen = false;

        //---------------------------------------------------Spielfeld zeichnen----------------------------------------

        int x = 15;
        int y = 15;
        int robot1x = 1;
        int robot1y = 7;

        int robot2x = 15;
        int robot2y = 8;
        int countY = 1;
        int countX = 1;
        boolean spaceDrawn;
        while (countY <= y) {
            spaceDrawn = false;
            System.out.println();
            while (countX <= x) {
                spaceDrawn = false;
                while (countY == robot1y && countX == robot1x) {
                    System.out.print("[ 1 ] ");
                    countX++;
                    spaceDrawn = true;
                }
                while (countY == robot2y && countX == robot2x) {
                    System.out.print("[ 2 ] ");
                    countX++;
                    spaceDrawn = true;
                }
                while (!spaceDrawn) {
                    System.out.print("[   ] ");
                    countX++;
                    spaceDrawn = true;
                }

            }
            countY++;
            countX = 1;


        }
        System.out.println();
        System.out.println();
        int chosenrobot2 = chosenRobot;
        while (!robotchosen) {
            while (chosenrobot2 == 1) {
                int i = 0;
                while (i < robot1.length) {
                    System.out.println(robot1[i]);
                    i++;
                }
                chosenrobot2 = 0;
            }

            while (chosenrobot2 == 2) {
                int i = 0;
                while (i < robot2.length) {
                    System.out.println(robot2[i]);
                    i++;
                }
                chosenrobot2 = 0;
            }

            while (chosenrobot2 == 3) {
                int i = 0;
                while (i < robot3.length) {
                    System.out.println(robot3[i]);
                    i++;
                }
                chosenrobot2 = 0;
            }
            robotchosen=true;
        }


    }
}
