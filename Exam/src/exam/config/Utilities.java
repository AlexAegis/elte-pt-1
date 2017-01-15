package exam.config;

import exam.elements.panels.Grid;
import exam.elements.tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Utilities {

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

    public static List<List<Tile>> getSquareFromGrid(Grid grid, int skippedLines) {
        List<List<Tile>> result = new ArrayList<>();
        if(skippedLines < 0 || skippedLines >= Math.min(grid.getGridHeightByTiles(), grid.getGridWidthByTiles())) throw new IndexOutOfBoundsException();
        for (int i = skippedLines; i < grid.getGridHeightByTiles() - skippedLines; i++) {
            List<Tile> row = getRowFromGrid(grid, i);
            result.add(row.subList(skippedLines, row.size() - skippedLines));
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

    public static List<Tile> getRowFromGrid(Grid grid, int n) {
        if(n < 0 || n >= grid.getGridHeightByTiles()) throw new IndexOutOfBoundsException();
        return grid.getTiles().entrySet().stream()
                .filter(entry -> entry.getKey().getX() == n)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<Tile> getColumnFromGrid(Grid grid, int n) {
        if(n < 0 || n >= grid.getGridWidthByTiles()) throw new IndexOutOfBoundsException();
        return grid.getTiles().entrySet().stream()
                .filter(entry -> entry.getKey().getY() == n)
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<List<Tile>> getColumnsFromGrid(Grid grid, int from, int to) {
        if(from < 0
                || to < 0
                || from >= grid.getGridHeightByTiles()
                || to >= grid.getGridHeightByTiles()
                || to <= from) throw new IndexOutOfBoundsException();
        List<List<Tile>> result = new ArrayList<>();
        for(int i = from; i <= to; i++) {
            result.add(getColumnFromGrid(grid, i));
        }
        return result;
    }

    public static List<List<Tile>> getRowsFromGrid(Grid grid, int from, int to) {
        if(from < 0
                || to < 0
                || from >= grid.getGridWidthByTiles()
                || to >= grid.getGridWidthByTiles()
                || to <= from) throw new IndexOutOfBoundsException();
        List<List<Tile>> result = new ArrayList<>();
        for(int i = from; i <= to; i++) {
            result.add(getRowFromGrid(grid, i));
        }
        return result;
    }

    public static <T> List<T> findComponents(final Container container, final Class<T> componentType) {
        return Stream.concat( Arrays.stream(container.getComponents())
                        .filter(componentType::isInstance)
                        .map(componentType::cast),
                Arrays.stream(container.getComponents())
                        .filter(Container.class::isInstance)
                        .map(Container.class::cast)
                        .flatMap(c -> findComponents(c, componentType).stream())
        ).collect(Collectors.toList());
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