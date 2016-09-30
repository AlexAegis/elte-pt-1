package com.github.alexaegis.school;

import com.github.alexaegis.exceptions.IllegalGradeException;

public class SubjectFactory {

    private static SubjectFactory instance;

    private SubjectFactory() {

    }

    public static SubjectFactory getFactory() {

        if (instance == null) {

            synchronized(SubjectFactory.class) {

                if (instance == null) {
                    instance = new SubjectFactory();
                }
            }
        }
        return instance;
    }

    public Subject createSubject(String name, int grade) throws IllegalGradeException {
        return new Subject(name, grade);
    }
}