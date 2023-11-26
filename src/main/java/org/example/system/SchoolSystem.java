package org.example.system;

import org.example.people.Student;
import org.example.people.Teacher;
import org.example.subject.Course;

import java.util.Scanner;

public class SchoolSystem {
    public void run() {
        System.out.println("--- Cadastro de Curso ---");

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do curso: ");
        String courseName = scanner.nextLine();

        System.out.print("Nome do professor: ");
        String teacherName = scanner.nextLine();

        Teacher teacher = new Teacher(teacherName);
        Course course = new Course(courseName, teacher);

        System.out.print("N° de alunos: ");
        int numberOfStudents = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.printf("%d° aluno: ", i + 1);
            Student student = new Student(scanner.nextLine());
            course.getStudents().add(student);
        }

        System.out.println("\n--- Dados do Curso ---");

        System.out.println("Nome: " + course.getName());
        System.out.println("Professor: " + course.getTeacher().getName());

        System.out.println("Alunos:");

        for (int i = 0; i < course.getStudents().size(); i++) {
            System.out.println(" - " + course.getStudents().get(i).getName());
        }
    }
}
