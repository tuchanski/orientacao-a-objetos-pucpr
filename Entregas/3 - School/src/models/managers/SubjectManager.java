package models.managers;

import models.school.School;
import models.school.Subject;

import java.util.List;
import java.util.Scanner;

public class SubjectManager {
    private final School school;
    private final Scanner input = new Scanner(System.in);

    public SubjectManager(School school) {
        this.school = school;
    }

    public void getAllSubjects() {
        System.out.println(this.school.getSubjects());
    }

    public Subject getSubject(){

        List<Subject> subjectList = school.getSubjects();
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
            return getSubjectById(id, subjectList);
        } else {
            System.out.print("\nEnter the name: ");
            String name = input.nextLine();
            return getSubjectByName(name, subjectList);
        }

    }

    private Subject getSubjectById(int id, List<Subject> subjectList) {
        for (Subject subject : subjectList) {
            if (subject.getId() == id) {
                System.out.println("\n" + subject);
                return subject;
            }
        }
        System.out.println("\nSubject not found");
        return null;
    }

    private Subject getSubjectByName(String name, List<Subject> subjectList) {
        for (Subject subject : subjectList) {
            if (subject.getName().equalsIgnoreCase(name)) {
                System.out.println("\n" + subject);
                return subject;
            }
        }
        System.out.println("\nSubject not found");
        return null;
    }

}