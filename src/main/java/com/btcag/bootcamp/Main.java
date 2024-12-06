package com.btcag.bootcamp;

import com.btcag.bootcamp.Enitites.*;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Game.class)
                .addAnnotatedClass(Map.class)
                .addAnnotatedClass(MapItem.class)
                .addAnnotatedClass(Robot.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(RobotManipulator.class)
                .addAnnotatedClass(Move.class)
                .buildSessionFactory();

        try (Session session = factory.openSession()) {
            session.beginTransaction();
        } finally {
            factory.close();
        }
    }
}