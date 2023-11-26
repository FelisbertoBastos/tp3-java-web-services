package org.example.subject;

import lombok.Getter;
import org.example.people.Student;
import org.example.people.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Course {
    @Getter
    private final String name;
    @Getter
    private final Teacher teacher;
    @Getter
    private final List<Student> students;

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
        this.students = new ArrayList<Student>();
    }
}
