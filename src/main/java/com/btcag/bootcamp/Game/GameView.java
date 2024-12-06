package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Robots.Robot;

import java.util.Scanner;

public class GameView {


    public static String getActionType(Robot robot, String playerName) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Was wollen sie tun, " + playerName + "?");
            System.out.println("(1) Bewegen");
            System.out.println("(2) Angreifen");
            System.out.println("(3) Manuell Drehen");

            input = scanner.next();
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3"));


        return input;
    }


    public static void intro(String username, String username2) {
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
        System.out.println(username + "      " + username2);
    }


    public static boolean askWantAttack(String playerName) {
        String temp;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println(playerName + ", willst du den Gegner angreifen? (Y/N)");
            temp = sc.nextLine();
        } while (!(temp.equalsIgnoreCase("y")) && !(temp.equalsIgnoreCase("n")));

        if (temp.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }


    public static String getMoveDirection(Robot turningRobot, Robot notTurningRobot, String playerName) {
        Scanner scanner = new Scanner(System.in);
        String direction;
        do {
            System.out.println();
            System.out.println(playerName + ", in welche Richtung willst du gehen? (Q, W, E, A, D, Y, S, X) oder P um nichts zu tun.");
            System.out.println("    Q    W    E");
            System.out.println("    A   You   D");
            System.out.println("    Y    S    X");
            System.out.println("Du kannst nicht auf das selbe Feld laufen, auf dem dein Gegner steht und auch nicht aus dem Spielfeld gehen.");
            direction = scanner.nextLine();
        } while (!GameValidationController.validDirection(direction, turningRobot, notTurningRobot));

        return direction;
    }


    public static String getAlignDirection(Robot turningRobot, String playerName) {
        Scanner scanner = new Scanner(System.in);
        String direction;
        do {
            System.out.println();
            System.out.println(playerName + ", in welche Richtung willst du dich drehen? (Q, W, E, A, D, Y, S, X) oder P um nichts zu tun.");
            System.out.println("    Q    W    E");
            System.out.println("    A   You   D");
            System.out.println("    Y    S    X");
            direction = scanner.nextLine();
        } while (   !direction.equalsIgnoreCase("q") && !direction.equalsIgnoreCase("w") && !direction.equalsIgnoreCase("e")
                &&  !direction.equalsIgnoreCase("a") && !direction.equalsIgnoreCase("s") && !direction.equalsIgnoreCase("d")
                &&  !direction.equalsIgnoreCase("y") && !direction.equalsIgnoreCase("x") && !direction.equalsIgnoreCase("p"));

        return direction;
    }



    public static void printMissHitMessage() {
        System.out.println("Du hast nichts getroffen");
    }

    public static void printWallHitMessage() {
       System.out.println("Du hast eine wand getroffen");
    }

    public static void printWinMessage(String winner) {
        if (winner.equals("unentschieden")) {
            System.out.println("Es gibt keinen Gewinner, es ist ein Unentschieden");
        } else {
            System.out.println("Der Gewinner ist: " + winner + "!");
        }
    }


}
