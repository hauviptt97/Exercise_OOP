package exerciseo03Test;

import com.google.gson.reflect.TypeToken;
import controllers.exercise03.StudentController;
import entities.exercise03.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

public class StudentControllerTest {

    @Before
    public void setup() {
        // Xoa student.json if exist
        // Copy students-origin to student.json

        File file_temp = new File("students.json");
        File file_origin = new File("students-origin.json");

        if (!file_origin.exists()) {
            try {
                file_origin.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Student> students = new ArrayList<>();

        FileUtils.readJsonFile(file_temp, students, new TypeToken<List<Student>>() {
        }.getType());

        FileUtils.writeToJsonFile(file_origin, students, new TypeToken<List<Student>>() {
        }.getType());
    }

    @After
    public void finalize() {
        //Xoa students.json
        File file_temp = new File("students.json");
        file_temp.delete();
    }

    @Test
    public void test_getStudents() {
        List<Student> students = new StudentController("student.json").getStudents();

        assertNotNull(students);
    }

    @Test
    public void test_getById() {
        assertNotNull(new StudentController("student.json").getById(3));
        assertNull(new StudentController("student.json").getById(5));
    }

    @Test
    public void test_findByName() {
        assertNotNull(new StudentController("student.json").findByName("Hau"));
        assertEquals(new StudentController("student.json").findByName("hoa"), new ArrayList<>());
    }

    @Test
    public void test_findByClassName() {
        assertEquals(new StudentController("student.json").findByClassName("15T2").size(), 13);
        assertEquals(new StudentController("student.json").findByClassName("gg"), new ArrayList<>());
    }

    @Test
    public void test_addStudent() {
        StudentController sc = new StudentController("student.json");

        int default_length = sc.getStudents().size();

        sc.addStudent(Student.StudentBuilder.newInstance().setFirstName("Hau").setLastName("Bui").setClassName("112").build());

        assertEquals(sc.getStudents().size(), default_length + 1);
    }

    @Test
    public void test_deleteStudent() {
        StudentController sc = new StudentController("student.json");

        int default_length = sc.getStudents().size();

        assertTrue(sc.deleteStudent(37));

        assertEquals(sc.getStudents().size(), default_length - 1);

        assertFalse(sc.deleteStudent(6));
    }


}
