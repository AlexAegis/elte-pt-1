package exam.utilities;

import java.util.ArrayList;
import java.util.List;

public abstract class MatrixTools {

    public static <T> List<List<T>> transpose(List<List<T>> matrix) {
        List<List<T>> result = new ArrayList<>();
        for (int i = 0; i < matrix.get(0).size(); i++) {
            List<T> col = new ArrayList<>();
            for (List<T> row : matrix) {
                col.add(row.get(i));
            }
            result.add(col);
        }
        return result;
    }

    public static <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<T>(list);
        for (int i = 0; i < list.size(); i++) {
            result.set(result.size() - i - 1, list.get(i));
        }
        return result;
    }

    public static <T> List<List<T>> copyMatrix(List<List<T>> matrix) {
        List<List<T>> result = new ArrayList<>();
        for (List<T> row : matrix) {
            List<T> rowCopy = new ArrayList<T>();
            for (T item : row) {
                rowCopy.add(item); // should be cloned the item
            }
            result.add(rowCopy);
        }
        return result;
    }

    public static <T> List<T> getRowFromMatrix(List<List<T>> matrix, int n) {
        return matrix.get(n);
    }

    public static <T> List<T> getColumnFromMatrix(List<List<T>> matrix, int n) {
        return transpose(matrix).get(n);
    }

    public static <T> void printMatrixByRows(List<List<T>> matrix) {
        matrix.forEach(row -> {
            row.forEach(t -> System.out.print(t.toString() + ", "));
            System.out.println("-");
        });
    }

    public static <T> void printMatrixByColumns(List<List<T>> matrix) {
        for (int i = 0; i < matrix.get(0).size(); i++) {
            for (int j = 0; j < matrix.size(); j++) {
                System.out.print(matrix.get(j).get(i).toString() + ", ");
            }
            System.out.println("-");
        }
    }
}