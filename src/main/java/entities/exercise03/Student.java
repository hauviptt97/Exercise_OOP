package entities.exercise03;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

@JsonDeserialize(builder = Student.StudentBuilder.class)
public final class Student {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final Date birthday;
    private final String className;
    private final String address;

    private Student(StudentBuilder studentBuilder) {
        this.id = studentBuilder.id;
        this.firstName = studentBuilder.firstName;
        this.lastName = studentBuilder.lastName;
        this.birthday = studentBuilder.birthday;
        this.className = studentBuilder.className;
        this.address = studentBuilder.address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getClassName() {
        return className;
    }

    public String getAddress() {
        return address;
    }

    public static class StudentBuilder {
        private int id;
        private String firstName;
        private String lastName;
        private Date birthday;
        private String className;
        private String address;

        public static StudentBuilder newInstance() {
            return new StudentBuilder();
        }

        private StudentBuilder() {
        }

        public StudentBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public StudentBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public StudentBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public StudentBuilder setBirthday(Date birthday) {
            this.birthday = birthday;
            return this;
        }

        public StudentBuilder setClassName(String className) {
            this.className = className;
            return this;
        }

        public StudentBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}

