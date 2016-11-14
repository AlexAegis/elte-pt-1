package com.github.alexaegis.elements;

import com.github.alexaegis.panels.MenuPanel;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.BUTTON_SIZE;

public class MenuButton extends Button {

    private final String name = "Back to menu";

    public MenuButton() {
        setName(name);
        setLabel(name);
        setSize(BUTTON_SIZE);
        addActionListener(actionEvent -> {
            JPanel gp = (JPanel) getParent().getParent();
            gp.removeAll();
            gp.add(new MenuPanel());
            gp.revalidate();
            gp.repaint();
        });
    }
}
