package com.github.alexaegis.panels;

import com.github.alexaegis.buttons.ExitButton;

import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {

    public Game() {
        setLayout(new GridBagLayout());
        add(new ExitButton());
        add(new GameField());

    }
}