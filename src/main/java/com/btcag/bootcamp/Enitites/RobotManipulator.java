package com.btcag.bootcamp.Enitites;

import com.btcag.bootcamp.Hibernate.Enums.Align;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "RobotManipulator")
@Table(name = "robot-manipulator")
public class RobotManipulator {
    @Column(name = "robot_manipulator_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "move_id", nullable = false)
    private MoveEntity move;
    @Column(name = "align")
    @Enumerated(EnumType.STRING)
    private Align align;
    @ManyToOne
    @JoinColumn(name = "robot_id", nullable = false)
    private RobotEntity robotEntity;
    @OneToMany(mappedBy = "robotManipulator", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemEntity> items = new ArrayList<>();
    @Column(name = "health_manipulator")
    private int healthManipulator;
    @Column(name = "attack_damage_manipulator")
    private int attackDamageManipulator;
    @Column(name = "attack_range_manipulator")
    private int attackRangeManipulator;
    @Column(name = "movement_range_manipulator")
    private int movementRangeManipulator;
    @Column(name = "current_map_array_index")
    private int currentMapArrayIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MoveEntity getMove() {
        return move;
    }

    public void setMove(MoveEntity move) {
        this.move = move;
    }

    public Align getAlign() {
        return align;
    }

    public void setAlign(Align align) {
        this.align = align;
    }

    public RobotEntity getRobot() {
        return robotEntity;
    }

    public void setRobot(RobotEntity robotEntity) {
        this.robotEntity = robotEntity;
    }

    public List<ItemEntity> getItems() {
        return items;
    }

    public void setItems(List<ItemEntity> items) {
        this.items = items;
    }

    public int getHealthManipulator() {
        return healthManipulator;
    }

    public void setHealthManipulator(int healthManipulator) {
        this.healthManipulator = healthManipulator;
    }

    public int getAttackDamageManipulator() {
        return attackDamageManipulator;
    }

    public void setAttackDamageManipulator(int attackDamageManipulator) {
        this.attackDamageManipulator = attackDamageManipulator;
    }

    public int getAttackRangeManipulator() {
        return attackRangeManipulator;
    }

    public void setAttackRangeManipulator(int attackRangeManipulator) {
        this.attackRangeManipulator = attackRangeManipulator;
    }

    public int getMovementRangeManipulator() {
        return movementRangeManipulator;
    }

    public void setMovementRangeManipulator(int movementRangeManipulator) {
        this.movementRangeManipulator = movementRangeManipulator;
    }

    public int getCurrentMapArrayIndex() {
        return currentMapArrayIndex;
    }

    public void setCurrentMapArrayIndex(int currentMapArrayIndex) {
        this.currentMapArrayIndex = currentMapArrayIndex;
    }
}