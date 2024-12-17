package com.btcag.bootcamp;

import com.btcag.bootcamp.Enitites.*;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(GameEntity.class)
                .addAnnotatedClass(MapEntity.class)
                .addAnnotatedClass(MapItem.class)
                .addAnnotatedClass(Robot.class)
                .addAnnotatedClass(ItemEntity.class)
                .addAnnotatedClass(RobotManipulator.class)
                .addAnnotatedClass(MoveEntity.class)
                .buildSessionFactory();

        try (Session session = factory.openSession()) {
            session.beginTransaction();
        } finally {
            factory.close();
        }
    }
}