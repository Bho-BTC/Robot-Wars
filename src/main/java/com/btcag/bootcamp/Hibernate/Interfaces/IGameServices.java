package com.btcag.bootcamp.Hibernate.Interfaces;

import com.btcag.bootcamp.Game.RobotWarsGame;
import com.btcag.bootcamp.Move.Move;

import java.awt.*;
import java.util.ArrayList;

public interface IGameServices {
    public RobotWarsGame getGame(int id);
    public RobotWarsGame createGame(int playerCount, int MapID, ArrayList<Robot> robots);
    public ArrayList<Move> getMoves(int gameID);
    public ArrayList<Move> getMovesAfter(int gameID, int moveID);
    public Move getMove(int gameID, int moveID);
    public void makeMove(int gameID, Move move);

};