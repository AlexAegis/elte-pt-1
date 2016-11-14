package com.github.alexaegis.tiles;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {

    private Color originalColor;

    public Tile() {
        setLayout(new BorderLayout());
    }

    public void setOriginalColor(Color originalColor) {
        this.originalColor = originalColor;
    }

    public void applyOriginalColor() {
        setBackground(originalColor);
    }
}