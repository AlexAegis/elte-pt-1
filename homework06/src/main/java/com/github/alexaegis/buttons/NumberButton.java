package com.github.alexaegis.buttons;

import com.github.alexaegis.Main;
import com.github.alexaegis.fields.DisplayField;
import com.github.alexaegis.panels.CalculatorPanel;

import java.awt.*;

import static com.github.alexaegis.Window.BUTTON_SIZE;

public class NumberButton extends Button {

    private final String name;
    private final int value;

    public NumberButton(int value) {
        this.name = Integer.toString(value);
        this.value = value;
        setName(name);
        setLabel(name);
        setPreferredSize(BUTTON_SIZE);
        addActionListener(actionEvent -> {
            if(DisplayField.empty) {
                DisplayField.empty = false;
                CalculatorPanel.getDisplayField().setText(name);
            } else {
                CalculatorPanel.getDisplayField().setText(CalculatorPanel.getDisplayField().getText() + name);
            }
            Main.getLogger().info(name + " pressed");
        });
    }
}