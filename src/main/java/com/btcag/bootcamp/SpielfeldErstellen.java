package com.btcag.bootcamp;

public class SpielfeldErstellen {
    public static void main(String[] args) {
        int x = 15;
        int y = 15;
        int robot1x = 1;
        int robot1y = 7;

        int robot2x = 15;
        int robot2y = 8;
        int countY = 1;
        int countX = 1;
        boolean spaceDrawn = false;
        while (countY <= y) {
            spaceDrawn=false;
            System.out.println();
            while (countX <= x) {
                spaceDrawn=false;
                while (countY == robot1y && countX == robot1x) {
                    System.out.print("[ 1 ] ");
                    countX++;
                    spaceDrawn = true;
                }
                while (countY == robot2y && countX == robot2x) {
                    System.out.print("[ 2 ] ");
                    countX++;
                    spaceDrawn = true;
                }
                while (!spaceDrawn) {
                    System.out.print("[   ] ");
                    countX++;
                    spaceDrawn =true;
                }

            }
            countY++;
            countX=1;


        }


    }
}
