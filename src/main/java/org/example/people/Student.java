package org.example.people;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Student extends People {
    @Getter
    private final List<Float> grades;

    public Student(String name) {
        super(name);

        this.grades = new ArrayList<Float>();
    }
}
