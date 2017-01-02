package exam.panels;

import exam.config.GameModes;
import exam.controllers.MouseController;
import exam.config.FieldSizes;
import exam.tiles.Tile;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import static exam.config.Config.WINDOW_WIDTH;
import static exam.panels.Game.GAME_BG_COLOR;

public class Grid extends JPanel {

    private List<List<Tile>> tiles = new ArrayList<>();

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

    public Grid(FieldSizes fs, GameModes gameMode, int minRng, int maxRng) {
        setBounds(0, 0, WINDOW_WIDTH, WINDOW_WIDTH);
        GridLayout gridLayout = new GridLayout(fs.getN(), fs.getM(), hGap, vGap);
        setLayout(gridLayout);
        addMouseListener(new MouseController(gameMode.getLogic()));
        gridWidthByTiles = fs.getN();
        gridHeightByTiles = fs.getM();
        gridWidthByPixels = getWidth();
        gridHeightByPixels = getHeight();
        tileHeightByPixels = gridHeightByPixels / gridHeightByTiles - vGap;
        tileWidthByPixels = gridWidthByPixels / gridWidthByTiles - hGap;

        setBackground(GAME_BG_COLOR);

        for (int i = 0; i < fs.getN(); i++) {
            List<Tile> row = new ArrayList<>();
            for (int j = 0; j < fs.getM(); j++) {
                row.add(new Tile((i + j) % 2 == 0 ? TILE_COLOR_A : TILE_COLOR_B, WINDOW_WIDTH / fs.getN(), WINDOW_WIDTH / fs.getM(), i * 10 + j));
            }
            tiles.add(row);
        }

        for(List<Tile> row : tiles) {
            for(Tile b : row) {
                add(b);
            }
        }
        gameMode.getLogic().setRng(minRng, maxRng);
        gameMode.getLogic().setGrid(this);
        gameMode.getLogic().initGame();
        setVisible(true);
    }

    public List<List<Tile>> getTiles() {
        return tiles;
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
}