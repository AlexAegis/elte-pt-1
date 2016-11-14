package com.github.alexaegis.panels;

import com.github.alexaegis.elements.*;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {

    Button play = new PlayButton();
    Button exit = new ExitButton();
    JComboBox selector = new GameFieldSelector();
    JComboBox numberSelector1 = new NumberSelector();
    JComboBox numberSelector2 = new NumberSelector();

    public Menu() {

        setPreferredSize(new Dimension(240,240));
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridy = 0;
        constraints.gridx = 1;
        constraints.insets = new Insets(40,0,40,40);
        constraints.anchor = GridBagConstraints.WEST;
        add(play, constraints);

        constraints.gridy = 1;
        constraints.gridx = 1;
        add(selector, constraints);

        constraints.gridy = 2;
        constraints.gridx = 1;
        add(exit, constraints);
        constraints.insets = new Insets(0, 0, 0, 0);

        constraints.gridy = 1;
        constraints.gridx = 2;
        add(numberSelector1, constraints);

        constraints.gridy = 1;
        constraints.gridx = 3;
        add(new JLabel(" by "), constraints);

        constraints.gridy = 1;
        constraints.gridx = 4;
        add(numberSelector2, constraints);

        constraints.gridy = 1;
        constraints.gridx = 0;
        add(new JLabel("Size of the gamefield: "), constraints);

        constraints.gridy = 0;
        constraints.gridx = 4;
        add(Box.createHorizontalStrut(200), constraints);
    }
}