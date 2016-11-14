package com.github.alexaegis.elements;

import com.github.alexaegis.Main;

import java.awt.*;

import static com.github.alexaegis.Main.BUTTON_SIZE;

public class ExitButton extends Button {

    private final String name = "Exit";

    public ExitButton() {
        setName(name);
        setLabel(name);
        setSize(BUTTON_SIZE);
        addActionListener(actionEvent -> {
            Main.getLogger().info("Process terminated through Exit Button");
            System.exit(0);
        });
    }
}