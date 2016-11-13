package com.github.alexaegis.buttons;

import com.github.alexaegis.logic.GameType;
import com.github.alexaegis.panels.Game;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.BUTTON_SIZE;

public class PlayButton extends Button {

    private final String name = "Play Dash";

    public PlayButton() {
        setName(name);
        setLabel(name);
        setSize(BUTTON_SIZE);
        addActionListener(actionEvent -> {
            JPanel gp = (JPanel) getParent().getParent();
            gp.removeAll();
            gp.add(new Game(GameType.DASH));
            gp.revalidate();
            gp.repaint();
        });
    }
}