package com.github.alexaegis.school;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StudentTest {

    private Student testStudent;
    private Subject testSubject1;
    private Subject testSubject2;

    private final String TESTSTUDENTNAME = "TestStudent";
    private final int SUBJECT1GRADE = 5;
    private final int SUBJECT2GRADE = 3;
    private final double SUBJECT12AVERAGE = 4d;

    @Before
    public void before() throws Exception {
        this.testSubject1 = SubjectFactory.getFactory().createSubject("Subject", SUBJECT1GRADE);
        this.testSubject2 = SubjectFactory.getFactory().createSubject("Subject", SUBJECT2GRADE);
        this.testStudent = new Student(TESTSTUDENTNAME)
                .addSubject(testSubject1)
                .addSubject(testSubject2);
    }

    @After
    public void after() {
        this.testStudent = null;
        this.testSubject1 = null;
        this.testSubject2 = null;
    }

    @Test
    public void legalStudentTest() {
        assertNotNull(this.testStudent.getName());
    }

    @Test
    public void studentEqualesTest() throws Exception {
        assertEquals(this.testStudent,
                new Student(TESTSTUDENTNAME)
                        .addSubject(testSubject1)
                        .addSubject(testSubject2));
    }

    @Test
    public void studentAverageTest() throws Exception {
        assertEquals(this.testStudent.getAverage(), SUBJECT12AVERAGE, 0d);
    }

    @Test
    public void studentGetAllGradesTest() throws Exception {
        assertEquals(this.testStudent.getAllGrades(),
                Arrays.asList(SUBJECT1GRADE, SUBJECT2GRADE));
    }

    @Test
    public void studentSumOfGradesTest() throws Exception {
        assertEquals(this.testStudent.getSumOfAllGrades(),
                SUBJECT1GRADE + SUBJECT2GRADE);
    }
}