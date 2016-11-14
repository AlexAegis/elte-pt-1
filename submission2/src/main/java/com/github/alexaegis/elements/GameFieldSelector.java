package com.github.alexaegis.elements;

import com.github.alexaegis.logic.FieldSizeOptions;

import javax.swing.*;

public class GameFieldSelector extends JComboBox {

    public GameFieldSelector() {
        addItem(FieldSizeOptions.SIX);
        addItem(FieldSizeOptions.EIGTH);
        addItem(FieldSizeOptions.TEN);
        addItem(FieldSizeOptions.CUSTOM);
        setSelectedIndex(0);
        addActionListener(actionEvent -> {
            if(getSelectedItem().equals(FieldSizeOptions.CUSTOM)) {
                getParent().getComponent(3).setEnabled(true);
                getParent().getComponent(5).setEnabled(true);
                getParent().revalidate();
                getParent().repaint();
            } else {
                getParent().getComponent(3).setEnabled(false);
                getParent().getComponent(5).setEnabled(false);
                getParent().revalidate();
                getParent().repaint();
            }
        });
    }
}