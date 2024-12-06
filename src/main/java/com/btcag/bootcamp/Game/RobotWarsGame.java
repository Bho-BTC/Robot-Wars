package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Maps.Map;
import com.btcag.bootcamp.Maps.MapView;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.PowerUps.PowerUpController;
import com.btcag.bootcamp.RobotPowerUp.RobotPowerUpController;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.User.User;

public class RobotWarsGame {
    public static void main(String[] args) {
        //Map erstellen
        Map map = new Map(15, 15);
        //
        char wallChar = 219;


        //2 Nutzer mit jeweils einem Roboter erstellen
        User user1 = new User("Spieler 1");
        Robot player1 = new Robot(1, 7, map);
        User user2 = new User("Spieler 2");
        Robot player2 = new Robot(15, 7, map);
        Robot[] robots = new Robot[]{player1, player2};
        System.out.println("Nach Robotern");
        //Zählervariable für Züge erstellen und Roboter Startpositionen festlegen
        int nextTurn = 1;

        //Powerups starten
        PowerUp[] powerUps = {new PowerUp(7, 7, map), new PowerUp(6, 6, map), new PowerUp(8, 8, map)};
        //Intro abspielen
        GameView.intro(user1.getName(), user2.getName());

        //Während niemand das Spiel gewonnen hat
        while (!GameValidationController.checkWin(player1, player2)) {
            MapView.drawMap(map, player1, player2, powerUps);
            //Spieler 1
            if (nextTurn == 1) {
                GameController.takeTurn(map, user1, player1, player2, powerUps);
                nextTurn = 2;
            } else if (nextTurn == 2) {
                //Spieler 2
                GameController.takeTurn(map, user2, player2, player1, powerUps);
                nextTurn = 1;
            }
            for (PowerUp powerUp : powerUps) {
                PowerUpController.update(powerUp);
            }
        }
        //Nachdem einer gewonnen hat
        System.out.println();
        String winner = GameController.getWinner(player1, player2, user1, user2);
        GameView.printWinMessage(winner);
    }


}