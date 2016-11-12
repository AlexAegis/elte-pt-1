package com.github.alexaegis.panels;

import com.github.alexaegis.buttons.ClearButton;
import com.github.alexaegis.buttons.NumberButton;
import com.github.alexaegis.buttons.OperationButton;
import com.github.alexaegis.fields.DisplayField;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Window.BUTTON_SIZE;
import static com.github.alexaegis.Window.WINDOW_HEIGHT;
import static com.github.alexaegis.Window.WINDOW_WIDTH;

public class CalculatorPanel extends JPanel {

    private GridBagConstraints c = new GridBagConstraints();

    public CalculatorPanel() {
        setLayout(new GridBagLayout());

        //setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));

        c.gridy = 0;
        c.gridx = 0;
        /*constraints.weightx = 0.5;
        constraints.gridwidth = 4;
        constraints.gridheight = 1;
        add(new DisplayField(), constraints);*/
        c.gridx = 0;
        c.gridy = 0;
        add(new ClearButton(), c);
        c.gridy = 1;
        add(new OperationButton("="), c);
        c.gridy = 2;
        add(new OperationButton("/"), c);
        c.gridy = 3;
        add(new OperationButton("*"), c);

        c.gridx = 2;
        c.gridy = 0;
        add(new NumberButton(7));
        c.gridy = 1;
        add(new NumberButton(8));
        c.gridy = 2;
        add(new NumberButton(9));
        c.gridy = 3;
        add(new OperationButton("-"));

        c.gridx = 3;
        c.gridy = 0;
        add(new NumberButton(7));
        c.gridy = 1;
        add(new NumberButton(5));
        c.gridy = 2;
        add(new NumberButton(6));
        c.gridy = 3;
        add(new OperationButton("+"));/*
        add(new NumberButton(1));
        add(new NumberButton(2));
        add(new NumberButton(3));
        OperationButton equation = new OperationButton("=");
        equation.setPreferredSize(new Dimension((int) Math.round(BUTTON_SIZE.getWidth()), (int) Math.round(BUTTON_SIZE.getHeight()) * 2));
        add(equation);
        NumberButton zero = new NumberButton(0);
        zero.setPreferredSize(new Dimension((int) Math.round(BUTTON_SIZE.getWidth()) * 2, (int) Math.round(BUTTON_SIZE.getHeight())));
        add(zero);
        add(new OperationButton("."));*/
    }
}