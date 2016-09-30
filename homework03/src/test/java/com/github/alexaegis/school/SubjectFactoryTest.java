package com.github.alexaegis.school;

import com.github.alexaegis.exceptions.IllegalGradeException;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SubjectFactoryTest {

    private Subject testSubject = null;
    private final String NAME_DEFAULT = "Subject";
    private final int GRADE_FOUR = 4;

    @After
    public void after() {
        this.testSubject = null;
    }

    @Test
    public void legalSubjectTest() throws Exception {
        this.testSubject = SubjectFactory.getFactory().createSubject(NAME_DEFAULT, GRADE_FOUR);
        assertNotNull(this.testSubject);
    }

    @Test(expected = IllegalGradeException.class)
    public void illegalSubjectTest() throws Exception {
        this.testSubject = SubjectFactory.getFactory().createSubject(NAME_DEFAULT, 0);
    }
}