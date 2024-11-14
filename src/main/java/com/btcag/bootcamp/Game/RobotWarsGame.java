package com.btcag.bootcamp.Game;
import com.btcag.bootcamp.Maps.Map;
import com.btcag.bootcamp.Maps.MapView;
import com.btcag.bootcamp.PowerUps.*;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.Robots.RobotController;
import com.btcag.bootcamp.Robots.RobotView;
import com.btcag.bootcamp.User.User;
import java.util.Scanner;
public class RobotWarsGame {
    public static void main(String[] args) {
        //2 Nutzer mit jeweils einem Roboter erstellen
        User user1 = new User("Spieler 1");
        Robot player1 = new Robot();
        User user2 = new User("Spieler 2");
        Robot player2 = new Robot();
        System.out.println("Nach Robotern");
        //Zählervariable für Züge erstellen und Roboter Startpositionen festlegen
        int lastTurn = 1;
        player1.setX(1);
        player1.setY(7);
        player2.setX(15);
        player2.setY(7);
        //Powerups starten
        PowerUps powerUps = new PowerUps(player1, player2);
        //Intro abspielen
        GameView.intro(user1.getName(), user2.getName());
        //Map erstellen
        Map map = new Map(15, 15);
        //Während niemand das Spiel gewonnen hat
        while (!GameValidationController.checkWin(player1, player2)) {
            //Spieler 1
            if (lastTurn == 1) {
                for (int i = player1.getMovement(); i > 0; i--) {
                    GameController.turn(player1, player2, user1.getName(), powerUps, map);
                }
               GameController.afterTurnRangeCheck(player1, player2, map, powerUps);
                lastTurn = 2;
            } else if (lastTurn == 2) {
                //Spieler 2
                for (int i = player2.getMovement(); i > 0; i--) {
                    GameController.turn(player2, player1, user2.getName(), powerUps, map);
                }
                GameController.afterTurnRangeCheck(player2, player1, map, powerUps);
                lastTurn = 1;
            }
        }
        //Nachdem einer gewonnen hat
        System.out.println();
        String winner = GameController.getWinner(player1, player2, user1, user2);
       GameView.printWinMessage(winner);
    }
}