package com.github.alexaegis;

import com.github.alexaegis.student.Student;
import com.github.alexaegis.student.StudentReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Student student1 = new Student("VIKTOR").addGrades(1,2,1,2,3,2);
        Student student2 = new Student("LORNCZ").addGrades(2,2,1,2,3,2,1);
        Student student3 = new Student("HLKPTR").addGrades(1,2,1,1,1,1,3);
        Student student4 = new Student("LAZAR1").addGrades(2,3,4,1,2,1);
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        System.out.println("Igaz e, hogy minden tanulónak az átlaga legalább négyes? "
                + Student.aboveAverageStudents(4, student1,student2,student3,student4));
        System.out.println("A legjobb 3 átlaggal rendelkező: ");
        Student.showBestNOf(3, students);

        List<Student> studentsFromFile = new StudentReader(new File("src\\main\\resources\\positiveinput.txt")).getStudents();
        System.out.println("Igaz e, hogy minden tanulónak az átlaga legalább négyes? "
                + Student.aboveAverageStudents(4, studentsFromFile));
        System.out.println("A legjobb 3 átlaggal rendelkező: ");
        Student.showBestNOf(3, studentsFromFile);
    }
}