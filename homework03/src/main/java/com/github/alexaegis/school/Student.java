package com.github.alexaegis.school;

import com.github.alexaegis.exceptions.IllegalGradeException;
import com.github.alexaegis.exceptions.NoSubjectsException;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Subject> subjects;

    public Student() {
        this.subjects = new ArrayList<>();
    }

    Student(String name) {
        this();
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public Student addSubject(String name, int grade) throws IllegalGradeException {
        this.addSubject(new Subject(name, grade));
        return this;
    }

    public Student addSubject(Subject subject) {
        this.subjects.add(subject);
        return this;
    }

    public double getAverage() throws NoSubjectsException {
        if(this.getSubjects().isEmpty()) {
            throw new NoSubjectsException();
        } else {
            return (double) this.getSumOfAllGrades() / (double) this.getSubjects().size();
        }
    }

    public List<Integer> getAllGrades() {
        List<Integer> result = new ArrayList<>();
        this.getSubjects().stream().filter(o -> o != null).forEach(o -> result.add(o.getGrade()));
        return result;
    }

    public int getSumOfAllGrades() {
        final int[] result = {0};
        this.getAllGrades().stream().filter(o -> o != null).forEach(o -> result[0] += o);
        return result[0];
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null && (subjects != null ? subjects.equals(student.subjects) : student.subjects == null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (subjects != null ? subjects.hashCode() : 0);
        return result;
    }

}