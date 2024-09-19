package com.btcag.bootcamp;
import java.util.Scanner;
public class Intro {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        System.out.println("Bitte geben sie Ihren Nutzernamen ein:");

        String Username= scanner.nextLine();

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
