package com.github.alexaegis.elements;

import com.github.alexaegis.logic.GameLogic;
import com.github.alexaegis.tiles.Pawn;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.BUTTON_SIZE;

public class PlayerIndicator extends JComponent {

    private Paint actualPlayerColor;
    private GameLogic gameLogic;

    public PlayerIndicator(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public void setIndicatorColor(int actualPlayer) {
        actualPlayerColor = actualPlayer == 1 ? Pawn.getPlayer0Color() : Pawn.getPlayer1Color();
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D)g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        setIndicatorColor(gameLogic.getActualPlayer());
        graphics.setPaint(actualPlayerColor);
        graphics.fillRect(0, 0, BUTTON_SIZE.width, BUTTON_SIZE.height);
    }
}