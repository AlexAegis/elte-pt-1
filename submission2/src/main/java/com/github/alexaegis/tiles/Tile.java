package com.github.alexaegis.tiles;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {

    private Color originalColor;

    public Tile(Color color) {
        setLayout(new BorderLayout());
        originalColor = color;
        applyOriginalColor();
    }

    public void applyOriginalColor() {
        setBackground(originalColor);
    }
}