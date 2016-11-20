package com.github.alexaegis.panels;

import com.github.alexaegis.elements.MenuButton;
import com.github.alexaegis.elements.PlayerIndicator;
import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.elements.ExitButton;
import com.github.alexaegis.logic.GameLogic;
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

    private JButton menuButton = new MenuButton();
    private JButton exitButton = new ExitButton();
    private JLabel actualPlayerLabel = new JLabel("Actual player: ");
    private PlayerIndicator playerIndicator;
    
    public GamePanel(FieldSizeOptions fieldSizeOption, GameLogic gameLogic) {
        mouseControl = new MouseControl(gameLogic);
        playerIndicator = new PlayerIndicator(gameLogic);
        gameFieldPanel = new GameFieldPanel(fieldSizeOption);
        gameFieldPanel.setBounds(xOffset, yOffset, GRID_SIZE_DEFAULT, GRID_SIZE_DEFAULT);
        menuButton.setBounds((WINDOW_WIDTH - GRID_SIZE_DEFAULT) / 2, WINDOW_HEIGHT - 70, 100, 30);
        exitButton.setBounds(((WINDOW_WIDTH - GRID_SIZE_DEFAULT) / 2) + 120, WINDOW_HEIGHT - 70, 100, 30);
        actualPlayerLabel.setBounds(WINDOW_WIDTH - ((WINDOW_WIDTH - GRID_SIZE_DEFAULT) / 2) - 280, WINDOW_HEIGHT - 70, 200, 30);
        actualPlayerLabel.setFont(new Font("Century Gothic", Font.PLAIN, (int) Math.round(BUTTON_SIZE.height / 2.4)));
        playerIndicator.setBounds(WINDOW_WIDTH - ((WINDOW_WIDTH - GRID_SIZE_DEFAULT) / 2) - 100, WINDOW_HEIGHT - 70, 100, 30);
        gameLogic.setActualGamePanel(gameFieldPanel);
        gameLogic.initGame(fieldSizeOption);
        add(gameFieldPanel, JLayeredPane.DEFAULT_LAYER, 1);
        add(menuButton, 2);
        add(exitButton, 2);
        add(actualPlayerLabel, 2);
        add(playerIndicator, 2);
        addMouseListener(mouseControl);
        addMouseMotionListener(mouseControl);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;
        graphics.setPaint(new GradientPaint(0, 0, new Color(96, 121, 211,255), WINDOW_WIDTH, WINDOW_HEIGHT / 2 ,new Color(46, 91, 206,255)));
        graphics.fillRect(0,0,WINDOW_WIDTH, WINDOW_HEIGHT);
    }
}