package gr.peoplecert.bootcamp.handlers;

import gr.peoplecert.bootcamp.entities.Trainer;
import gr.peoplecert.bootcamp.utils.Utils;

public class TrainerHandler {

    public static void createTrainer() {

        Trainer t1 = new Trainer();
        System.out.println("GIVE FIRST NAME");
        t1.setFirstName(Utils.extractValidString());
        System.out.println("GIVE LAST NAME");
        t1.setLastName(Utils.extractValidString());
        System.out.println("GIVE SUBJECT");
        t1.setSubject(Utils.extractValidString());
        Trainer.addTrainer(t1);
    }
}
