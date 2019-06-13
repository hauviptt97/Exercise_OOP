package view.exercise03;

import controllers.exercise03.StudentController;
import entities.exercise03.Student;

public class Demo {
    public static void main(String[] args) {
        StudentController sc = new StudentController("D:/student.json");
        //sc.addStudent(Student.StudentBuilder.newInstance().setFirstName("Hau").setLastName("Bui Van ").setClassName("15T2").build());
    }
}
