package com.github.alexaegis.panels;

import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.logic.GameTypeOptions;
import com.github.alexaegis.elements.ExitButton;
import com.github.alexaegis.controllers.MouseControl;
import com.github.alexaegis.tiles.Pawn;

import javax.swing.*;

import static com.github.alexaegis.Main.*;

public class Game extends JLayeredPane {

    private MouseControl mouseControl = new MouseControl();
    private GameField gameField;
    public static int xOffset = (int) (WINDOW_WIDTH / 1.4);
    public static int yOffset = 20;
    public FieldSizeOptions option;

    public Game(GameTypeOptions gameTypeOptions, FieldSizeOptions option) {
        this.option = option;

        TILE_SIZE = GRID_SIZE_DEFAULT / Math.min(option.getN(), option.getM());
        add(new ExitButton(), 2);
        gameField = new GameField(option);
        gameField.setBounds(xOffset, yOffset, GRID_SIZE_DEFAULT, GRID_SIZE_DEFAULT);
        add(gameField, JLayeredPane.DEFAULT_LAYER, 1);
        addMouseListener(mouseControl);
        addMouseMotionListener(mouseControl);
        initGame(gameTypeOptions);
    }

    private void initGame(GameTypeOptions gameTypeOptions) {
        switch (gameTypeOptions) {
            case DASH: initGameDash();
                break;
            case MYDASH: initGameDash();
                break;
            default: break;
        }
    }

    private void initGameDash() {
        for (int i = 0; i < 20; i++) {
            JLabel piece = new Pawn();
            JPanel panel = (JPanel) gameField.getComponent(i);
            panel.add(piece);
        }
    }

    public FieldSizeOptions getOption() {
        return option;
    }
}