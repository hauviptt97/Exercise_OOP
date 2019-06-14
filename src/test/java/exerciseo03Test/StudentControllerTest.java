package exerciseo03Test;

import controllers.exercise03.StudentController;
import entities.exercise03.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

public class StudentControllerTest {

    @Test
    public void test_getStudents() {
        List<Student> students = new StudentController("D:/student.json").getStudents();

        assertNotNull(students);
    }

    @Test
    public void test_getById() {
        assertNotNull(new StudentController("D:/student.json").getById(7));
        assertNull(new StudentController("D:/student.json").getById(5));
    }

    @Test
    public void test_findByName() {
        assertNotNull(new StudentController("D:/student.json").findByName("Hau"));
        assertEquals(new StudentController("D:/student.json").findByName("hoa"), new ArrayList<>());
    }

    @Test
    public void test_findByClassName() {
        assertEquals(new StudentController("D:/student.json").findByClassName("15T2").size(), 13);
        assertEquals(new StudentController("D:/student.json").findByClassName("gg"), new ArrayList<>());
    }

    @Test
    public void test_addStudent() {
        StudentController sc = new StudentController("D:/student.json");

        int default_length = sc.getStudents().size();

        sc.addStudent(Student.StudentBuilder.newInstance().setFirstName("Hau").setLastName("Bui").setClassName("112").build());

        assertEquals(sc.getStudents().size(), default_length + 1);
    }

    @Test
    public void test_deleteStudent() {
        StudentController sc = new StudentController("D:/student.json");

        int default_length = sc.getStudents().size();

        assertTrue(sc.deleteStudent(29));

        assertEquals(sc.getStudents().size(), default_length - 1);

        assertFalse(sc.deleteStudent(6));
    }


}
