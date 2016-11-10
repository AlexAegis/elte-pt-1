package com.github.alexaegis.panels;

import com.github.alexaegis.buttons.ExitButton;
import com.github.alexaegis.buttons.PlayButton;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    public Menu() {
        setLayout(new GridBagLayout());
        add(new PlayButton());
        add(new ExitButton());
    }

}
