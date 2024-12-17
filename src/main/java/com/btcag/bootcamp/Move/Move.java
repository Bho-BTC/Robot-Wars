package com.btcag.bootcamp.Move;

import com.btcag.bootcamp.Hibernate.Enums.MoveType;
import com.btcag.bootcamp.Robots.Robot;

import com.btcag.bootcamp.Robots.alignment;
import com.btcag.bootcamp.User.User;

import javax.swing.*;

public class Move {
    private MoveType moveType;
    private Long userId;
    private alignment alignment;


    public MoveType getMoveType() {
        return moveType;
    }

    public Long getUserId() {
        return userId;
    }

    public com.btcag.bootcamp.Robots.alignment getAlignment() {
        return alignment;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setAlignment(com.btcag.bootcamp.Robots.alignment alignment) {
        this.alignment = alignment;
    }
}

