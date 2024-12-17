package com.btcag.bootcamp.Hibernate.Services;

import com.btcag.bootcamp.Hibernate.Interfaces.IPlayerServices;
import com.btcag.bootcamp.User.User;

import java.util.ArrayList;

public class PlayerService implements IPlayerServices {
    @Override
    public ArrayList<User> getPlayers(int gameID) {
        return null;
    };

    @Override
    public User getPlayer(int id) {
        return null;
    }

    @Override
    public void createPlayer(){
    }
}