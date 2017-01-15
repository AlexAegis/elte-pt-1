package exam;

import exam.config.Utilities;
import exam.logic.iterators.ContinuousMatrixRowIterator;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> row1 = new ArrayList<>();
        row1.add("0");
        row1.add("1");
        row1.add("2");
        row1.add("3");

        row1.forEach(System.out::print);
        Utilities.reverse(row1).forEach(System.out::print);/*
        List<String> row2 = new ArrayList<>();
        row2.add("4");
        row2.add("5");
        row2.add("6");
        row2.add("7");
        List<String> row3 = new ArrayList<>();
        row3.add("8");
        row3.add("9");
        row3.add("10");
        row3.add("11");

        List<List<String>> matrix = new ArrayList<>();
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        Utilities.printMatrixByRows(matrix);
        System.out.println("FIRST LIST: ");
        matrix.get(0).forEach(s -> System.out.print(s + ", "));
        System.out.println("\nTRANSPOSING: ");
        //matrix = Utilities.transpose(matrix);
        System.out.println();
        System.out.println("AFTER TRANSPOSE: ");


        Utilities.printMatrixByColumns(matrix);
        Utilities.printMatrixByRows(matrix);

        System.out.println();

        System.out.println("FIRST LIST: ");
        matrix.get(0).forEach(s -> System.out.print(s + ", "));

        System.out.println();
        System.out.println("WITH ITERATOR: ");

        ContinuousMatrixRowIterator iterator = new ContinuousMatrixRowIterator(matrix);
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString() + ", ");
        }*/
    }
}
