package com.github.alexaegis.panels;

import com.github.alexaegis.elements.MenuButton;
import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.logic.GameTypeOptions;
import com.github.alexaegis.elements.ExitButton;
import com.github.alexaegis.controllers.MouseControl;
import com.github.alexaegis.tiles.Pawn;

import javax.swing.*;

import java.awt.*;

import static com.github.alexaegis.Main.*;

public class GamePanel extends JLayeredPane {

    private MouseControl mouseControl = new MouseControl();
    private GameFieldPanel gameFieldPanel;
    public static int xOffset = (int) (WINDOW_WIDTH / 1.4);
    public static int yOffset = 20;
    private FieldSizeOptions option;

    private Button menuButton = new MenuButton();
    private Button exitButton = new ExitButton();

    public GamePanel(GameTypeOptions gameTypeOptions, FieldSizeOptions option) {
        this.option = option;
        TILE_SIZE = GRID_SIZE_DEFAULT / Math.min(option.getN(), option.getM());
        menuButton.setBounds(20, WINDOW_WIDTH - 180, 100, 50);
        exitButton.setBounds(20, WINDOW_WIDTH - 90, 100, 50);
        add(menuButton, 2);
        add(exitButton, 2);
        gameFieldPanel = new GameFieldPanel(option);
        gameFieldPanel.setBounds(xOffset, yOffset, GRID_SIZE_DEFAULT, GRID_SIZE_DEFAULT);
        add(gameFieldPanel, JLayeredPane.DEFAULT_LAYER, 1);
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
        for (int i = 0; i < Math.min(option.getN(), option.getM()) * 2; i++) {
            JLabel piece = new Pawn(0);
            JPanel panel = (JPanel) gameFieldPanel.getComponent(i);
            panel.add(piece);
        }
        for (int i = 0; i < Math.min(option.getN(), option.getM()) * 2; i++) {
            JLabel piece = new Pawn(1);
            JPanel panel = (JPanel) gameFieldPanel.getComponent((Math.min(option.getN(), option.getM()) * Math.min(option.getN(), option.getM())) - i - 1);
            panel.add(piece);
        }
    }

}