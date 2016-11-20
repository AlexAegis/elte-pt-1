package com.github.alexaegis.elements;

import com.github.alexaegis.Main;
import com.github.alexaegis.logic.GameModes;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.BUTTON_SIZE;

public class ExitButton extends GameButton {

    public ExitButton() {
        name = "Exit";
        setName(name);
        setText(name);
        addActionListener(actionEvent -> {
            Main.getLogger().info("Process terminated through Exit Button");
            System.exit(0);
        });
    }

}