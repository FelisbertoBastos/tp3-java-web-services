package org.example.subject;

import lombok.Getter;
import org.example.people.Student;
import org.example.people.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {
    @Getter
    private String name;
    @Getter
    private Teacher teacher;
    @Getter
    private final List<Student> students;

    public Course() {
        this.students = new ArrayList<>();
    }

    public void setName(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addStudent(String studentName) {
        Student student = new Student(studentName);
        this.students.add(student);
    }

    public String getDetails() {
        StringBuilder details = new StringBuilder("Nome: " + this.name + "\n" +
                "Professor: " + this.teacher.getName() + "\n");

        details.append("Alunos:\n");

        for (Student student : students) {
            details
                    .append(" - ")
                    .append(student.getName())
                    .append("\n");
        }

        return details.toString();
    }
}
