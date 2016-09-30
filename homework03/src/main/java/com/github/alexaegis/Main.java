package com.github.alexaegis;

import com.github.alexaegis.school.SchoolClass;
import com.github.alexaegis.school.Student;

import java.util.Arrays;

public class Main {

    /**
     * Main method given by the teacher
     */
    public static void main(String[] args) throws Exception {
        SchoolClass clss = new SchoolClass();
        clss.setName("béla osztály");
        if(!"béla osztály".equals(clss.getName())) {
            result(false);
        }

        Student st = new Student();
        st.setName("Béla");
        st.addSubject("sör", 5); st.addSubject("leves", 4); st.addSubject("asd", 5); st.addSubject("subject", 2);
        if(!"Béla".equals(st.getName()) || st.getAverage() != 4.0) {
            result(false);
        }
        clss.addStudent(st);

        st = new Student();
        st.setName("Jolán");
        st.addSubject("Math", 4); st.addSubject("History", 3); st.addSubject("leves", 2); st.addSubject("sör", 5);
        if(!"Jolán".equals(st.getName()) || st.getAverage() != 3.5) {
            result(false);
        }
        clss.addStudent(st);

        st = new Student();
        st.setName("Béla 2");
        st.addSubject("Math", 5); st.addSubject("sör", 5); st.addSubject("leves", 5); st.addSubject("sss", 5);
        if(!"Béla 2".equals(st.getName()) || st.getAverage() != 5.0) {
            result(false);
        }
        clss.addStudent(st);

        if (clss.getAverages().equals(Arrays.asList(4.0, 3.5, 5.0))) {
            result(true);
        } else {
            result(false);
        }
    }

    private static void result(boolean p) {
        if(p) {
            System.out.println("Plusz");
        } else {
            System.err.println("Minusz");
        }
    }
}