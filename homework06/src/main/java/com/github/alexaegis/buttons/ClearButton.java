package com.github.alexaegis.buttons;

import com.github.alexaegis.Main;

import java.awt.*;

import static com.github.alexaegis.Window.BUTTON_SIZE;

public class ClearButton extends Button {

    private final String name = "C";

    public ClearButton() {
        setName(name);
        setLabel(name);
        //setPreferredSize(BUTTON_SIZE);
        addActionListener(actionEvent -> {
            Main.getLogger().info("Process terminated through Exit Button");
            System.exit(0);
        });
    }
}