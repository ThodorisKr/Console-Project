/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.peoplecert.bootcamp.entities;

import java.util.ArrayList;

/**
 * @author Theodore
 */
public class Trainer {

    private static ArrayList<Trainer> allTrainers = new ArrayList<>();

    private String firstName;
    private String lastName;
    private String subject;

    public Trainer() {
    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    public static ArrayList<Trainer> getAllTrainers() {
        return allTrainers;
    }

    public static void clearAll() {
        Trainer.allTrainers = new ArrayList<>();
    }
    public static void addTrainer(Trainer trainer) {
        allTrainers.add(trainer);

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return firstName + "   " + lastName + "   " + subject;
    }

}
