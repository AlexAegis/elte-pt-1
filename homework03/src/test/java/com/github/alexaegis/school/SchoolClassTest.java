package com.github.alexaegis.school;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SchoolClassTest {

    private SchoolClass schoolClass;

    private final String CLASSNAME = "TestClass";

    @Before
    public void before() throws Exception {
        this.schoolClass = new SchoolClass().setName(CLASSNAME);
    }

    @After
    public void after() throws Exception {
        this.schoolClass = null;
    }

    @Test
    public void nameTest() throws Exception {
        assertEquals(this.schoolClass.getName(), CLASSNAME);
    }

    @Test
    public void getAverageTest() throws Exception {
        Student testStudent = new Student("TestStudent")
                .addSubject("TestSubject", 5)
                .addSubject("TestSubject2", 3);
        Student testStudent2 = new Student("TestStudent")
                .addSubject("TestSubject", 1)
                .addSubject("TestSubject2", 3);
        this.schoolClass.addStudent(testStudent)
                .addStudent(testStudent2);
        assertEquals(this.schoolClass.getAverage(), 3d, 0d);
    }

    @Test
    public void getAveragesTest() throws Exception {
        Student testStudent = new Student("TestStudent")
                .addSubject("TestSubject", 5)
                .addSubject("TestSubject2", 3);
        Student testStudent2 = new Student("TestStudent")
                .addSubject("TestSubject", 1)
                .addSubject("TestSubject2", 3);
        this.schoolClass.addStudent(testStudent)
                .addStudent(testStudent2);
        assertEquals(this.schoolClass.getAverages(), Arrays.asList(4d, 2d));
    }
}