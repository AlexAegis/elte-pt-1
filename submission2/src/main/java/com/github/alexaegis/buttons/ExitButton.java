package com.github.alexaegis.buttons;

import com.github.alexaegis.Main;

import java.awt.*;

public class ExitButton extends Button {

    private static final int WINDOW_HEIGHT = Integer.parseInt(Main.getProps().getProperty("window_height"));
    private static final int WINDOW_WIDTH = Integer.parseInt(Main.getProps().getProperty("window_width"));
    private static final Dimension BUTTON_SIZE = new Dimension(WINDOW_HEIGHT / 10, WINDOW_WIDTH / 16);

    private final String NAME = "Exit";

    public ExitButton() {
        setName(NAME);
        setLabel(NAME);
        setSize(BUTTON_SIZE);
        addActionListener(actionEvent -> {
            Main.getLogger().info("Process terminated through Exit Button");
            System.exit(0);
        });
    }
}
