package org.example;

import org.example.people.Student;
import org.example.people.Teacher;
import org.example.subject.Course;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseTest {
    @Test
    @DisplayName("Deve criar um curso")
    public void createCourseTest() {
        var courseName = "Test Course";
        var teacherName = "Test Teacher";
        var studentName01 = "Test Student 01";
        var studentName02 = "Test Student 02";
        var studentName03 = "Test Student 03";

        Course course = new Course();
        course.setName(courseName);
        Teacher teacher = new Teacher(teacherName);
        course.setTeacher(teacher);

        course.addStudent(studentName01);
        course.addStudent(studentName02);
        course.addStudent(studentName03);

        var details = "Nome: " + courseName + "\n" +
                "Professor: " + teacherName + "\n" +
                "Alunos:\n" +
                " - " + studentName01 + "\n" +
                " - " + studentName02 + "\n" +
                " - " + studentName03 + "\n";

        assertEquals(course.getDetails(), details);
    }

    @Test
    @DisplayName("Deve lançar exceção ao setar nome inválido para um curso")
    public void throwsExceptionOnInvalidCourseName() {
        Course course = new Course();
        assertThrows(IllegalArgumentException.class, () -> course.setName("a"));
    }

    @Test
    @DisplayName("Deve lançar exceção ao setar nome inválido para um professor")
    public void throwsExceptionOnInvalidTeacherName() {
        assertThrows(IllegalArgumentException.class, () -> new Teacher("a"));
    }

    @Test
    @DisplayName("Deve lançar exceção ao setar nome inválido para um aluno")
    public void throwsExceptionOnInvalidStudentName() {
        assertThrows(IllegalArgumentException.class, () -> new Student("a"));
    }
}
