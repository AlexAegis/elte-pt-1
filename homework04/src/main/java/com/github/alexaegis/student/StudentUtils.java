package com.github.alexaegis.student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StudentUtils {

    public static boolean isID(String s) {
        return s.length() == 6 && s.equals(s.toUpperCase());
    }

    public static boolean isGrade(int g) {
        return g <= 5 && g >= 1;
    }

    public static boolean isAllAboveAverage(double a, Student... students) {
        return isAllAboveAverage(a, Arrays.asList(students));
    }

    public static boolean isAllAboveAverage(double a, List<Student> students) {
        return students.stream().allMatch(s -> s.getAverage() >= a);
    }

    public static List<Student> orderByAverages(List<Student> students) {
        return students.stream().sorted((a, b) -> {
            if(a.getAverage() < b.getAverage()) return 1;
            else if(a.getAverage() > b.getAverage()) return  -1;
            else return 0;
        }).collect(Collectors.toList());
    }

    public static void showBestNOf(int n, List<Student> students) {
        orderByAverages(students).subList(0,n).forEach(Student::show);
    }

}