package com.github.alexaegis.elements;

import com.github.alexaegis.panels.MenuPanel;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.BUTTON_SIZE;

public class MenuButton extends GameButton {

    public MenuButton() {
        name = "Back";
        setName(name);
        setText(name);
        addActionListener(actionEvent -> {
            JPanel gp = (JPanel) getParent().getParent();
            gp.removeAll();
            gp.add(new MenuPanel());
            gp.revalidate();
            gp.repaint();
        });
    }
}
