package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWarsGame {
    public static boolean checkWin = false;

    public static String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        String username;

        do {
            System.out.println("Bitte geben sie Ihren Nutzernamen ein. Mehr als drei zeichen und weniger als 16:");
            username = scanner.nextLine();
        } while (username.length() > 16 || username.length() < 3);

        return username;
    }

    public static String getEnemyName() {
        Scanner scanner = new Scanner(System.in);
        String username;

        do {
            System.out.println("Bitte geben sie den Namens des zweiten Spielers ein. Mehr als drei zeichen und weniger als 16:");
            username = scanner.nextLine();
        } while (username.length() > 16 || username.length() < 3);

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


    public static String chooseRobotAvatar() {
        //-----------------------------------------------Robot Auswahl-------------------------------------------------,
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Geben sie ein zugelassenes ASCII Zeichen an, das ihren Roboter auf dem Spielfeld darstellen soll.");
            input = scanner.nextLine();
        } while (input.length() > 1);

        return input;
    }

    public static String chooseEnemyAvatar() {
        //-----------------------------------------------Robot Auswahl-------------------------------------------------,
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Geben sie ein zugelassenes ASCII Zeichen an, das den Roboter des zweiten Spielers auf dem Spielfeld darstellen soll.");
            input = scanner.nextLine();
        } while (input.length() > 1);

        return input;
    }


    public static void drawMap(int[] robot, int[] robot2, String avatarRobot2, String avatar) {
        //---------------------------------------------------Spielfeld zeichnen----------------------------------------
        // braucht array mit postionen und avatar von beiden spielern, gibt das Spielfeld auf konsole aus
        int x = 15;
        int y = 15;

        int countY = 1;
        int countX = 1;
        while (countY <= y) {
            System.out.println();
            while (countX <= x) {
                if (countY == robot[0] && countX == robot[1]) {
                    System.out.print("[ " + avatar + " ] ");
                    countX++;
                } else if (countY == robot2[0] && countX == robot2[1]) {
                    System.out.print("[ " + avatarRobot2 + " ] ");
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
    }

    public static boolean validDirection(String direction, String action, int[] playerYX, int[] enemyYX) {
        if (!direction.equals("O") && !direction.equals("R") && !direction.equals("U") && !direction.equals("L")) {
            return false;
        } else {
            //für bewegen
            if (action.equals("B")) {
                switch (direction) {
                    case "O":
                        if (playerYX[0] - 1 == enemyYX[0] && playerYX[1] == enemyYX[1] || playerYX[0] - 1 < 1) {
                            return false;
                        }
                        break;
                    case "R":
                        if (playerYX[1] + 1 == enemyYX[1] && playerYX[0] == enemyYX[0] || playerYX[1] + 1 > 15) {
                            return false;
                        }
                        break;
                    case "U":
                        if (playerYX[0] + 1 == enemyYX[0] && playerYX[1] == enemyYX[1] || playerYX[0] + 1 > 15) {
                            return false;
                        }
                        break;
                    case "L":
                        if (playerYX[1] - 1 == enemyYX[1] && playerYX[0] == enemyYX[0] || playerYX[1] - 1 < 1) {
                            return false;
                        }
                        break;
                }
            }

            return true;
        }
    }


    public static int[] turn(int[] playerYX, int[] enemyYX, String playerName) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        String direction = "";

        do {
            System.out.println();
            System.out.println(playerName+ ", wollen sie angreifen (A) oder sich bewegen (B)?");
            input = scanner.nextLine();
        } while (!input.equals("A") && !input.equals("B"));
        do {
            System.out.println();
            System.out.println("In welche Richtung? Oben, Rechts, Unten, Links(O,R,U,L)");
            System.out.println("Du kannst nicht auf das selbe Feld, auf dem dein Gegner steht und auch nicht aus dem Spielfeld gehen.");
            direction = scanner.nextLine();
        } while (!validDirection(direction, input, playerYX, enemyYX));


        switch (direction) {
            case "O":
                if (playerYX[0] - 1 == enemyYX[0] && playerYX[1] == enemyYX[1] && input.equals("A")) {
                    checkWin = true;
                    System.out.println("Du hast getroffen, yippie");
                } else if (input.equals("B")) {
                    playerYX[0] -= 1;
                }
                break;
            case "R":
                if (playerYX[1] + 1 == enemyYX[1] && playerYX[0] == enemyYX[0] && input.equals("A")) {
                    checkWin = true;
                    System.out.println("Du hast getroffen, yippie");
                } else if (input.equals("B")) {
                    playerYX[1] += 1;
                }
                break;
            case "U":
                if (playerYX[0] + 1 == enemyYX[0] && playerYX[1] == enemyYX[1] && input.equals("A")) {
                    checkWin = true;
                    System.out.println("Du hast getroffen, yippie");
                } else if (input.equals("B")) {
                    playerYX[0] += 1;
                }
                break;
            case "L":
                if (playerYX[1] - 1 == enemyYX[1] && playerYX[0] == enemyYX[0] && input.equals("A")) {
                    checkWin = true;
                    System.out.println("Du hast getroffen, yippie");
                } else if (input.equals("B")){
                    playerYX[1] -= 1;
                }
                break;
        }


        return playerYX;
    }


    public static void main(String[] args) {
        String playerName = getPlayerName();
        String playerAvatar = chooseRobotAvatar();
        String player2Name = getEnemyName();
        String player2Avatar = chooseEnemyAvatar();

        int turnCount = 1;


        //index 0 = y | index 1 = x
        int[] player = {7, 1};
        int[] player2 = {7, 15};
        intro(playerName);


        while (!checkWin) {
            if (turnCount % 2 != 0) {
                drawMap(player, player2, player2Avatar, playerAvatar);
                player = turn(player, player2, playerName);
                turnCount++;

            } else {
                drawMap(player, player2, player2Avatar, playerAvatar);
                player2 = turn(player2, player, player2Name);
                turnCount++;

            }

        }


    }
}