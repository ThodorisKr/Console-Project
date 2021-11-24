/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.peoplecert.bootcamp.utils;

import gr.peoplecert.bootcamp.entities.Assignment;
import gr.peoplecert.bootcamp.entities.Course;
import gr.peoplecert.bootcamp.entities.Student;
import gr.peoplecert.bootcamp.entities.Trainer;

import java.time.LocalDate;

/**
 * @author Theodore
 */
public class SyntheticDataUtils {

    public static boolean hasLoaded = false;

    /**
     * A method that creates all the synthetic data
     */
    public static void createData() {
        if (hasLoaded) {
            System.out.println("SYNTHETIC DATA HAVE BEEN ALREADY LOADED");
        } else {
            Student s1 = new Student("Giannis", "Dimitrakopoulos", LocalDate.of(1990, 8, 19), 2000);
            Student s2 = new Student("Giannis", "Tsiklitiras", LocalDate.of(1991, 7, 15), 2050);
            Student s3 = new Student("Giwrgos", "Delikouras", LocalDate.of(1987, 3, 25), 2000);
            Student s4 = new Student("Panagiwtis", "Diplarakos", LocalDate.of(1988, 8, 19), 1980);
            Student s5 = new Student("Nikolaos", "Papadopoulos", LocalDate.of(1995, 2, 11), 2000);
            Student s6 = new Student("Vasileios", "Karaiskos", LocalDate.of(1987, 7, 13), 2050);
            Student s7 = new Student("Mixalis", "Mylwnas", LocalDate.of(1996, 1, 16), 2000);
            Student s8 = new Student("Giannis", "Xrisanthakopoulos", LocalDate.of(1989, 8, 9), 2000);
            Student s9 = new Student("Apostolos", "Kolitsopoulos", LocalDate.of(1990, 2, 5), 2200);
            Student s10 = new Student("Stratos", "Delikouras", LocalDate.of(1994, 12, 6), 2000);
            Student s11 = new Student("Dimitrios", "Zapantiwtis", LocalDate.of(2000, 8, 20), 2000);
            Student s12 = new Student("Kwnstantinos", "Pantiwras", LocalDate.of(1997, 3, 19), 2000);
            Student s13 = new Student("Giannis", "Swtirakos", LocalDate.of(1994, 11, 10), 2000);
            Student s14 = new Student("Ilias", "Vasilas", LocalDate.of(1994, 9, 7), 2000);
            Student s15 = new Student("Xrhstos", "Mixail", LocalDate.of(1999, 7, 20), 2000);

            /**
             * Create an ArrayList and fill it with students
             */
            Student.addStudent(s1);
            Student.addStudent(s2);
            Student.addStudent(s3);
            Student.addStudent(s4);
            Student.addStudent(s5);
            Student.addStudent(s6);
            Student.addStudent(s7);
            Student.addStudent(s8);
            Student.addStudent(s9);
            Student.addStudent(s10);
            Student.addStudent(s11);
            Student.addStudent(s12);
            Student.addStudent(s13);
            Student.addStudent(s14);
            Student.addStudent(s15);

            Trainer t1 = new Trainer("Giannis", "Koutsikos", "Data structure");
            Trainer t2 = new Trainer("Alexandros", "Papadeas", "Algorithms");
            Trainer t3 = new Trainer("Vasileios", "Katsantwnis", "Computer Architecture");
            Trainer t4 = new Trainer("Iwanna", "Koutromanou", "Object-Oriented Programming");

            Trainer.addTrainer(t1);
            Trainer.addTrainer(t2);
            Trainer.addTrainer(t3);
            Trainer.addTrainer(t4);

            Course c1 = new Course("CB7", "Java", "part time", LocalDate.of(2021, 4, 10), LocalDate.of(2021, 8, 25));
            Course c2 = new Course("CB7", "C#", "full time", LocalDate.of(2021, 4, 15), LocalDate.of(2021, 8, 20));
            Course c3 = new Course("CB6", "Python", "part time", LocalDate.of(2021, 4, 28), LocalDate.of(2021, 8, 31));

            Course.addCourse(c1);
            Course.addCourse(c2);
            Course.addCourse(c3);

            Assignment A1 = new Assignment("Project A", "SE program", LocalDate.of(2021, 5, 30), 60, 100);
            Assignment A2 = new Assignment("Project B", "Data base", LocalDate.of(2021, 6, 30), 35, 94);
            Assignment A3 = new Assignment("Project C", "Final project", LocalDate.of(2021, 8, 25), 43, 88);

            Assignment.addAssignment(A1);
            Assignment.addAssignment(A2);
            Assignment.addAssignment(A3);
            /**
             * Match all the students,trainers,assignments to courses
             */
            c1.addStudent(s1);
            c1.addStudent(s2);
            c1.addStudent(s3);
            c1.addStudent(s4);
            c1.addStudent(s5);
            c1.addTrainer(t1);
            c1.addTrainer(t2);
            c1.addTrainer(t4);
            c1.addAssignment(A1);
            c1.addAssignment(A3);

            c2.addStudent(s6);
            c2.addStudent(s7);
            c2.addStudent(s8);
            c2.addStudent(s9);
            c2.addStudent(s10);
            c2.addTrainer(t2);
            c2.addTrainer(t3);
            c2.addTrainer(t4);
            c2.addAssignment(A2);
            c2.addAssignment(A3);

            c3.addStudent(s11);
            c3.addStudent(s12);
            c3.addStudent(s13);
            c3.addStudent(s14);
            c3.addStudent(s15);
            c3.addTrainer(t1);
            c3.addTrainer(t3);
            c3.addTrainer(t4);
            c3.addAssignment(A1);
            c3.addAssignment(A3);
            hasLoaded = true;
            System.out.println("SYNTHETIC DATA HAVE BEEN LOADED");
        }
    }

    /**
     * A method that prints all students
     */
    public static void printMyStudents() {
        for (Student myStudent : Student.getAllStudents()) {
            System.out.println(myStudent.toString());

        }
    }

    /**
     * A method that prints all trainers
     */
    public static void printMyTrainers() {
        for (Trainer myTrainer : Trainer.getAllTrainers()) {
            System.out.println(myTrainer.toString());

        }
    }

    /**
     * A method that prints all assignments
     */
    public static void printMyAssignments() {
        for (Assignment myAssignment : Assignment.getAllAssignments()) {
            System.out.println(myAssignment.toString());
        }
    }

    /**
     * A method that prints all courses
     */
    public static void printMyCourses() {
        for (Course mycourse : Course.getAllCourses()) {
            System.out.println(mycourse.toString());
        }
    }

}
