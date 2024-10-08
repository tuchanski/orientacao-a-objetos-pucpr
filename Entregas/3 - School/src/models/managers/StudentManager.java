package models.managers;

import models.school.School;
import models.school.Student;
import models.school.Subject;
import models.enums.Gender;

import java.util.List;
import java.util.Scanner;

public class StudentManager {

    private final School school;
    private final Scanner input = new Scanner(System.in);

    public StudentManager(School school) {
        this.school = school;
    }

    public void enrollNewStudent(){
        try {
            System.out.print("\nEnter student name: ");
            String name = input.nextLine();
            System.out.print("\nEnter student gender (Male, Female or Other): ");
            String gender = input.nextLine();
            System.out.print("\nEnter student email: ");
            String email = input.nextLine();

            Student newStudent = new Student(name, Gender.valueOf(gender.toUpperCase()), email);

            System.out.println("\nAvailable subjects: " + school.getSubjectNames());
            System.out.print("\nChoose a subject to enroll: ");
            String subject = input.nextLine();

            school.addStudent(newStudent);
            school.enrollToSubject(subject.toUpperCase(), newStudent);

        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }

    }

    public Student getEnrolledStudentsBySubject(){

        System.out.println("\nAvailable subjects: " + school.getSubjectNames());
        System.out.print("\nChoose here: ");
        String subject = input.nextLine();

        for (Subject registered : school.getSubjects()){
            if (registered.getName().equalsIgnoreCase(subject)){
                System.out.println(registered.getStudents());
                return registered.getStudents().getFirst();
            }
        }

        System.out.println("\nError: Subject not found");
        return null;

    }

    public Student getEnrolledStudent(){

        List<Student> studentList = school.getStudents();

        System.out.println("\n[1] - Search by ID\n[2] - Search by name");
        System.out.print("\nChoose here: ");
        int choice = input.nextInt();

        while (choice != 1 && choice != 2) {
            System.out.print("Invalid choice. Choose here: ");
            choice = input.nextInt();
        }
        input.nextLine(); // Clean Buffer

        if (choice == 1) {
            System.out.print("\nEnter the ID: ");
            int id = input.nextInt();
            return getEnrolledStudentById(id, studentList);
        } else {
            System.out.print("\nEnter the name: ");
            String name = input.nextLine();
            return getEnrolledStudentByName(name, studentList);
        }
    }

    private Student getEnrolledStudentById(int id, List<Student> studentList) {
        for (Student student : studentList) {
            if (student.getId() == id) {
                System.out.println("\n" + student);
                return student;
            }
        }
        System.out.println("\nError: Student not found");
        return null;
    }

    private Student getEnrolledStudentByName(String name, List<Student> studentList) {
        for (Student student : studentList) {
            if (student.getName().equalsIgnoreCase(name)) {
                System.out.println("\n" + student);
                return student;
            }
        }
        System.out.println("\nError: Student not found");
        return null;
    }

    public void updateEnrolledStudent(){

        List<Student> studentList = school.getStudents();
        Student student = getEnrolledStudent();

        if (student != null) {

            int choice;
            do {
                System.out.println("\n- Update Mode -");
                System.out.println("""
                    [1] - Name
                    [2] - Gender
                    [3] - Email
                    [0] - Exit Update Mode""");
                System.out.print("\nChoose here: ");
                choice = input.nextInt();
                input.nextLine(); // Clean buffer

                switch (choice) {
                    case 1:
                        System.out.print("\nEnter new name: ");
                        String name = input.nextLine();
                        student.setName(name);
                        System.out.println("Student name has been updated: " + student.getName());
                        break;
                    case 2:
                        System.out.print("\nEnter new gender: ");
                        Gender gender = Gender.valueOf(input.nextLine().toUpperCase());
                        student.setGender(gender);
                        System.out.println("Student gender has been updated: " + student.getGender());
                        break;
                    case 3:
                        System.out.print("\nEnter new email: ");
                        String email = input.nextLine();
                        for (Student enrolled : studentList) {
                            if (enrolled.getEmail().equalsIgnoreCase(email)) {
                                System.out.println("E-mail already registered");
                                break;
                            }
                        }
                        student.setEmail(email);
                        System.out.println("Student email has been updated: " + student.getEmail());
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } while (choice != 0);

        }

    }
}
