package com.github.alexaegis.panels;

import com.github.alexaegis.logic.GameType;
import com.github.alexaegis.buttons.ExitButton;
import com.github.alexaegis.controllers.MouseControl;
import com.github.alexaegis.tiles.Pawn;

import javax.swing.*;

import static com.github.alexaegis.Main.*;

public class Game extends JLayeredPane {

    private MouseControl mouseControl = new MouseControl();
    private GameField gameField = new GameField();
    public static int xOffset = (int) (WINDOW_WIDTH / 1.4);
    public static int yOffset = 20;

    public Game(GameType gameType) {
        add(new ExitButton(), 2);
        gameField.setBounds(xOffset, yOffset, GRID_SIZE_DEFAULT, GRID_SIZE_DEFAULT);
        add(gameField, JLayeredPane.DEFAULT_LAYER, 1);
        addMouseListener(mouseControl);
        addMouseMotionListener(mouseControl);
        initGame(gameType);
    }

    private void initGame(GameType gameType) {
        switch (gameType) {
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
        for (int i = 80; i < 100; i++) {
            JLabel piece = new Pawn();
            JPanel panel = (JPanel) gameField.getComponent(i);
            panel.add(piece);
        }
    }
}