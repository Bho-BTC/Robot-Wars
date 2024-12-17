package com.btcag.bootcamp.Hibernate.Services;

import com.btcag.bootcamp.Game.RobotWarsGame;
import com.btcag.bootcamp.Hibernate.Interfaces.IGameServices;
import com.btcag.bootcamp.Move.Move;

import java.awt.*;
import java.util.ArrayList;

public class GameService implements IGameServices {
    @Override
    public RobotWarsGame getGame(int id) {
        return null;
    };

    @Override
    public RobotWarsGame createGame(int playerCount, int MapID, ArrayList<Robot> robots) {
        return null;
    };

    @Override
    public ArrayList<Move> getMoves(int gameID) {
        return null;
    };

    @Override
    public ArrayList<Move> getMovesAfter(int gameID, int moveID) {
        return null;
    };

    @Override
    public Move getMove(int gameID, int moveID) {
        return null;
    }

    @Override
    public void makeMove(int gameID, Move move) {;
    };

}