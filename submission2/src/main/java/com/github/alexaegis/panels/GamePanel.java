package com.github.alexaegis.panels;

import com.github.alexaegis.elements.MenuButton;
import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.elements.ExitButton;
import com.github.alexaegis.logic.GameModes;
import com.github.alexaegis.controllers.MouseControl;

import javax.swing.*;

import java.awt.*;

import static com.github.alexaegis.Main.*;

public class GamePanel extends JLayeredPane {

    private MouseControl mouseControl;
    private GameFieldPanel gameFieldPanel;
    public static int xOffset = (WINDOW_WIDTH - GRID_SIZE_DEFAULT) / 2;
    public static int yOffset = 20;

    private Button menuButton = new MenuButton();
    private Button exitButton = new ExitButton();
    private JLabel actualPlayerLabel = new JLabel("Next player: ");
    
    public GamePanel(FieldSizeOptions fieldSizeOption, GameModes gameMode) {
        mouseControl = new MouseControl(gameMode);
        gameFieldPanel = new GameFieldPanel(fieldSizeOption);
        gameFieldPanel.setBounds(xOffset, yOffset, GRID_SIZE_DEFAULT, GRID_SIZE_DEFAULT);
        menuButton.setBounds(20, WINDOW_WIDTH - 180, 100, 50);
        exitButton.setBounds(20, WINDOW_WIDTH - 90, 100, 50);
        actualPlayerLabel.setBounds(20, 90, 100, 50);

        gameMode.setActualGamePanel(gameFieldPanel);
        gameMode.initGame(fieldSizeOption);
        add(gameFieldPanel, JLayeredPane.DEFAULT_LAYER, 1);
        add(menuButton, 2);
        add(exitButton, 2);
        add(actualPlayerLabel, 2);
        addMouseListener(mouseControl);
        addMouseMotionListener(mouseControl);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setPaint(new GradientPaint(0, 0, new Color(25, 89, 138,255), WINDOW_WIDTH, WINDOW_HEIGHT / 2 ,new Color(70, 83, 167,255)));
        graphics.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}