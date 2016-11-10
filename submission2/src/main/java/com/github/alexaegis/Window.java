package com.github.alexaegis;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    private static final int WINDOW_HEIGHT = Integer.valueOf(Main.getProperties().getProperty("window_height"));
    private static final int WINDOW_WIDTH = Integer.valueOf(Main.getProperties().getProperty("window_width"));

    public Window() {
        setTitle("Simple example");
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
