package com.btcag.bootcamp;
import java.util.Scanner;
public class Intro {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String Username;

        do {
            System.out.println("Bitte geben sie Ihren Nutzernamen ein:");
            Username= scanner.nextLine();
        }while(Username.length()>16 || Username.length()<4);



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
                System.out.println("          "+Username);





    }
}
