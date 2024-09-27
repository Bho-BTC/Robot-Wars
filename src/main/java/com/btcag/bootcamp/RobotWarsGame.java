package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWarsGame {
    public static int robot1x = 1;
    public static int robot1y = 7;

    public static int robot2x = 15;
    public static int robot2y = 8;

    public static String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        String username;

        do {
            System.out.println("Bitte geben sie Ihren Nutzernamen ein. Mehr als vier zeichen und weniger als 16:");
            username = scanner.nextLine();
        } while (username.length() > 16 || username.length() < 4);

        return username;
    }

    public static void intro(String username) { //Braucht Username

        //------------------------------------------Intro---------------------------------------------------
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
        System.out.println("          " + username);

    }


    public static String[] chooseRobot() {
        //-----------------------------------------------Robot Auswahl-------------------------------------------------,
        Scanner scanner = new Scanner(System.in);

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

        if (chosenRobot == 1) {
            return robot1;
        }
        if (chosenRobot == 2) {
            return robot2;
        }
        if (chosenRobot == 3) {
            return robot3;
        }
        return robot1;
    }

    public static void drawMap(String[] playerRobot) {
        //---------------------------------------------------Spielfeld zeichnen----------------------------------------

        int x = 15;
        int y = 15;

        int countY = 1;
        int countX = 1;
        boolean spaceDrawn;
        while (countY <= y) {
            System.out.println();
            while (countX <= x) {
                spaceDrawn = false;
                if (countY == robot1y && countX == robot1x) {
                    System.out.print("[ 1 ] ");
                    countX++;
                } else if (countY == robot2y && countX == robot2x) {
                    System.out.print("[ 2 ] ");
                    countX++;
                } else {
                    System.out.print("[   ] ");
                    countX++;
                }
            }
            countY++;
            countX = 1;


        }
        System.out.println();
        System.out.println();




    }


    public static void main(String[] args) {
        intro(getPlayerName());





    }
}
