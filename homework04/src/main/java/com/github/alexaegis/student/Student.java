package com.github.alexaegis.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Student {

    private final String id;
    private final List<Integer> grades = new ArrayList<>();

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, int... grades) {
        this.id = id;
        addGrades(grades);
    }

    public double getAverage() {
        return grades.stream().mapToInt(Integer::intValue).average()
                .orElseThrow(() -> new IllegalArgumentException("Possible illegal divisor -> empty list"));
    }

    public String getId() {
        return id;
    }

    public void addGrade(int g) {
        if(StudentUtils.isGrade(g)) {
            grades.add(g);
        } else throw new IllegalArgumentException("Not a valid grade: " + g + " not in [1..5]");
    }

    public void addGrades(int... grades) {
        Arrays.stream(grades).forEach(this::addGrade);
    }

    public void show() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return getId() + ", " + getAverage();
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

        return id != null ? id.equals(student.id) : student.id == null
                && (grades != null ? grades.equals(student.grades) : student.grades == null);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        return 31 * result + (grades != null ? grades.hashCode() : 0);
    }
}