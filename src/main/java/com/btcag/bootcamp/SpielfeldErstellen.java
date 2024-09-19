package com.btcag.bootcamp;

public class SpielfeldErstellen {
    public static void main(String[] args) {
        int x = 15;
        int y = 15;
        int robot1x = 1;
        int robot1y = 7;

        int robot2x = 15;
        int robot2y = 8;


        for (int countY = 1; countY <= y; countY++) {
            System.out.println();
            System.out.println();

            for (int countX = 1; countX <= x; countX++) {
                if (countY == robot1y && countX==robot1x){
                    System.out.print("[ 1 ]  ");
                } else if (countY == robot2y && countX==robot2x) {
                    System.out.print("[ 2 ]  ");
                }else {
                    System.out.print("[   ]  ");
                }


            }


        }


    }
}
