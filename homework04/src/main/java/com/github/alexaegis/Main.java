package com.github.alexaegis;

import com.github.alexaegis.student.Student;
import com.github.alexaegis.student.StudentReader;
import com.github.alexaegis.student.StudentUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		List<Student> students = new ArrayList<>();
		students.add(new Student("VIKTOR",1,2,1,2,3,2));
		students.add(new Student("LORNCZ",2,2,1,2,3,2,1));
		students.add(new Student("HLKPTR",1,2,1,1,1,1,3));
		students.add(new Student("LAZAR1",2,3,4,1,2,1));
		System.out.println("Igaz e, hogy minden tanulónak az átlaga legalább négyes? "
				+ StudentUtils.isAllAboveAverage(4, students));
		System.out.println("A legjobb 3 átlaggal rendelkező: ");
		StudentUtils.showBestNOf(3, students);

		List<Student> studentsFromFile = new StudentReader(new File("src/main/resources/positiveinput.txt")).getStudents();
		System.out.println("Igaz e, hogy minden tanulónak az átlaga legalább négyes? "
				+ StudentUtils.isAllAboveAverage(4, studentsFromFile));
		System.out.println("A legjobb 3 átlaggal rendelkező: ");
		StudentUtils.showBestNOf(3, studentsFromFile);
	}
}