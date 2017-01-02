package exam.buttons;

import exam.config.GameModes;

import javax.swing.*;
import java.util.Arrays;

import static exam.panels.Menu.CHECKBOXPANEL;
import static exam.panels.Menu.VALIDDIRSLABEL;

public class GameModeSelector extends JComboBox<GameModes> {

    public GameModeSelector() {
        Arrays.stream(GameModes.values()).forEach(this::addItem);
        setSelectedIndex(0);
        addActionListener(e -> {
            if(getSelectedItem().equals(GameModes.NUMBER_GAME)) {
                CHECKBOXPANEL.setVisible(true);
                VALIDDIRSLABEL.setVisible(true);
            } else {
                CHECKBOXPANEL.setVisible(false);
                VALIDDIRSLABEL.setVisible(false);
            }
        });
    }
}