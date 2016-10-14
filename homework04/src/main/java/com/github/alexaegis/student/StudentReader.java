package com.github.alexaegis.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReader {

    private List<Student> students;

    public StudentReader(File file) throws FileNotFoundException {
        this.students = new ArrayList<>();
        Scanner scn = new Scanner(file);
        while(scn.hasNextLine()) {
            String line = scn.nextLine();
            if(line.charAt(6) == ' ' && Integer.valueOf(line.substring(7, 8)) != null) {
                Student student = new Student(line.substring(0,6)).addGrade(Integer.valueOf(line.substring(7, 8)));
                if(this.students.contains(student)) {
                    this.students.get(this.students.indexOf(student)).addGrade(Integer.valueOf(line.substring(7, 8)));
                } else {
                    this.students.add(student);
                }
            }
        }
        scn.close();
    }

    public List<Student> getStudents() {
        return this.students;
    }

}
