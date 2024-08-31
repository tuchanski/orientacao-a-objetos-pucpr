package models.school;


import models.enums.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher {

    private static Long nextId = 0L;

    private final Long id;
    private String name;
    private Gender gender;
    private String email;

    private List<Subject> subjects;

    public Teacher(String name, Gender gender, String email) {
        nextId = nextId + 1;
        this.id = nextId;
        this.name = name.toUpperCase();
        this.gender = gender;
        this.email = email;
        this.subjects = new ArrayList<>();
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public boolean removeSubject(Subject subject) {
        for (Subject s : subjects) {
            if (s.getId().equals(subject.getId())) {
                subjects.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean addSubject(Subject subject) {
        for (Subject s : subjects) {
            if (s.getId().equals(subject.getId())) {
                return false;
            }
        }
        subjects.add(subject);
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
