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
}