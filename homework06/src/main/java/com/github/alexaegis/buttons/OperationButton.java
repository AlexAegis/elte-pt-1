package com.github.alexaegis.buttons;

import com.github.alexaegis.Main;

import java.awt.*;

import static com.github.alexaegis.Window.BUTTON_SIZE;

public class OperationButton extends Button {

    private final String name;

    public OperationButton(String name) {
        this.name = name;
        setName(name);
        setLabel(name);
        //setPreferredSize(BUTTON_SIZE);
        addActionListener(actionEvent -> {
            Main.getLogger().info(name + " pressed");
        });
    }
}