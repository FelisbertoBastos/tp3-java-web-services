package org.example.system;

import org.example.people.Teacher;
import org.example.subject.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SchoolSystem {
    private final Logger LOGGER = LoggerFactory.getLogger(SchoolSystem.class);

    public void run() {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Iniciando o cadastro");

        System.out.println("--- Cadastro de Curso ---");

        Course course = new Course();

        while (true) {
            try {
                System.out.print("Nome do curso: ");
                String courseName = scanner.nextLine();
                course.setName(courseName);
                LOGGER.debug("Usuário digitou o nome do curso: " + courseName);
                break;
            } catch (IllegalArgumentException exception) {
                LOGGER.error("Usuário digitou nome do curso inválido");
                System.out.println("Nome inválido");
            }
        }

        while (true) {
            try {
                System.out.print("Nome do professor: ");
                String teacherName = scanner.nextLine();
                Teacher teacher = new Teacher(teacherName);
                course.setTeacher(teacher);
                LOGGER.debug("Usuário digitou o nome do professor: " + teacherName);
                break;
            } catch (IllegalArgumentException exception) {
                LOGGER.error("Usuário digitou nome do professor inválido");
                System.out.println("Nome do professor inválido");
            }
        }

        int numberOfStudents;
        while (true) {
            try {
                System.out.print("N° de alunos: ");
                numberOfStudents = scanner.nextInt();
                LOGGER.debug("Usuário digitou o número de alunos: " + numberOfStudents);
                break;
            } catch (InputMismatchException exception) {
                LOGGER.error("Usuário digitou número de alunos inválido");
                System.out.println("Digite o número de alunos");
            } finally {
                scanner.nextLine();
            }
        }

        for (int i = 0; i < numberOfStudents; i++) {
            while (true) {
                try {
                    System.out.printf("%d° aluno: ", i + 1);
                    String studentName = scanner.nextLine();
                    course.addStudent(studentName);
                    LOGGER.debug("Usuário digitou o nome do aluno: " + studentName);
                    break;
                } catch (IllegalArgumentException exception) {
                    LOGGER.error("Usuário digitou nome de aluno inválido");
                    System.out.println("Nome do aluno inválido");
                }
            }
        }

        System.out.println("\n--- Dados do Curso ---");

        System.out.println(course.getDetails());

        LOGGER.info("Finalizando o cadastro");
    }
}
