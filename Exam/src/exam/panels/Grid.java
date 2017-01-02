package exam.panels;

import exam.config.GameModes;
import exam.controllers.MouseController;
import exam.config.FieldSizes;
import exam.logic.abstraction.Coordinate;
import exam.logic.abstraction.Directions;
import exam.logic.iterators.DirectionalMapIterator;
import exam.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

import static exam.config.Config.WINDOW_WIDTH;
import static exam.panels.Game.GAME_BG_COLOR;

public class Grid extends JPanel implements Iterable<Coordinate> {

    private List<List<Tile>> tiles = new ArrayList<>();

    private Map<Coordinate, Tile> tileMap = new TreeMap<>();

    private int gridWidthByPixels;
    private int gridHeightByPixels;
    private int gridWidthByTiles;
    private int gridHeightByTiles;
    private int tileWidthByPixels;
    private int tileHeightByPixels;
    private int hGap = 5;
    private int vGap = 5;

    private final Color TILE_COLOR_A = new Color(145, 146, 137, 255);
    private final Color TILE_COLOR_B = new Color(210, 208, 209, 255);

    public Grid(FieldSizes fieldSize, GameModes gameMode, int minRng, int maxRng, List<Directions> directions) {
        setBounds(0, 0, WINDOW_WIDTH, WINDOW_WIDTH);
        GridLayout gridLayout = new GridLayout(fieldSize.getN(), fieldSize.getM(), hGap, vGap);
        setLayout(gridLayout);
        MouseController mouseController = new MouseController(gameMode.getLogic());
        addMouseListener(mouseController);
        addMouseMotionListener(mouseController);
        gridWidthByTiles = fieldSize.getN();
        gridHeightByTiles = fieldSize.getM();
        gridWidthByPixels = getWidth();
        gridHeightByPixels = getHeight();
        tileHeightByPixels = gridHeightByPixels / gridHeightByTiles - vGap;
        tileWidthByPixels = gridWidthByPixels / gridWidthByTiles - hGap;

        setBackground(GAME_BG_COLOR);

        // MAP IMPLEMENTATION
        for (int i = 0; i < fieldSize.getN(); i++) {
            for (int j = 0; j < fieldSize.getM(); j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Tile tile = new Tile((i + j) % 2 == 0 ? TILE_COLOR_A : TILE_COLOR_B,
                        WINDOW_WIDTH / fieldSize.getN(),
                        WINDOW_WIDTH / fieldSize.getM(), coordinate);
                tileMap.put(coordinate, tile);
            }
        }
        tileMap.values().forEach(this::add);
        if(directions != null && !directions.isEmpty()) {
            gameMode.getLogic().setValidDirections(directions);
        }
        gameMode.getLogic().setRng(minRng, maxRng);
        gameMode.getLogic().setGrid(this);
        gameMode.getLogic().initGame();
        setVisible(true);
    }

    public Map<Coordinate, Tile> getTiles() {
        return tileMap;
    }

    public int getGridWidthByPixels() {
        return gridWidthByPixels;
    }

    public int getGridHeightByPixels() {
        return gridHeightByPixels;
    }

    public int getGridWidthByTiles() {
        return gridWidthByTiles;
    }

    public int getGridHeightByTiles() {
        return gridHeightByTiles;
    }

    public int getTileWidthByPixels() {
        return tileWidthByPixels;
    }

    public int getTileHeightByPixels() {
        return tileHeightByPixels;
    }

    public int gethGap() {
        return hGap;
    }

    public int getvGap() {
        return vGap;
    }

    @Override
    public Iterator<Coordinate> iterator() {
        return new DirectionalMapIterator(tileMap, Directions.DOWN);
    }
}