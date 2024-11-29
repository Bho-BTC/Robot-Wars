package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Robots.Robot;

import java.util.Scanner;

public class GameView {

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

public static String getDirectionInput(Robot turningRobot, Robot notTurningRobot, String playerName) {
    Scanner scanner = new Scanner(System.in);
    String direction;
    do {
        System.out.println();
        System.out.println(playerName + ", in welche Richtung willst du gehen? (Q, W, E, A, D, Y, S, X) oder P um nichts zu tun.");
        System.out.println("Q = hoch-links | W = hoch | E = hoch-rechts | A = links | D = rechts | Y = runter links | S = runter | X = runter-rechts");
        System.out.println("Du kannst nicht auf das selbe Feld gehen, auf dem dein Gegner steht und auch nicht aus dem Spielfeld gehen.");
        direction = scanner.nextLine();
    } while (!GameValidationController.validDirection(direction, turningRobot, notTurningRobot));
    return direction;
}


    public static void printWinMessage(String winner){
        if (winner.equals("unentschieden")) {
            System.out.println("Es gibt keinen Gewinner, es ist ein Unentschieden");
        } else {
            System.out.println("Der Gewinner ist: " + winner + "!");
        }
    }



}