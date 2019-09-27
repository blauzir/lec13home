package com.example.lec13home.models;

public class Student {
    String name;
    String email;
    int id;

    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Student(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
