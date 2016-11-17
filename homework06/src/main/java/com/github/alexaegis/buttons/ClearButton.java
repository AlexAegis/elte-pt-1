package com.github.alexaegis.buttons;

import com.github.alexaegis.Main;
import com.github.alexaegis.fields.DisplayField;
import com.github.alexaegis.panels.CalculatorPanel;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Window.BUTTON_SIZE;

public class ClearButton extends Button {

    private final String name = "C";

    public ClearButton() {
        setName(name);
        setLabel(name);
        setPreferredSize(BUTTON_SIZE);
        addActionListener(actionEvent -> {
            DisplayField.empty = true;
            //CalculatorPanel.getDisplayField().setText("0");
            JPanel panel = (JPanel) getParent();
            ((JTextField) panel.getComponent(0)).setText("0");
            Main.getLogger().info(name + " pressed");
        });
    }
}