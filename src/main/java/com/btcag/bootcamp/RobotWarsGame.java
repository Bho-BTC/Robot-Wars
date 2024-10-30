package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWarsGame {
    public static boolean checkWin (Robot robot1, Robot robot2) {
        return !(robot1.currentHp > 0) || !(robot2.currentHp > 0);
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
        System.out.println(username+ "      "+ username2);

    }


    //Validierung von Richtungswahl beim Roboter Bewegen/Angreifen
    public static boolean validDirection(String direction, String action, Robot turningRobot,Robot notTurningRobot) {
        if (!direction.equals("W") && !direction.equals("A") && !direction.equals("S") && !direction.equals("D")) {
            return false;//wenn Richtung nicht Oben, Rechts, Unten oder Links dann falsch
        } else {
            if (action.equals("B")) { //Validierung fürs Bewegen
                switch (direction) {
                    case "W":
                        if (turningRobot.y - 1 == notTurningRobot.y && turningRobot.x == notTurningRobot.x || turningRobot.y - 1 < 1) {
                            return false;
                        }
                        break;
                    case "D":
                        if (turningRobot.x + 1 == notTurningRobot.x && turningRobot.y == notTurningRobot.y || turningRobot.x + 1 > 15) {
                            return false;
                        }
                        break;
                    case "S":
                        if (turningRobot.y + 1 == notTurningRobot.y && turningRobot.x == notTurningRobot.x || turningRobot.y + 1 > 15) {
                            return false;
                        }
                        break;
                    case "A":
                        if (turningRobot.x - 1 == notTurningRobot.x && turningRobot.y==notTurningRobot.y || turningRobot.x - 1 < 1) {
                            return false;
                        }
                        break;
                }
            }

            return true;
        }
    }


    public static void turn(Robot turningRobot, Robot notTurningRobot, String playerName) {
        Scanner scanner = new Scanner(System.in);
        String input;
        String direction;

        do {
            System.out.println();
            System.out.println(playerName+ ", wollen sie angreifen (A) oder sich bewegen (B)?");
            input = scanner.nextLine();
        } while (!input.equals("A") && !input.equals("B"));
        do {
            System.out.println();
            System.out.println("In welche Richtung? Oben, Rechts, Unten, Links(W, A, S, D)");
            System.out.println("Du kannst nicht auf das selbe Feld gehen, auf dem dein Gegner steht und auch nicht aus dem Spielfeld gehen.");
            System.out.println("Angreifen ist in jede Richtung möglich, hat 1 Feld Reichweite");
            direction = scanner.nextLine();
        } while (!validDirection(direction, input, turningRobot, notTurningRobot));


        switch (direction) {
            case "W":
                if (turningRobot.y - 1 == notTurningRobot.y && turningRobot.x == notTurningRobot.x && input.equals("A")) {
                    turningRobot.hit(notTurningRobot);
                } else if (input.equals("B")) {
                    turningRobot.y -= 1;
                }
                break;
            case "D":
                if (turningRobot.x + 1 == notTurningRobot.x && turningRobot.y == notTurningRobot.y && input.equals("A")) {
                    turningRobot.hit(notTurningRobot);
                } else if (input.equals("B")) {
                    turningRobot.x += 1;
                }
                break;
            case "S":
                if (turningRobot.y + 1 == notTurningRobot.y && turningRobot.x == notTurningRobot.x && input.equals("A")) {
                    turningRobot.hit(notTurningRobot);
                } else if (input.equals("B")) {
                    turningRobot.y += 1;
                }
                break;
            case "A":
                if (turningRobot.x - 1 == notTurningRobot.x && turningRobot.y == notTurningRobot.y && input.equals("A")) {
                    turningRobot.hit(notTurningRobot);
                } else if (input.equals("B")) {
                    turningRobot.x -= 1;
                }
                break;
        }
    }

    public static String getWinner(Robot robot1, Robot robot2, User user1, User user2) {
        if (robot1.getCurrentHp() <1 && robot1.getCurrentHp() <robot2.getCurrentHp()) {
            return user2.name;
        }else if( robot2.getCurrentHp() <1 && robot2.getCurrentHp() <robot1.getCurrentHp()){
            return user1.name;
        }else{
            return "unentschieden";
        }

    }


    public static void main(String[] args) {
        User user1 = new User("Spieler 1");
        Robot player1 = new Robot();
        User user2 = new User("Spieler 2");
        Robot player2 = new Robot();
        int lastTurn = 1;
        player1.x=1;
        player1.y=7;
        player2.x=15;
        player2.y=7;
        intro(user1.name, user2.name);
        Map map=new Map(15,15);
        while (!checkWin(player1, player2)) {
            if (lastTurn== 1) {
                map.drawMap(player1, player2);
                player1.printStats();
                turn(player1, player2, user1.name);
                lastTurn=2;
            } else {
                map.drawMap(player1, player2);
                player2.printStats();
                turn(player2, player1, user2.name);
                lastTurn=1;
            }
        }
        System.out.println();
        String winner = getWinner(player1, player2, user1, user2);
        if (winner.equals("unentschieden")) {
            System.out.println("Es gibt keinen Gewinner, es ist ein Unentschieden");
        }else{
            System.out.println("Der Gewinner ist: " + winner+"!");
        }
    }
}