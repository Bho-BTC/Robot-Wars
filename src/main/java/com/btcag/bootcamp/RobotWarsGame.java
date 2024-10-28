package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotWarsGame {
    public static boolean checkWin = false;
    //-------------------------------------Spielt das Intro, braucht Namen des Nutzers.
    public static void intro(String username) {
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


    //Validierung von Richtungswahl beim Roboter Bewegen/Angreifen
    public static boolean validDirection(String direction, String action, Robot turningRobot,Robot notTurningRobot) {
        if (!direction.equals("O") && !direction.equals("R") && !direction.equals("U") && !direction.equals("L")) {
            return false;//wenn Richtung nicht Oben, Rechts, Unten oder Links dann falsch
        } else {
            if (action.equals("B")) { //Validierung fürs Bewegen
                switch (direction) {
                    case "O":
                        if (turningRobot.y - 1 == notTurningRobot.y && turningRobot.x == notTurningRobot.x || turningRobot.y - 1 < 1) {
                            return false;
                        }
                        break;
                    case "R":
                        if (turningRobot.x + 1 == notTurningRobot.x && turningRobot.y == notTurningRobot.y || turningRobot.x + 1 > 15) {
                            return false;
                        }
                        break;
                    case "U":
                        if (turningRobot.y + 1 == notTurningRobot.y && turningRobot.x == notTurningRobot.x || turningRobot.y + 1 > 15) {
                            return false;
                        }
                        break;
                    case "L":
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
            System.out.println("In welche Richtung? Oben, Rechts, Unten, Links(O,R,U,L)");
            System.out.println("Du kannst nicht auf das selbe Feld gehen, auf dem dein Gegner steht und auch nicht aus dem Spielfeld gehen.");
            System.out.println("Angreifen ist in jede Richtung möglich, hat 1 Feld Reichweite");
            direction = scanner.nextLine();
        } while (!validDirection(direction, input, turningRobot, notTurningRobot));


        switch (direction) {
            case "O":
                if (turningRobot.y - 1 == notTurningRobot.y && turningRobot.x == notTurningRobot.x && input.equals("A")) {
                    checkWin = true;
                    System.out.println("Du hast getroffen, yippie");
                } else if (input.equals("B")) {
                    turningRobot.y -= 1;
                }
                break;
            case "R":
                if (turningRobot.x + 1 == notTurningRobot.x && turningRobot.y == notTurningRobot.y && input.equals("A")) {
                    checkWin = true;
                    System.out.println("Du hast getroffen, yippie");
                } else if (input.equals("B")) {
                    turningRobot.x += 1;
                }
                break;
            case "U":
                if (turningRobot.y + 1 == notTurningRobot.y && turningRobot.x == notTurningRobot.x && input.equals("A")) {
                    checkWin = true;
                    System.out.println("Du hast getroffen, yippie");
                } else if (input.equals("B")) {
                    turningRobot.y += 1;
                }
                break;
            case "L":
                if (turningRobot.x - 1 == notTurningRobot.x && turningRobot.y == notTurningRobot.y && input.equals("A")) {
                    checkWin = true;
                    System.out.println("Du hast getroffen, yippie");
                } else if (input.equals("B")) {
                    turningRobot.x -= 1;
                }
                break;
        }
    }

    public static void main(String[] args) {
        User user1 = new User("Spieler 1");
        Robot player1 = new Robot();
        User user2 = new User("Spieler 2");
        Robot player2 = new Robot();
        int turnCount = 1;
        player1.x=1;
        player1.y=7;
        player2.x=15;
        player2.y=7;
        intro(user1.name);
        Map map=new Map(15,15);
        while (!checkWin) {
            if (turnCount % 2 != 0) {
                map.drawMap(player1, player2);
                turn(player1, player2, user1.name);
                turnCount++;
            } else {
                map.drawMap(player1, player2);
                turn(player2, player1, user2.name);
                turnCount++;
            }
        }
    }
}