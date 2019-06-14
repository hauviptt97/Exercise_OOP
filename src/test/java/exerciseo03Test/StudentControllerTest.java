package exerciseo03Test;

import controllers.exercise03.StudentController;
import entities.exercise03.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

public class StudentControllerTest {

    private StudentController sc = new StudentController("D:/student.json");

    private List<Student> students = sc.getStudents();

    @Test
    public void test_getStudents() {
        assertNotNull(students);
    }

    @Test
    public void test_getById() {
        assertNotNull(sc.getById(7));
        assertNull(sc.getById(5));
    }

    @Test
    public void test_findByName() {
        assertNotNull(sc.findByName("Hau"));
        assertEquals(sc.findByName("hoa"),new ArrayList<>());
    }

    @Test
    public void test_findByClassName() {
        assertEquals(sc.findByClassName("15T2").size(),13);
        assertEquals(sc.findByClassName("gg"),new ArrayList<>());
    }

    @Test
    public void test_addStudent() {
        int default_length = students.size();
        sc.addStudent(Student.StudentBuilder.newInstance().setFirstName("Hau").setLastName("Bui").setClassName("112").build());
        assertEquals(students.size(), default_length + 1);
    }

    @Test
    public void test_deleteStudent() {

        int default_length = students.size();

        assertTrue(sc.deleteStudent(22));

        assertEquals(students.size(), default_length - 1);

        assertFalse(sc.deleteStudent(6));
    }


}
