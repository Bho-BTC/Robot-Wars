package com.btcag.bootcamp;

import java.util.Scanner;

public class User {
    String name;




    //------------------------------------Holt sich Input vom Nutzer, braucht eine Nachricht zum Auffordern-------------------------------------------------------
    public static String getName(String message) {
        Scanner scanner = new Scanner(System.in);
        String username;

        do {
            System.out.println(message);
            username = scanner.nextLine();
        } while (username.length() > 16 || username.length() < 3);

        return username;
    }

    public User(String name) {
        this.name = getName(name+", geben sie Ihren Nutzernamen an. Der Name muss mindestens 3 sein und nicht mehr als 12 Zeichen lang sein.");


    }




}
