package application;

import models.*;
import models.enums.Gender;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        School school = new School();

        StudentManager studentManager = new StudentManager(school);
        SubjectManager subjectManager = new SubjectManager(school);

        initializeSchool(school);

        int choice;
        do {
            displayMenu();
            System.out.print("\nChoose here: ");
            choice = input.nextInt();
            input.nextLine(); // Clear buffer

            switch (choice){
                case 1:
                    System.out.println("\n- Enroll New Student -");
                    studentManager.enrollNewStudent();
                    break;
                case 2:
                    System.out.println("\n- Get All Subjects -");
                    subjectManager.getAllSubjects();
                    break;
                case 3:
                    System.out.println("\n- Get Enrolled Students by Subject -");
                    studentManager.getEnrolledStudentsBySubject();
                    break;
                case 4:
                    System.out.println("\n- Get Subject -");
                    subjectManager.getSubject();
                    break;
                case 5:
                    System.out.println("\n- Get Enrolled Student -");
                    studentManager.getEnrolledStudentByIdOrName();
                    break;
                case 6:
                    System.out.println("\n- Update Student Info -");
                    studentManager.updateEnrolledStudent();
                default:
                    System.out.println("\nInvalid choice");
            }

        } while (choice != 0);

    }

    private static final Scanner input = new Scanner(System.in);

    private static void displayMenu() {
        System.out.println(
                """
                        \n- School System -\n
                        [1] - Enroll Student
                        [2] - Get all Subjects
                        [3] - Get enrolled students by Subject
                        [4] - Get subject
                        [5] - Get Enrolled Student
                        [6] - Change student info
                        [0] - Exit""");
    }

    private static void initializeSchool(School school) {
        Student student1 = new Student("Guilherme Tuchanski", Gender.MALE, "gui@pucpr.edu.br");
        Student student2 = new Student("João Afonso", Gender.MALE, "joao@pucpr.edu.br");
        Teacher teacher1 = new Teacher("Marina de Lara", Gender.FEMALE, "marina@pucpr.edu.br");
        Teacher teacher2 = new Teacher("Arion Mendes", Gender.MALE, "arion@pucpr.edu.br");
        Subject subject1 = new Subject("Programação Orientada a Objetos", teacher1);
        Subject subject2 = new Subject("Arquitetura de Banco de Dados", teacher2);

        school.addStudents(student1, student2);
        school.addTeachers(teacher1, teacher2);
        school.addSubjects(subject1, subject2);

        subject1.addStudent(student1);
        subject2.addStudent(student2);
    }

}
