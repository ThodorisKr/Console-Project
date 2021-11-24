package gr.peoplecert.bootcamp.handlers;

import gr.peoplecert.bootcamp.entities.Trainer;
import gr.peoplecert.bootcamp.utils.Utils;
import gr.peoplecert.bootcamp.entities.Course;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import static java.util.Objects.isNull;
import static gr.peoplecert.bootcamp.entities.Assignment.getAllAssignments;
import static gr.peoplecert.bootcamp.entities.Course.getAllCourses;
import static gr.peoplecert.bootcamp.entities.Student.getAllStudents;

public class CourseHandler {
    public static void createCourse() {
        Scanner sc = new Scanner(System.in);

        Course course = new Course();
        System.out.println("GIVE TITLE");
        course.setTitle(Utils.extractValidString());
        System.out.println("GIVE STREAM");
        course.setStream(Utils.extractValidString());
        System.out.println("GIVE TYPE");
        course.setType(Utils.extractValidString());
        course.setStartDate(Utils.getValidDate("GIVE A START DATE"));
        System.out.println();
        course.setEndDate(getValidDateInRange("GIVE AN END DATE", course.getStartDate(), course.getStartDate().plusMonths(6)));
        Course.addCourse(course);
    }

    private static LocalDate getValidDateInRange(String message, LocalDate start, LocalDate end) {
        LocalDate inputDate = null;
        while (isNull(inputDate)) {
            inputDate = Utils.getValidDate(message);
            if (inputDate.isBefore(start) || inputDate.isAfter(end)) {
                System.out.println("DATE IS NOT WITHIN RANGE [" + start + ", " + end + "]");
                inputDate = null;
            }
        }
        return inputDate;
    }

    public static void addStudentToCourse() {
        if (coursesAndOtherListAreBothEmpty("STUDENTS", getAllStudents())) return;

        Integer courseSelection = getSelection("COURSE", getAllCourses());

        Integer studentSelection = getSelection("STUDENT", getAllStudents());

        getAllCourses().get(courseSelection).addStudent(getAllStudents().get(studentSelection));
        System.out.println("STUDENT HAS BEEN ADDED");
    }

    public static void addTrainerToCourse() {
        Scanner sc = new Scanner(System.in);

        if (coursesAndOtherListAreBothEmpty("TRAINERS", Trainer.getAllTrainers())) return;

        Integer courseSelection = getSelection("COURSE", getAllCourses());

        Integer trainerSelection = getSelection("TRAINER", Trainer.getAllTrainers());

        getAllCourses().get(courseSelection).addTrainer(Trainer.getAllTrainers().get(trainerSelection));
        System.out.println("TRAINER HAS BEEN ADDED");
    }

    public static void addAssignmentToCourse() {
        Scanner sc = new Scanner(System.in);

        if (coursesAndOtherListAreBothEmpty("ASSIGNMENTS", getAllAssignments())) return;
        Integer courseSelection = getSelection("COURSE", getAllCourses());

        Integer assignmentSelection = getSelection("ASSIGNMENT", getAllAssignments());

        getAllCourses().get(courseSelection).addAssignment(getAllAssignments().get(assignmentSelection));
        System.out.println("ASSIGNMENT HAS BEEN ADDED");
    }


    private static Integer getSelection(String entityName, List entities) {
        Integer selection = null;
        while (selection == null) {
            System.out.println("PICK A " + entityName);

            for (int i = 0; i < entities.size(); i++) {
                System.out.println((i + 1) + " " + entities.get(i).toString());
            }

            String inputSelection = Utils.extractValidString();
            try {
                selection = Integer.parseInt(inputSelection) - 1;
                if (selection < 0 || selection >= entities.size()) {
                    throw new Exception(entityName + " SELECTION NOT WITHIN RANGE");
                }
            } catch (NumberFormatException e) {
                System.out.println("IS NOT A NUMBER");
            } catch (Exception e) {
                selection = null;
                System.out.println(e.getMessage());
            }
        }
        System.out.println("YOU PICKED " + entityName + " " + (selection + 1));
        return selection;
    }

    private static boolean coursesAndOtherListAreBothEmpty(String otherEntityNameInPlural, List otherEntities) {
        if (getAllCourses().isEmpty()) {
            System.out.println("NO COURSES ADD A COURSE");
            return true;
        }
        if (otherEntities.isEmpty()) {
            System.out.println("NO " + otherEntityNameInPlural);
            return true;
        }
        return false;
    }


}
