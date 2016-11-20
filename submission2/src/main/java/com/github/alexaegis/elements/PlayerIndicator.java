package com.github.alexaegis.elements;

import com.github.alexaegis.logic.GameModes;
import com.github.alexaegis.tiles.Pawn;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.BUTTON_SIZE;

public class PlayerIndicator extends JComponent {

    private Paint actualPlayerColor;
    private GameModes gameMode;

    public PlayerIndicator(GameModes gameMode) {
        this.gameMode = gameMode;
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
        setIndicatorColor(gameMode.getActualPlayer());
        graphics.setPaint(actualPlayerColor);
        graphics.fillRect(0, 0, BUTTON_SIZE.width, BUTTON_SIZE.height);
    }
}