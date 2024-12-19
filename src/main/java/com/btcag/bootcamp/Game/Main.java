package com.btcag.bootcamp.Game;

import com.btcag.bootcamp.Maps.Map;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.User.User;

public class Main {
    public static void main(String[] args) {
        User user1 = new User("Spieler 1",1);
        Robot player1 = new Robot();
        User user2 = new User("Spieler 2",2);
        Robot player2 = new Robot();
        Robot[] robots = new Robot[]{player1, player2};
        User[] users = new User[]{user1, user2};



        System.out.println(robots[0].getAvatar());
        System.out.println(robots[1].getAvatar());

        //Test Map
        Map map = new Map(15, 15);

        RobotWarsGame game = new RobotWarsGame(map, robots, users);

      game.play();






    }
}
