package models.school;

import java.util.ArrayList;
import java.util.List;

public class School {

    private List<Student> students;
    private List<Subject> subjects;
    private List<Teacher> teachers;

    public School(){
        students = new ArrayList<>();
        subjects = new ArrayList<>();
        teachers = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public List<String> getSubjectNames(){
        List<String> names = new ArrayList<>();
        for(Subject s : subjects){
            names.add(s.getName());
        }
        return names;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void addStudent(Student student){
        for (Student enrolled : this.students){
            if (enrolled.getId().equals(student.getId())){
                throw new IllegalArgumentException("Student already registered");
            }
            if (enrolled.getEmail().equals(student.getEmail())){
                throw new IllegalArgumentException("E-mail already registered");
            }
        }
        this.students.add(student);
        System.out.println("\nStudent " + student.getName() + " enrolled to school.");
    }

    public void enrollToSubject(String subject, Student student){
        boolean found = false;
        for (Subject desired : this.subjects){
            if (desired.getName().equals(subject)){
                List<Student> enrolledStudents = desired.getStudents();
                if (enrolledStudents.contains(student)){
                    throw new IllegalArgumentException("Student already enrolled");
                }
                System.out.println("\nStudent " + student.getName() + " enrolled to subject " + desired.getName() + ".");
                enrolledStudents.add(student);
                found = true;
            }
        }
        if (!found){
            throw new IllegalArgumentException("Subject not found");
        }
    }

    public boolean addSubject(Subject subject){
        if (subjects.contains(subject)){
            return false;
        }
        subjects.add(subject);
        return true;
    }

    public boolean addTeacher(Teacher teacher){
        if (teachers.contains(teacher)){
            return false;
        }
        teachers.add(teacher);
        return true;
    }

    public boolean addStudents(Student... students){
        for (Student student : students){
            if (!this.students.contains(student)){
                this.students.add(student);
            }
        }
        return true;
    }

    public boolean addSubjects(Subject... subjects){
        for (Subject subject : subjects){
            if (!this.subjects.contains(subject)){
                this.subjects.add(subject);
            }
        }
        return true;
    }

    public boolean addTeachers(Teacher... teachers){
        for (Teacher teacher : teachers){
            if (!this.teachers.contains(teacher)){
                this.teachers.add(teacher);
            }
        }
        return true;
    }

}
