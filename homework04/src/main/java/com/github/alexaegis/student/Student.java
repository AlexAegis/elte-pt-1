package com.github.alexaegis.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Student {

    private final String id;
    private List<Integer> grades;

    public Student(String id) {
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public double getAverage() {
        return this.grades.stream().mapToInt(Integer::intValue).average()
                .orElseThrow(IllegalArgumentException::new);
    }

    public String getId() {
        return id;
    }

    public Student addGrade(int g) {
        if(isGrade(g)) {
            this.grades.add(g);
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public Student addGrades(int... grades) {
        Arrays.stream(grades).forEach(this::addGrade);
        return this;
    }

    private boolean isGrade(int g) {
        return g <= 5 && g >= 1;
    }

    public void show() {
        System.out.println(this.toString());
    }

    public static boolean aboveAverageStudents(double a, Student... students) {
        return aboveAverageStudents(a, Arrays.asList(students));
    }

    public static boolean aboveAverageStudents(double a, List<Student> students) {
        return students.stream().allMatch(s -> s.getAverage() >= a);
    }

    public static List<Student> orderStudents(List<Student> students) {
        return students.stream().sorted((a, b) -> {
            if(a.getAverage() < b.getAverage()) return 1;
            else if(a.getAverage() > b.getAverage()) return  -1;
            else return 0;
        }).collect(Collectors.toList());
    }

    public static void showBestNOf(int n, List<Student> students) {
        Student.orderStudents(students).subList(0,n).forEach(Student::show);
    }

    @Override
    public String toString() {
        return this.getId() + ", " + this.getAverage();
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