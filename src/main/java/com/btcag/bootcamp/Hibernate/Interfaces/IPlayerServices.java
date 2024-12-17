package com.btcag.bootcamp.Hibernate.Interfaces;

import com.btcag.bootcamp.User.User;

import java.util.ArrayList;

public interface IPlayerServices {
    public ArrayList<User> getPlayers(int gameID);  // gibt alle Player des aktuellen Spiels
    public User getPlayer(int id); // gibt bestimmten Spieler
    public void createPlayer();
}