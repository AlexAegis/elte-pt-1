package com.github.alexaegis.school;

public class StudentBuilder {

    private Student student;

    public StudentBuilder() {
        this.setStudent(new Student());
    }

    public Student getStudent() {
        return student;
    }

    private StudentBuilder setStudent(Student student) {
        this.student = student;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.getStudent().setName(name);
        return this;
    }

    public StudentBuilder addSubject(Subject subject) {
        this.getStudent().addSubject(subject);
        return this;
    }
}