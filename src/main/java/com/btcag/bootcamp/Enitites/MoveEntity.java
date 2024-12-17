package com.btcag.bootcamp.Enitites;

import com.btcag.bootcamp.Hibernate.Enums.MoveType;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
@Entity(name = "Move")
@Table(name = "move")
public class MoveEntity {
    @Column(name = "move_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private GameEntity game;
    @OneToMany(mappedBy = "move", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RobotManipulator> robotManipulations = new ArrayList<>();
    @Enumerated(EnumType.STRING)
    private MoveType moveType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GameEntity getGame() {
        return game;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public List<RobotManipulator> getRobotManipulations() {
        return robotManipulations;
    }

    public void setRobotManipulations(List<RobotManipulator> robotManipulations) {
        this.robotManipulations = robotManipulations;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }
}