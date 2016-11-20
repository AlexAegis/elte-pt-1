package com.github.alexaegis.elements;

import com.github.alexaegis.logic.FieldSizeOptions;

import javax.swing.*;

public class GameFieldSelector extends JComboBox {

    public GameFieldSelector() {
        addItem(FieldSizeOptions.TEN);
        addItem(FieldSizeOptions.EIGHT);
        addItem(FieldSizeOptions.SIX);
        addItem(FieldSizeOptions.CUSTOM);
        setSelectedIndex(0);
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
        });
    }
}