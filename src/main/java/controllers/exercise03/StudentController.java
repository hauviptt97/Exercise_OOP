package controllers.exercise03;

import entities.exercise03.Student;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private static File file;

    private List<Student> students = new ArrayList<>();

    private static int count;

    public StudentController(String filePath) {

        file = new File(filePath);

        loadFromFile();

    }

    public List<Student> getStudents() {

        loadFromFile();

        return students;
    }

    public void addStudent(Student student) {

        Student obj = Student.StudentBuilder.newInstance()
                .setId(count++)
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
        try {
            FileUtils.writeToJsonFile(file, students);
        } catch (IOException ignored) {
        }
    }

    private void loadFromFile() {

        try {
            students = FileUtils.readJsonFile(file, Student[].class);
        } catch (IOException ignored) {
        }

        count = students.get(students.size() - 1).getId() + 1;

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
            if (student.getClassName().equalsIgnoreCase(className)) {
                result.add(student);
            }
        }

        return result;
    }
}
