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

    private final Color TILE_COLOR_A = new Color(145, 146, 137, 255);
    private final Color TILE_COLOR_B = new Color(210, 208, 209, 255);

    public Grid(FieldSizes fs, GameModes gameMode) {
        setBounds(0, 0, WINDOW_WIDTH, WINDOW_WIDTH);
        GridLayout gridLayout = new GridLayout(fs.getN(), fs.getM(), 5, 5);
        setLayout(gridLayout);
        addMouseListener(new MouseController(gameMode.getLogic()));


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
        gameMode.getLogic().setGrid(this);
        gameMode.getLogic().initGame();
        setVisible(true);
    }

    public List<List<Tile>> getTiles() {
        return tiles;
    }
}
