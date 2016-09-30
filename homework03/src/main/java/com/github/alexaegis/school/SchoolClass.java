package com.github.alexaegis.school;

import com.github.alexaegis.exceptions.NoSubjectsException;

import java.util.ArrayList;
import java.util.List;

public class SchoolClass {

    private List<Student> students;
    private String name;

    public SchoolClass() {
        this.students = new ArrayList<>();
    }

    public SchoolClass addStudent(Student student) {
        this.students.add(student);
        return this;
    }

    public String getName() {
        return name;
    }

    public SchoolClass setName(String name) {
        this.name = name;
        return this;
    }

    public double getAverage() {
        final int[] sumOfGrades = {0};
        final int[] sumOfSubjects = {0};
        this.students.stream().filter(o -> o != null).forEach(o -> {
            sumOfGrades[0] += o.getSumOfAllGrades();
            sumOfSubjects[0] += o.getSubjects().size();
        });
        return (double) sumOfGrades[0] / (double) sumOfSubjects[0];
    }

    public List<Double> getAverages() {
        List<Double> result = new ArrayList<>();
        this.students.stream().filter(o -> o != null).forEach(o -> {
            try {
                result.add(o.getAverage());
            } catch (NoSubjectsException e) {
                result.add(0d);
            }
        });
        return result;
    }
}