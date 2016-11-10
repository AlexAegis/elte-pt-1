package com.github.alexaegis;

import com.github.alexaegis.panels.Menu;

import javax.swing.*;

public class Window extends JFrame {

    private static final int WINDOW_HEIGHT = Integer.parseInt(Main.getProps().getProperty("window_height"));
    private static final int WINDOW_WIDTH = Integer.parseInt(Main.getProps().getProperty("window_width"));
    private static final String WINDOW_NAME_MAIN = Main.getProps().getProperty("window_name_main");
    private static final boolean WINDOW_RESIZEABLE = Boolean.parseBoolean(Main.getProps().getProperty("window_resizeable"));

    public Window() {
        setTitle(WINDOW_NAME_MAIN);
        setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
        setResizable(WINDOW_RESIZEABLE);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new Menu());

    }

}