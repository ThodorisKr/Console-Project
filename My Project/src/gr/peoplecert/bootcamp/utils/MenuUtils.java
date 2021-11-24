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
import gr.peoplecert.bootcamp.handlers.AssignmentHandler;
import gr.peoplecert.bootcamp.handlers.CourseHandler;
import gr.peoplecert.bootcamp.handlers.StudentHandler;
import gr.peoplecert.bootcamp.handlers.TrainerHandler;

import java.time.LocalDate;

/**
 * @author Theodore
 */
public class MenuUtils {

    /**
     * A method that gives the first menu to the user
     */
    public static void introMenu() {
        boolean menu = true;
        while (menu) {
            System.out.println("1: LOAD YOUR DATA");
            System.out.println("2: LOAD SYNTHETIC DATA");
            System.out.println("3: CLEAR DATA");
            System.out.println("0: END PROGRAM");
            String input = Utils.extractValidString();
            switch (input) {
                case "1":
                    MenuUtils.menu2();
                    break;
                case "2":
                    SyntheticDataUtils.createData();
                    MenuUtils.menu1();
                    break;
                case "3":
                    clearData();
                    break;
                case "0":
                    menu = false;
                    break;
                default:
                    System.out.println("WRONG INPUT");
                    break;
            }
        }

    }

    private static void clearData() {
        Course.clearAll();
        Student.clearAll();
        Trainer.clearAll();
        Assignment.clearAll();
        SyntheticDataUtils.hasLoaded = false;
        System.out.println("ALL DATA HAVE BEEN CLEARED");
    }

    /**
     * A method for the second menu
     */
    public static void menu1() {
        boolean menu1 = true;
        while (menu1) {
            options();
            String input1 = Utils.extractValidString();
            switch (input1) {
                case "1":
                    SyntheticDataUtils.printMyStudents();
                    break;
                case "2":
                    SyntheticDataUtils.printMyTrainers();
                    break;
                case "3":
                    SyntheticDataUtils.printMyCourses();
                    break;
                case "4":
                    SyntheticDataUtils.printMyAssignments();
                    break;
                case "5":
                    for (Course course : Course.getAllCourses()) {
                        System.out.println();
                        System.out.println(course);
                        for (Student student : course.getStudentsPerCourse()) {
                            System.out.println("--" + student);
                        }
                    }
                    break;
                case "6":
                    for (Course course : Course.getAllCourses()) {
                        System.out.println();
                        System.out.println(course);
                        for (Trainer trainer : course.getTrainersPerCourse()) {
                            System.out.println("--" + trainer);
                        }
                    }
                    break;
                case "7":
                    for (Course course : Course.getAllCourses()) {
                        System.out.println();
                        System.out.println(course);
                        for (Assignment assignment : course.getAssignmentsPerCourse()) {
                            System.out.println("--" + assignment);
                        }
                    }
                    break;
                case "8":
                    for (Student student : Student.getAllStudents()) {
                        System.out.println(student.getFirstName() + "     " + student.getLastName());
                        for (Assignment assignment : student.getAssignments()) {
                            System.out.println(assignment);
                        }
                    }
                    break;
                case "9":
                    getAssignmentsAtDate();
                    break;
                case "0":
                    menu1 = false;
                    break;
                default:
                    System.out.println("wrong input");
                    break;
            }

        }

    }

    private static void getAssignmentsAtDate() {
        LocalDate inputDate = Utils.getValidDate("GIVE A DATE");
        LocalDate startOfWeek = inputDate.minusDays(inputDate.getDayOfWeek().getValue() - 1);
        LocalDate endOfWeek = startOfWeek.plusDays(6);
        for (Assignment assignment : Assignment.getAllAssignments()) {
            if (assignment.getSubDateTime().equals(startOfWeek) ||
                    assignment.getSubDateTime().equals(endOfWeek) ||
                    (assignment.getSubDateTime().isAfter(startOfWeek) && assignment.getSubDateTime().isBefore(endOfWeek))) {
                System.out.println("Assignment: " + assignment.toString());
            }
        }
    }

    public static void menu2() {
        boolean menu2 = true;
        while (menu2) {
            options2();
            String input2 = Utils.extractValidString();
            switch (input2) {
                case "1":
                    StudentHandler.createStudent();
                    break;
                case "2":
                    TrainerHandler.createTrainer();
                    break;
                case "3":
                    CourseHandler.createCourse();
                    break;
                case "4":
                    AssignmentHandler.createAssignment();
                    break;
                case "5":
                    CourseHandler.addStudentToCourse();
                    break;
                case "6":
                    CourseHandler.addTrainerToCourse();
                    break;
                case "7":
                    CourseHandler.addAssignmentToCourse();
                    break;
                case "8":
                    MenuUtils.menu1();
                    break;
                case "0":
                    menu2 = false;
                    break;
                default:
                    System.out.println("WRONG INPUT");
                    break;

            }
        }

    }

    /**
     * A method for the 3rd menu
     */
    public static void options2() {
        System.out.println("1: CREATE STUDENT");
        System.out.println("2: CREATE TRAINER");
        System.out.println("3: CREATE COURSE");
        System.out.println("4: CREATE ASSIGNMENT");
        System.out.println("5: ADD A STUDENT TO A COURSE");
        System.out.println("6: ADD A TRAINER TO A COURSE");
        System.out.println("7: ADD AN ASSIGNMENT TO A COURSE");
        System.out.println("8: GO TO PRINT MENU!");
        System.out.println("0: GO BACK");
    }

    public static void options() {
        System.out.println("1: ALL THE STUDENTS");
        System.out.println("2: ALL THE TRAINERS");
        System.out.println("3: ALL THE COURSES");
        System.out.println("4: ALL THE ASSIGNMENTS");
        System.out.println("5: STUDENTS PER COURSE");
        System.out.println("6: TRAINERS PER COURSE");
        System.out.println("7: ASSIGNMENTS PER COURSE");
        System.out.println("8: ASSIGNMENTS PER STUDENT");
        System.out.println("9: ASSIGNMENTS AT THIS WEEK");
        System.out.println("0: GO BACK");
    }
}
