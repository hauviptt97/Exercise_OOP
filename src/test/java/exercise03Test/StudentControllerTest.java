package exercise03Test;

import controllers.exercise03.StudentController;
import entities.exercise03.Student;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

@SuppressWarnings("ALL")
public class StudentControllerTest {

    @BeforeClass
    public static void setup() {
        // Xoa student.json if exist
        // Copy students-origin to student.json

        File file_temp = new File("student-temp.json");
        File file_origin = new File("student-origin.json");

        if (!file_origin.exists()) {
            try {
                file_origin.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Student> students;

        try {
            students = FileUtils.readJsonFile(file_temp, Student[].class);
            FileUtils.writeToJsonFile(file_origin, students);
        } catch (IOException ignored) {
        }

    }

    @Test
    public void test_getStudents() {
        List<Student> students = new StudentController("student-temp.json").getStudents();
        assertNotNull(students);
    }

    @Test
    public void test_getById() {
        assertNotNull(new StudentController("student-temp.json").getById(3));
        assertNull(new StudentController("student-temp.json").getById(5));
    }

    @Test
    public void test_findByName() {
        assertNotNull(new StudentController("student-temp.json").findByName("Hau"));
        assertEquals(new StudentController("student-temp.json").findByName("hoa"), new ArrayList<>());
    }

    @Test
    public void test_findByClassName() {
        assertEquals(new StudentController("student-temp.json").findByClassName("15T2").size(), 13);
        assertEquals(new StudentController("student-temp.json").findByClassName("gg"), new ArrayList<>());
    }

    @Test
    public void test_addStudent() {
        StudentController sc = new StudentController("student-temp.json");

        int default_length = sc.getStudents().size();

        sc.addStudent(Student.StudentBuilder.newInstance().setFirstName("Hau").setLastName("Bui").setClassName("112").build());

        assertEquals(sc.getStudents().size(), default_length + 1);
    }

    @Test
    public void test_deleteStudent() {
        StudentController sc = new StudentController("student-temp.json");

        int default_length = sc.getStudents().size();

        assertTrue(sc.deleteStudent(38));

        assertEquals(sc.getStudents().size(), default_length - 1);

        assertFalse(sc.deleteStudent(6));
    }

    @AfterClass
    public static void finalized() {
        //Xoa students.json
        File file_temp = new File("student-temp.json");
        file_temp.delete();
    }

}
