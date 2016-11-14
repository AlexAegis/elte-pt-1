package com.github.alexaegis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.Properties;

public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final Properties PROPERTIES = new Properties();
    private static final String CONFIG = "config.properties";

    public static int GRID_SIZE_DEFAULT;
    public static int GRID_TILECOUNT_DEFAULT;
    public static Dimension TILE_DIMENSIONS;
    public static int TILE_SIZE;
    public static Dimension GRID_DIMENSIONS;
    public static int WINDOW_HEIGHT;
    public static int WINDOW_WIDTH;
    public static String WINDOW_NAME_MAIN;
    public static boolean WINDOW_RESIZEABLE;
    public static Dimension BUTTON_SIZE;

    public static void main(String[] args) {

        try {
            PROPERTIES.load(Main.class.getClassLoader().getResourceAsStream(CONFIG));
            GRID_SIZE_DEFAULT = Integer.parseInt(PROPERTIES.getProperty("grid_size_default"));
            GRID_TILECOUNT_DEFAULT = Integer.parseInt(PROPERTIES.getProperty("grid_tilecount_default"));
            GRID_DIMENSIONS = new Dimension(GRID_SIZE_DEFAULT, GRID_SIZE_DEFAULT);
            WINDOW_HEIGHT = Integer.parseInt(PROPERTIES.getProperty("window_height"));
            WINDOW_WIDTH = Integer.parseInt(PROPERTIES.getProperty("window_width"));
            WINDOW_NAME_MAIN = PROPERTIES.getProperty("window_name_main");
            WINDOW_RESIZEABLE = Boolean.parseBoolean(PROPERTIES.getProperty("window_resizeable"));
            BUTTON_SIZE = new Dimension(WINDOW_HEIGHT / 10, WINDOW_WIDTH / 16);
            TILE_SIZE = GRID_SIZE_DEFAULT / GRID_TILECOUNT_DEFAULT;

            EventQueue.invokeLater(() -> {
                Window window = new Window();
                window.setVisible(true);
            });
        } catch (Exception e) {
            LOGGER.error("Couldn't load the file: " + CONFIG);
        }
    }

    public static Logger getLogger() {
        return LOGGER;
    }

}