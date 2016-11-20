package com.github.alexaegis.elements;

import com.github.alexaegis.logic.FieldSizeOptions;
import com.github.alexaegis.logic.GameModes;
import com.github.alexaegis.panels.GamePanel;

import javax.swing.*;
import java.awt.*;

import static com.github.alexaegis.Main.*;
import static com.github.alexaegis.Main.WINDOW_HEIGHT;
import static com.github.alexaegis.Main.WINDOW_WIDTH;

public class PlayButton extends GameButton {

    public PlayButton() {
        name = "Play";
        setName(name);
        setText(name);
        addActionListener(actionEvent -> {
            JPanel gp = (JPanel) getParent().getParent();
            JComboBox comboBox = (JComboBox) getParent().getComponent(2);
            FieldSizeOptions fieldSizeOption = (FieldSizeOptions) comboBox.getSelectedItem();
            /*NumberSelector n1 = (NumberSelector) getParent().getComponent(4);
            NumberSelector n2 = (NumberSelector) getParent().getComponent(6);
            fieldSizeOption.setCustomSize(Math.max(n1.getValue(), n2.getValue()), Math.max(n1.getValue(), n2.getValue()));*/
            TILE_SIZE = GRID_SIZE_DEFAULT / Math.max(fieldSizeOption.getWidth(), fieldSizeOption.getHeight());
            gp.removeAll();
            gp.add(new GamePanel(fieldSizeOption, ((GameModes) ((GameModeSelector) getParent().getComponent(1)).getSelectedItem())));
            gp.revalidate();
            gp.repaint();
        });
    }


}