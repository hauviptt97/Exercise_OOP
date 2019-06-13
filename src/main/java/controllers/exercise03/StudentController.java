package controllers.exercise03;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.exercise03.Student;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private static  File file;

    private List<Student> students = new ArrayList<>();

    private ObjectMapper mapper;


    public StudentController(String filePath) {

        file = new File(filePath);

        mapper = new ObjectMapper();

        loadFromFile(filePath);
    }

    public void addStudent(Student student) {
        students.add(student);
        saveToFile();
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(o -> (o.getId() == id));
    }

    private void saveToFile() {
        for (Student student : students) {
            try {
                mapper.writeValue(file, student);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void loadFromFile(String path) {

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            students = mapper.readValue(file, new TypeReference<List<Student>>(){});
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(students.toString());
    }

    public Student getById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student findByName(String name) {
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                return student;
            }
        }
        return null;
    }

    public Student findByClassName(String className) {
        for (Student student : students) {
            if (student.getClassName().equalsIgnoreCase(className)) {
                return student;
            }
        }
        return null;
    }
}
