package com.github.alexaegis;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public final class Main {

    private static final Properties PROPERTIES = new Properties();
    private static final String CONFIG = "config.properties";

    public static int GRID_SIZE_DEFAULT;
    public static Dimension GRID_DIMENSIONS;
    public static int WINDOW_HEIGHT;
    public static int WINDOW_WIDTH;
    public static String WINDOW_NAME_MAIN;
    public static boolean WINDOW_RESIZEABLE;
    public static Dimension BUTTON_SIZE;
    public static int TILE_SIZE;

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            PROPERTIES.load(Main.class.getClassLoader().getResourceAsStream(CONFIG));
            GRID_SIZE_DEFAULT = Integer.parseInt(PROPERTIES.getProperty("grid_size_default"));
            GRID_DIMENSIONS = new Dimension(GRID_SIZE_DEFAULT, GRID_SIZE_DEFAULT);
            WINDOW_HEIGHT = Integer.parseInt(PROPERTIES.getProperty("window_height"));
            WINDOW_WIDTH = Integer.parseInt(PROPERTIES.getProperty("window_width"));
            WINDOW_NAME_MAIN = PROPERTIES.getProperty("window_name_main");
            WINDOW_RESIZEABLE = Boolean.parseBoolean(PROPERTIES.getProperty("window_resizeable"));
            BUTTON_SIZE = new Dimension(WINDOW_WIDTH / 6, WINDOW_HEIGHT / 14);

            EventQueue.invokeLater(() -> {
                Window window = new Window();
                window.setVisible(true);
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

}