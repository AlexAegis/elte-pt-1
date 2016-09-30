package com.github.alexaegis.school;

import com.github.alexaegis.exceptions.IllegalGradeException;

public class Subject {

    private String name;
    private int grade;

    Subject() {

    }

    Subject(String name, int grade) throws IllegalGradeException {
        this.setName(name);
        this.setGrade(grade);
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    void setGrade(int grade) throws IllegalGradeException {
        if(grade <=5 && grade >= 1) {
            this.grade = grade;
        } else {
            throw new IllegalGradeException();
        }
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Subject subject = (Subject) o;

        return grade == subject.grade && (name != null ? name.equals(subject.name) : subject.name == null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + grade;
        return result;
    }
}