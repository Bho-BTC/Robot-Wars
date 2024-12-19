package com.btcag.bootcamp.Hibernate.Interfaces;
import com.btcag.bootcamp.Enitites.RobotEntity;
import com.btcag.bootcamp.Robots.Robot;
import com.btcag.bootcamp.User.User;



import java.util.ArrayList;

public interface IRobotServices {
    public ArrayList<Robot> getAllRobots(int gameID); // gibt alle robots des Games
    public RobotEntity getRobot(int id); // gibt specific robot
    public RobotEntity createRobot(User user); // Lässt User Stats skillen
}

