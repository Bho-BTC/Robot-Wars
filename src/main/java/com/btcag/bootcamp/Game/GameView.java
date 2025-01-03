package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Move.Move;
import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.Robots.alignment;

import java.util.Scanner;

public class GameView {


    public static String getActionType(String playerName, Robot robot) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.println("Was wollen sie tun, " + playerName + "?");
            System.out.println("(1) Bewegen");
            System.out.println("(2) Angreifen");
            System.out.println("(3) Manuell Drehen");
            System.out.println("(4) Zug beenden");
            System.out.println("(5) Dich beenden");

            input = scanner.next();
        } while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("4") && !input.equals("5") || input.equals("2") && robot.isHasAttackedThisRound());


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


    public static alignment getMoveDirection(Robot turningRobot, Robot[] robots, String playerName, Walls[] walls) {
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
        } while (!GameValidationController.validDirection(direction, turningRobot, robots, walls));


        return getAlignmentForDirection(direction);
    }


    public static alignment getAlignmentForDirection(String direction) {
        for (alignment alignment : alignment.values()) {
            if (direction.equals(alignment.key)) {
                return alignment;
            }
        }
    return alignment.NORTH;
    }


    public static alignment getAlignDirection(String playerName) {
        Scanner scanner = new Scanner(System.in);
        String direction;
        do {
            System.out.println();
            System.out.println(playerName + ", in welche Richtung willst du dich drehen? (Q, W, E, A, D, Y, S, X)");
            System.out.println("    Q    W    E");
            System.out.println("    A   You   D");
            System.out.println("    Y    S    X");
            direction = scanner.nextLine();
        } while (!direction.equalsIgnoreCase("Q") && !direction.equalsIgnoreCase("W") && !direction.equalsIgnoreCase("E")
                && !direction.equalsIgnoreCase("A") && !direction.equalsIgnoreCase("S") && !direction.equalsIgnoreCase("D")
                && !direction.equalsIgnoreCase("Y") && !direction.equalsIgnoreCase("X") && !direction.equalsIgnoreCase("P"));

        return getAlignmentForDirection(direction);
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
