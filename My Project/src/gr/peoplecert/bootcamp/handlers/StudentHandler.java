package gr.peoplecert.bootcamp.handlers;

import gr.peoplecert.bootcamp.entities.Student;
import gr.peoplecert.bootcamp.utils.Utils;

public class StudentHandler {
    public static void createStudent() {
        Student student = new Student();
        System.out.println("GIVE FIRST NAME");
        student.setFirstName(Utils.extractValidString());

        System.out.println("GIVE LAST NAME");
        student.setLastName(Utils.extractValidString());

        student.setDateOfBirth(Utils.getValidDate("GIVE DATE OF BIRTH"));

        System.out.println("GIVE TUITION FEE");
        student.setTuitionFees(Utils.extractDoubleInRange(0D, 100D));
        Student.addStudent(student);
    }


}
