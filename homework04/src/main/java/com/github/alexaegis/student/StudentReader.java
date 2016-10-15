package com.github.alexaegis.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReader {

    private List<Student> students = new ArrayList<>();

    public StudentReader(File file) throws FileNotFoundException {
        try(Scanner scn = new Scanner(file)) {
            while(scn.hasNextLine()) {
                String line = scn.nextLine();
                Integer grade = Integer.valueOf(line.substring(7, 8));
                if(line.charAt(6) == ' ' && grade != null) {
                    Student student = new Student(line.substring(0,6), grade);
                    if(students.contains(student)) {
                        students.get(students.indexOf(student)).addGrade(grade);
                    } else {
                        students.add(student);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public List<Student> getStudents() {
        return students;
    }

}