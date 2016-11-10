package com.github.alexaegis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.IOException;
import java.util.Properties;

public final class Main {

    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);
    private static final Properties PROPERTIES = new Properties();
    private static final String CONFIG = "konfig.properties";

    public static void main(String[] args) {

        try {
            PROPERTIES.load(Main.class.getClassLoader().getResourceAsStream(CONFIG));
            EventQueue.invokeLater(() -> {
                Window window = new Window();
                window.setVisible(true);
            });
        } catch (IOException e) {
            LOGGER.error("Couldn't load the file: " + CONFIG);
            e.printStackTrace();
        }
    }

    public static Properties getProperties() {
        return PROPERTIES;
    }
}