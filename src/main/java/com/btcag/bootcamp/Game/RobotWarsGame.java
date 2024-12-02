package com.btcag.bootcamp.Game;
import com.btcag.bootcamp.Maps.Map;
import com.btcag.bootcamp.Maps.MapView;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.User.User;
public class RobotWarsGame {
    public static void main(String[] args) {
        //Map erstellen
        Map map = new Map(15, 15);
        //2 Nutzer mit jeweils einem Roboter erstellen
        User user1 = new User("Spieler 1");
        Robot player1 = new Robot(1,7, map);
        User user2 = new User("Spieler 2");
        Robot player2 = new Robot(15, 7, map);
        System.out.println("Nach Robotern");
        //Zählervariable für Züge erstellen und Roboter Startpositionen festlegen
        int lastTurn = 1;

        //Powerups starten
        PowerUp[] powerUps = {new PowerUp(7,7, map), new PowerUp(6,6, map), new PowerUp(8,8, map)};
        //Intro abspielen
        GameView.intro(user1.getName(), user2.getName());

        //Während niemand das Spiel gewonnen hat
        while (!GameValidationController.checkWin(player1, player2)) {
            MapView.drawMap(map, player1, player2, powerUps);
            //Spieler 1
            if (lastTurn == 1) {
                for (int i = player1.getMovement(); i > 0; i--) {
                    GameController.turn(player1, player2, user1.getName(), map, powerUps);
                    if(GameController.afterTurnRangeCheck(player1, player2, user1.getName())) {
                        i=0;
                    }
                }
                lastTurn = 2;
            } else if (lastTurn == 2) {
                //Spieler 2
                for (int i = player2.getMovement(); i > 0; i--) {
                    GameController.turn(player2, player1, user2.getName(), map, powerUps);
                    if(GameController.afterTurnRangeCheck(player2, player1, user2.getName())){
                        i=0;
                    }
                }

                lastTurn = 1;
            }
        }
        //Nachdem einer gewonnen hat
        System.out.println();
        String winner = GameController.getWinner(player1, player2, user1, user2);
       GameView.printWinMessage(winner);
    }
}