package exam.logic.iterators;


import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.tiles.Tile;

import java.util.Iterator;
import java.util.Map;

public class DirectionalMapIterator implements Iterator<Coordinate> {

    private Map<Coordinate, Tile> map;
    private Coordinate current = new Coordinate(-1, 0);
    private Directions direction;
    private int checkedItemsCount = 0;

    public DirectionalMapIterator(Map<Coordinate, Tile> map, Directions directions) {
        this.map = map;
        this.direction = directions;
    }

    @Override
    public boolean hasNext() {
        return checkedItemsCount < map.size();
    }

    @Override
    public Coordinate next() {
        checkedItemsCount = checkedItemsCount++;
        System.out.println(current.toString());
        if(map.get(current.stepInDirection(direction)) != null) {
            current = current.stepInDirection(direction);
            return current;
        } else {
            current = new Coordinate(-1, current.getY() + 1);
            return current;
        }
    }
}
