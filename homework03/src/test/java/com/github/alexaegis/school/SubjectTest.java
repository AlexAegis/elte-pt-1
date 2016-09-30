package com.github.alexaegis.school;

import com.github.alexaegis.exceptions.IllegalGradeException;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class SubjectTest {

    private Subject testSubject = null;
    private final String NAME_DEFAULT = "Subject";
    private final int GRADE_FOUR = 4;

    @After
    public void after() {
        this.testSubject = null;
    }

    @Test
    public void legalSubjectTest() throws Exception {
        this.testSubject = new Subject(NAME_DEFAULT, GRADE_FOUR);
        assertTrue(this.testSubject.getName().equals(NAME_DEFAULT));
        assertTrue(this.testSubject.getGrade() == GRADE_FOUR);
    }

    @Test(expected = IllegalGradeException.class)
    public void illegalGradeTest() throws Exception {
        this.testSubject = new Subject(NAME_DEFAULT, 6);
    }

    @Test(expected = IllegalGradeException.class)
    public void illegalGradeTest2() throws Exception {
        this.testSubject = new Subject(NAME_DEFAULT, 0);
    }

    @Test
    public void equalsPositiveTest() throws Exception {
        assertEquals(new Subject(NAME_DEFAULT, GRADE_FOUR), new Subject(NAME_DEFAULT, GRADE_FOUR));
    }

    @Test
    public void equalsNegativeTest() throws Exception {
        assertNotEquals(new Subject(NAME_DEFAULT, GRADE_FOUR), new Subject(NAME_DEFAULT, 2));
    }
}