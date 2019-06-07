package com;

import java.util.HashMap;

public class Student {
    public static void main(String[] args) {
        Student ffj = new Student(3, "ffj");
        ffj.name="haha";
        Student student=ffj;
        System.out.println(student);
        new HashMap<>();
        Student student1;
    }
    private int id;
    private String name;

    @Override
    public String toString() {

        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {

    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;

    }
}
