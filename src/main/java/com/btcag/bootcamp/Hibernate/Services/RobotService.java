package com.btcag.bootcamp.Hibernate.Services;

import com.btcag.bootcamp.Enitites.RobotEntity;
import com.btcag.bootcamp.Hibernate.Interfaces.IRobotServices;
import com.btcag.bootcamp.User.User;
import com.btcag.bootcamp.Robots.Robot;

import java.util.ArrayList;

public class RobotService implements IRobotServices {
    @Override
    public ArrayList<Robot> getAllRobots(int gameID) {
        return null;
    }

    public RobotEntity getRobot(int robotID) {
        return null;
    }

    public RobotEntity createRobot(User user) {
        return null;
    }
}