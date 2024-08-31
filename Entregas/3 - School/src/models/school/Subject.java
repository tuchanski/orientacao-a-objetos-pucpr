package models.school;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private static Long idCounter = 0L;

    private Long id;
    private String name;
    private Teacher teacher;
    private List<Student> students;

    public Subject(String name, Teacher teacher) {
        idCounter = idCounter + 1;
        this.id = idCounter;
        this.name = name.toUpperCase();
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {
        for (Student s : students) {
            if (s.getId().equals(student.getId())) {
                return false;
            }
        }
        students.add(student);
        return true;
    }

    public boolean addStudents(Student... student) {
        for (Student s : student) {
            if (!students.contains(s)) {
                students.add(s);
            }
        }
        return true;
    }

    public boolean removeStudent(Student student) {
        for (Student s : students) {
            if (s.getId().equals(student.getId())) {
                students.remove(s);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teacher=" + teacher.getName() +
                '}';
    }
}
