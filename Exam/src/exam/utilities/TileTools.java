package exam.utilities;

import exam.elements.tiles.Tile;

import java.awt.*;
import java.util.List;

public abstract class TileTools {

    public static void rotateChild(List<Tile> tiles) {
        Component current = tiles.get(tiles.size() - 1).removeChild();
        for (Tile tile : tiles) {
            Component temp = current;
            if (tile.gotChild()) current = tile.removeChild();
            tile.setChild(temp);
        }
    }

    public static void rotateChild(List<Tile> tiles, int times) {
        for (int i = 0; i < times; i++) {
            rotateChild(tiles);
        }
    }
}