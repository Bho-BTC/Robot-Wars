package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWarsGame {
    public static boolean checkWin(Robot robot1, Robot robot2) {
        return !(robot1.getCurrentHp() > 0) || !(robot2.getCurrentHp() > 0);
    }

    //-------------------------------------Spielt das Intro, braucht Namen des Nutzers.
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


    //Validierung von Richtungswahl beim Roboter Bewegen/Angreifen
    public static boolean validDirection(String direction, Robot turningRobot, Robot notTurningRobot) {
        if (!direction.equals("W") && !direction.equals("A") && !direction.equals("S") && !direction.equals("D")) {
            return false;//wenn Richtung nicht W, A, S oder D dann falsch
        }
        switch (direction) {
            case "W":
                if (turningRobot.getY() - 1 == notTurningRobot.getY() && turningRobot.getX() == notTurningRobot.getX() || turningRobot.getY() - 1 < 1) {
                    return false;
                }
                break;

            case "D":
                if (turningRobot.getX() + 1 == notTurningRobot.getX() && turningRobot.getY() == notTurningRobot.getY() || turningRobot.getX() + 1 > 15) {
                    return false;
                }
                break;

            case "S":
                if (turningRobot.getY() + 1 == notTurningRobot.getY() && turningRobot.getX() == notTurningRobot.getX() || turningRobot.getY() + 1 > 15) {
                    return false;
                }
                break;

            case "A":
                if (turningRobot.getX() - 1 == notTurningRobot.getX() && turningRobot.getY() == notTurningRobot.getY() || turningRobot.getX() - 1 < 1) {
                    return false;
                }
                break;
        }
        return true;
    }


    public static void turn(Robot turningRobot, Robot notTurningRobot, String playerName) {
        Scanner scanner = new Scanner(System.in);
        String direction;
        do {
            System.out.println();
            System.out.println("In welche Richtung willst du gehen? (W, A, S, D) oder P um nichts zu tun.");
            System.out.println("Du kannst nicht auf das selbe Feld gehen, auf dem dein Gegner steht und auch nicht aus dem Spielfeld gehen.");
            direction = scanner.nextLine();
        } while (!validDirection(direction, turningRobot, notTurningRobot));


        switch (direction) {
            case "W":
                turningRobot.setY(turningRobot.getY() - 1);
                break;

            case "D":
                turningRobot.setX(turningRobot.getX() + 1);
                break;

            case "S":
                turningRobot.setY(turningRobot.getY() + 1);
                break;

            case "A":
                turningRobot.setX(turningRobot.getX() - 1);
                break;
        }


    }

    public static String getWinner(Robot robot1, Robot robot2, User user1, User user2) {
        if (robot1.getCurrentHp() < 1 && robot1.getCurrentHp() < robot2.getCurrentHp()) {
            return user2.name;
        } else if (robot2.getCurrentHp() < 1 && robot2.getCurrentHp() < robot1.getCurrentHp()) {
            return user1.name;
        } else {
            return "unentschieden";
        }

    }


    public static boolean inRange(Robot robot1, Robot robot2) {
        //check ob robot2 x in range von robot1 x ist
        return ((robot1.getX() + robot1.getRange() >= robot2.getX() && robot2.getX() > robot1.getX()) && (robot1.getY() + robot1.getRange() >= robot2.getY() && robot2.getY() > robot1.getY())
                || (robot1.getX() + robot1.getRange() >= robot2.getX() && robot2.getX() > robot1.getX()) && (robot1.getY() - robot1.getRange() <= robot2.getY() && robot2.getY() < robot1.getY())
                || (robot1.getX() - robot1.getRange() <= robot2.getX() && robot2.getX() < robot1.getX()) && (robot1.getY() + robot1.getRange() >= robot2.getY() && robot2.getY() > robot1.getY())
                || (robot1.getX() - robot1.getRange() <= robot2.getX() && robot2.getX() < robot1.getX()) && (robot1.getY() - robot1.getRange() <= robot2.getY() && robot2.getY() < robot1.getY()));
    }


    public static void main(String[] args) {
        User user1 = new User("Spieler 1");
        Robot player1 = new Robot();
        User user2 = new User("Spieler 2");
        Robot player2 = new Robot();
        int lastTurn = 1;
        player1.setX(1);
        player1.setY(7);
        player2.setX(15);
        player2.setY(7);
        intro(user1.name, user2.name);
        Map map = new Map(15, 15);
        while (!checkWin(player1, player2)) {
            if (lastTurn == 1) {
                for (int i = player1.getMovement(); i > 0; i--) {
                    map.drawMap(player1, player2);
                    player1.printStats();
                    turn(player1, player2, user1.name);
                }
                map.drawMap(player1, player2);
                if (inRange(player1, player2)) {
                    player1.hit(player2);
                    System.out.println(user1.name + " hat " + user2.name + " getroffen.");
                    System.out.println();
                }
                lastTurn = 2;
            } else {
                for (int i = player2.getMovement(); i > 0; i--) {
                    map.drawMap(player1, player2);
                    player2.printStats();
                    turn(player2, player1, user2.name);
                }
                map.drawMap(player1, player2);
                if (inRange(player2, player1)) {
                    player2.hit(player1);
                    System.out.println(user2.name + " hat " + user1.name + " getroffen.");
                    System.out.println();
                }
                lastTurn = 1;
            }
        }
        System.out.println();
        String winner = getWinner(player1, player2, user1, user2);
        if (winner.equals("unentschieden")) {
            System.out.println("Es gibt keinen Gewinner, es ist ein Unentschieden");
        } else {
            System.out.println("Der Gewinner ist: " + winner + "!");
        }
    }
}