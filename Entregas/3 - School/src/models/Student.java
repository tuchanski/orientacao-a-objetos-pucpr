package models;


import models.enums.Gender;

import java.time.LocalDate;
import java.util.Objects;

public class Student {

    private static Long nextId = 0L;

    private final Long id;
    private String name;
    private Gender gender;
    private String email;

    public Student(String name, Gender gender, String email) {
        nextId = nextId + 1;
        this.id = nextId;
        this.name = name.toUpperCase();
        this.gender = gender;
        this.email = email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
