package com.github.alexaegis.student;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentReader {

    private List<Student> students;

    public StudentReader(File file) throws FileNotFoundException {
        try(Scanner scn = new Scanner(file)) {
            students = read(scn);
        }
    }

    public StudentReader(Scanner scn) {
        students = read(scn);
    }

    private List<Student> read(Scanner scn) {
        List<Student> result = new ArrayList<>();
        while(scn.hasNextLine()) {
            String line = scn.nextLine();
            Integer grade = Integer.valueOf(line.substring(7, 8));
            if(line.charAt(6) == ' ' && grade != null) {
                Student student = new Student(line.substring(0,6), grade);
                if(result.contains(student)) {
                    result.get(result.indexOf(student)).addGrade(grade);
                } else {
                    result.add(student);
                }
            }
        }
        return result;
    }

    public List<Student> getStudents() {
        return students;
    }

}