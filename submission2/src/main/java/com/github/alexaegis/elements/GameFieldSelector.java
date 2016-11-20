package com.github.alexaegis.elements;

import com.github.alexaegis.logic.FieldSizeOptions;

import javax.swing.*;
import java.util.Arrays;

public class GameFieldSelector extends JComboBox {

    public GameFieldSelector() {
        Arrays.stream(FieldSizeOptions.values()).forEach(this::addItem);
        setSelectedIndex(0);/*
        addActionListener(actionEvent -> {
            if(getSelectedItem().equals(FieldSizeOptions.CUSTOM)) {
                getParent().getComponent(4).setEnabled(true);
                getParent().getComponent(6).setEnabled(true);
                getParent().revalidate();
                getParent().repaint();
            } else {
                getParent().getComponent(4).setEnabled(false);
                getParent().getComponent(6).setEnabled(false);
                getParent().revalidate();
                getParent().repaint();
            }
        });*/
    }
}