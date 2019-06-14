package controllers.exercise03;

import com.google.gson.reflect.TypeToken;
import entities.exercise03.Student;
import utils.FileUtils;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private static File file;

    private static List<Student> students;

    private static int COUNT;

    private static Type type;


    public StudentController(String filePath) {

        students = new ArrayList<>();

        file = new File(filePath);

        loadFromFile();

    }

    public List<Student> getStudents() {
        loadFromFile();

        return students;
    }

    public void addStudent(Student student) {

        Student obj = Student.StudentBuilder.newInstance()
                .setId(COUNT++)
                .setFirstName(student.getFirstName())
                .setLastName(student.getLastName())
                .setBirthday(student.getBirthday())
                .setClassName(student.getClassName())
                .setAddress(student.getAddress())
                .build();

        students.add(obj);
        saveToFile();
    }

    public boolean deleteStudent(int id) {
        boolean result = students.removeIf(o -> o.getId() == id);
        saveToFile();
        return result;
    }

    private void saveToFile() {
        FileUtils.writeToJsonFile(file, students, type);
    }

    private void loadFromFile() {

        type = new TypeToken<List<Student>>() {
        }.getType();

        FileUtils.readJsonFile(file, students, type);

        COUNT = students.get(students.size() - 1).getId() + 1;

    }

    public Student getById(int id) {

        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public List<Student> findByName(String name) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }

        return result;
    }

    public List<Student> findByClassName(String className) {
        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if ( student.getClassName().equalsIgnoreCase(className)) {
                result.add(student);
            }
        }

        return result;
    }
}
