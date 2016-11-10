package com.github.alexaegis.buttons;

import com.github.alexaegis.Main;
import com.github.alexaegis.panels.Game;

import javax.swing.*;
import java.awt.*;

public class PlayButton extends Button {

    private static final int WINDOW_HEIGHT = Integer.parseInt(Main.getProps().getProperty("window_height"));
    private static final int WINDOW_WIDTH = Integer.parseInt(Main.getProps().getProperty("window_width"));
    private static final Dimension BUTTON_SIZE = new Dimension(WINDOW_HEIGHT / 10, WINDOW_WIDTH / 16);

    private final String name = "Play";

    public PlayButton() {
        setName(name);
        setLabel(name);
        setSize(BUTTON_SIZE);
        addActionListener(actionEvent -> {
            JPanel gp = (JPanel) getParent().getParent();
            gp.removeAll();
            gp.add(new Game());
            gp.revalidate();
            gp.repaint();
        });
    }
}