package org.example.system;

import org.example.people.Teacher;
import org.example.subject.Course;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SchoolSystem {
    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Cadastro de Curso ---");

        Course course = new Course();

        while (true) {
            try {
                System.out.print("Nome do curso: ");
                String courseName = scanner.nextLine();
                course.setName(courseName);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("Nome inválido");
            }
        }

        while (true) {
            try {
                System.out.print("Nome do professor: ");
                String teacherName = scanner.nextLine();
                Teacher teacher = new Teacher(teacherName);
                course.setTeacher(teacher);
                break;
            } catch (IllegalArgumentException exception) {
                System.out.println("Nome do professor inválido");
            }
        }

        int numberOfStudents;
        while (true) {
            try {
                System.out.print("N° de alunos: ");
                numberOfStudents = scanner.nextInt();
                break;
            } catch (InputMismatchException exception) {
                System.out.println("Digite o número de alunos");
            } finally {
                scanner.nextLine();
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            while (true) {
                try {
                    System.out.printf("%d° aluno: ", i + 1);
                    course.addStudent(scanner.nextLine());
                    break;
                } catch (IllegalArgumentException exception) {
                    System.out.println("Nome do aluno inválido");
                }
            }
        }

        System.out.println("\n--- Dados do Curso ---");

        System.out.println(course.getDetails());
    }
}
