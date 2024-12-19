package com.btcag.bootcamp.Maps;

import com.btcag.bootcamp.PowerUps.PowerUp;

public class MapTest {
    public static void main(String[] args) {
        Map map = new Map(15, 15);
        int i = 1;
        int j = 0;
        for (char space : map.arrayVersion) {
            System.out.print("[ " + space +" ] ");
            if (i == 15) {
                i = 0;
                System.out.println();
            }
            j++;
            i++;
        }


    }
}
