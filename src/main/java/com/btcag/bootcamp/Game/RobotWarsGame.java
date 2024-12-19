package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Maps.Map;
import com.btcag.bootcamp.Maps.MapController;
import com.btcag.bootcamp.Maps.MapView;
import com.btcag.bootcamp.Obstacles.Walls;
import com.btcag.bootcamp.PowerUps.PowerUp;
import com.btcag.bootcamp.PowerUps.PowerUpController;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.User.User;

public class RobotWarsGame {
    private Map map;
    private Robot[] robots;
    private User[] users;
    private PowerUp[] powerUps;


    public RobotWarsGame(Map map, Robot[] robots, User[] users) {
        this.map = map;
        this.robots = robots;
        this.users = users;

    }

    public void play() {

        //Zähler variable für Züge erstellen und Roboter Startpositionen festlegen
        int TurnCount = 1;

        //Powerups starten
        int numberOfPowerUps = MapController.getAmountOfThese(map.getPowerUpChar(), map);
        int[] locationsOfPowerUps = MapController.getLocationOfThese(map.getPowerUpChar(), map, numberOfPowerUps);

        PowerUp[] powerUps = new PowerUp[numberOfPowerUps];
        int i = 0;
        for (int location : locationsOfPowerUps) {
            int x;
            int y;

            x = location % map.getMaxX();


            y = location / map.getMaxY();

            powerUps[i] = new PowerUp(x, y);
            i++;
        }


        //                  Roboter------------------------------------------------------------------------------
        int numberOfRobots = MapController.getAmountOfThese(map.getRobotChar(), map);
        System.out.println(numberOfRobots + " Roboter");
        int[] locationsOfRobots = MapController.getLocationOfThese(map.getRobotChar(), map, numberOfRobots);
        System.out.println(locationsOfRobots[0] + " Roboter 1    " + locationsOfRobots[1] + " Roboter 2");
        int k = 0;
        for (int location : locationsOfRobots) {
            int x;
            int y;

            x = location % map.getMaxX();


            y = location / map.getMaxY();

            robots[k].setX(x);
            robots[k].setY(y);
            System.out.println("Robot " + robots[k].getAvatar());
            System.out.println("Location: " + location);
            System.out.println("X: " + robots[k].getX() + "   Y: " + robots[k].getY());
            k++;
        }

//        0 0 0 0 0 5
//        0 0 0 0 0 10
//        0 0 0 0 0 15
//        0 0 0 0 0 20
//        0 0 0 0 0 25
//        0 0 0 0 0 30


        int numberOfWalls = MapController.getAmountOfThese(map.getWallChar(), map);
        int[] locationOfWalls = MapController.getLocationOfThese(map.getWallChar(), map, numberOfWalls);

        Walls[] walls = new Walls[numberOfWalls];
        int j = 0;
        for (int location : locationOfWalls) {
            int x;
            int y;


            x = location % map.getMaxX();
            y = location / map.getMaxY();

            walls[j] = new Walls(x, y);
            j++;
        }


        //Intro abspielen
        GameView.intro(users[0].getName(), users[1].getName());

        //Während niemand das Spiel gewonnen hat
        while (!GameValidationController.checkWin(robots)) {
            MapView.drawMap(map, robots, powerUps, walls);
            //Spieler 1
            if (TurnCount % 2 == 1) {
                GameController.takeTurn(map, users[0], robots[0], robots, powerUps, walls);

            } else if (TurnCount % 2 != 1) {
                //Spieler 2
                GameController.takeTurn(map, users[1], robots[1], robots, powerUps, walls);

            }
            TurnCount++;
            for (PowerUp powerUp : powerUps) {
                PowerUpController.update(powerUp);
            }
        }
        //Nachdem einer gewonnen hat
        System.out.println();
        String winner = GameController.getWinner(robots[0], robots[1], users[0], users[1]);
        GameView.printWinMessage(winner);
    }


}