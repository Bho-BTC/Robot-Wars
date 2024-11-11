package com.btcag.bootcamp;

import java.util.Scanner;

public class RobotView {



    //-----------------------------------------Holt sich ein Zeichen langen Input vom Nutzer, benötigt Nachricht zum Auffordern------------------------------------------
    public static void chooseRobotAvatar(Robot robot, String message) {
        //-----------------------------------------------Robot Auswahl-------------------------------------------------,
        Scanner scanner = new Scanner(System.in);
        String input;
        do {
            System.out.println(message);
            input = scanner.nextLine();
        } while (input.length() > 1);
        robot.setAvatar(input);
    }

    public static void printHitMessage(Robot targetRobot){
        System.out.println("Du hast den Roboter " + targetRobot.getAvatar() + " getroffen. ");
    }








}
