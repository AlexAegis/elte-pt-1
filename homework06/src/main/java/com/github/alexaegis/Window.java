package com.github.alexaegis;

import com.github.alexaegis.panels.CalculatorPanel;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public static final int WINDOW_HEIGHT = Integer.parseInt(Main.getProps().getProperty("window_height"));
    public static final int WINDOW_WIDTH = Integer.parseInt(Main.getProps().getProperty("window_width"));
    public static final String WINDOW_NAME_MAIN = Main.getProps().getProperty("window_name_main");
    public static final boolean WINDOW_RESIZEABLE = Boolean.parseBoolean(Main.getProps().getProperty("window_resizeable"));
    public static final Dimension BUTTON_SIZE = new Dimension((WINDOW_WIDTH / 4) - 8, (WINDOW_WIDTH / 4) - 8);

    public Window() {
        setTitle(WINDOW_NAME_MAIN);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(WINDOW_RESIZEABLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new CalculatorPanel());
    }
}