package com.btcag.bootcamp;

import java.util.Scanner;

public class AvatarCreation {
    public static void main(String[] args) {
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
            while(i < robot1.length) {
                System.out.print(robot1[i] + "    " + robot2[i] + "    " + robot3[i]);
                System.out.println();
                i++;
            }
            System.out.println();
            chosenRobot = scanner.nextInt();
        } while (chosenRobot > 4 || chosenRobot < 0);
        System.out.println();
        System.out.println("Sie haben Roboter " + chosenRobot + " gewählt.");


    }
}


