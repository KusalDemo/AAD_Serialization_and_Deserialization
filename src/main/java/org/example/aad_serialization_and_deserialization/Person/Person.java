package org.example.aad_serialization_and_deserialization.Person;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String program;
    private int age;

    public Person() {
    }

    public Person(String name, String program, int age) {
        this.name = name;
        this.program = program;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", program='" + program + '\'' +
                ", age=" + age +
                '}';
    }
}
