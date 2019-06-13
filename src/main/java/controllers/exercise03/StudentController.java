package controllers.exercise03;

import entities.exercise03.Student;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentController {
    private static File file;

    private static List<Student> students;

    private static int COUNT;

    public StudentController(String filePath) {

        students = new ArrayList<>();

        file = new File(filePath);

        if (file.exists()) {
            loadFromFile();
            COUNT = students.size() + 1;
        }

    }

    public List<Student> getStudents() {
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
        for (int i = 0; i < students.size(); i++) {

            System.out.println(students.get(i).getId());

            if (students.get(i).getId() == id) {
                //students.remove(students.get(i));
                //saveToFile();
                return true;
            }
        }
        return false;
    }

    private void saveToFile() {
        FileUtils.writeToJsonFile(file, students);
    }

    private void loadFromFile() {
        FileUtils.readJsonFile(file, students, Student.class);
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
