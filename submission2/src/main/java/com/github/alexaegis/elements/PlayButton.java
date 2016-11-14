package com.github.alexaegis.elements;

import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.panels.GamePanel;

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
            JComboBox comboBox = (JComboBox) getParent().getComponent(1);
            FieldSizeOptions option = (FieldSizeOptions) comboBox.getSelectedItem();
            NumberSelector n1 = (NumberSelector) getParent().getComponent(3);
            NumberSelector n2 = (NumberSelector) getParent().getComponent(5);
            option.setCustomSize(Math.max(n1.getValue(), n2.getValue()), Math.max(n1.getValue(), n2.getValue()));
            gp.removeAll();
            gp.add(new GamePanel(option));
            gp.revalidate();
            gp.repaint();
        });
    }
}