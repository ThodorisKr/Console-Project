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
public class Student {

    private static ArrayList<Student> allStudents = new ArrayList<>();

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private double tuitionFees;

    public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, double tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    public static ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public static void clearAll() {
        Student.allStudents = new ArrayList<>();
    }

    public static void addStudent(Student student) {
        allStudents.add(student);
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    @Override
    public String toString() {
        return "* " + firstName + ", " + lastName + ", " + dateOfBirth + ", " + tuitionFees + "*";
    }

    public ArrayList<Course> studentCourses() {
        ArrayList<Course> c1 = new ArrayList();
        for (Course course : Course.getAllCourses()) {
            if (course.getStudentsPerCourse().contains(this)) {
                c1.add(course);
            }

        }
        return c1;
    }

    public ArrayList<Assignment> getAssignments() {
        ArrayList<Assignment> assignmentsList = new ArrayList();
        for (Course course : this.studentCourses()) {
            for (Assignment assignment : course.getAssignmentsPerCourse()) {
                assignmentsList.add(assignment);
            }
        }
        return assignmentsList;
    }
}
