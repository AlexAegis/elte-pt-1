package com.github.alexaegis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
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
            BUTTON_SIZE = new Dimension(WINDOW_HEIGHT / 10, WINDOW_WIDTH / 16);

            EventQueue.invokeLater(() -> {
                Window window = new Window();
                window.setVisible(true);
            });
        } catch (IOException e) {
            LOGGER.error("Couldn't load the file: " + CONFIG);
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger() {
        return LOGGER;
    }

}