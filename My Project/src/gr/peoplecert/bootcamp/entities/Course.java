/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.peoplecert.bootcamp.entities;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @author Theodore
 */
public class Course {

    private static ArrayList<Course> allCourses = new ArrayList<>();

    private String title;
    private String stream;
    private String type;
    private LocalDate startDate;
    private LocalDate endDate;

    private ArrayList<Student> studentsPerCourse = new ArrayList<>();
    private ArrayList<Trainer> trainersPerCourse = new ArrayList<>();
    private ArrayList<Assignment> assignmentsPerCourse = new ArrayList<>();

    public Course() {
    }

    public Course(String title, String stream, String type, LocalDate startDate, LocalDate endDate) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public static ArrayList<Course> getAllCourses() {
        return allCourses;
    }

    public static void clearAll() {
        Course.allCourses = new ArrayList<>();
    }
    public static void addCourse(Course course) {
        allCourses.add(course);
    }

    public ArrayList<Student> getStudentsPerCourse() {
        return studentsPerCourse;
    }

    public void setStudentsPerCourse(ArrayList<Student> studentsPerCourse) {
        this.studentsPerCourse = studentsPerCourse;
    }

    public void addStudent(Student student) {
        for (Student existingStudent : studentsPerCourse) {
            if (existingStudent == student) {
                return;
            }
        }
        this.studentsPerCourse.add(student);
    }

    public ArrayList<Assignment> getAssignmentsPerCourse() {
        return assignmentsPerCourse;
    }

    public void setAssignmentsPerCourse(ArrayList<Assignment> assignmentsPerCourse) {
        this.assignmentsPerCourse = assignmentsPerCourse;
    }

    public void addAssignment(Assignment assignment) {
        for (Assignment existingAssignment : assignmentsPerCourse) {
            if (existingAssignment == assignment) {
                return;
            }
        }
        this.assignmentsPerCourse.add(assignment);
    }

    public ArrayList<Trainer> getTrainersPerCourse() {
        return trainersPerCourse;
    }

    public void setTrainersPerCourse(ArrayList<Trainer> trainersPerCourse) {
        this.trainersPerCourse = trainersPerCourse;
    }

    public void addTrainer(Trainer trainer) {
        for (Trainer existingTrainer : trainersPerCourse) {
            if (existingTrainer == trainer) {
                return;
            }
        }
        this.trainersPerCourse.add(trainer);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate start_date) {
        this.startDate = start_date;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return title + "  " + stream + "  " + type + " " + startDate + "  " + endDate;
    }

    public void printTrainersPC() {
        for (Trainer trainer : trainersPerCourse) {
            System.out.println(trainer.toString());

        }
    }

    public void printAssignmentsPC() {
        for (Assignment assignment : assignmentsPerCourse) {
            System.out.println(assignment.toString());

        }
    }

}
