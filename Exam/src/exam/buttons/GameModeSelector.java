package exam.buttons;

import exam.config.GameModes;

import javax.swing.*;
import java.util.Arrays;

public class GameModeSelector extends JComboBox<GameModes> {

    public GameModeSelector() {
        Arrays.stream(GameModes.values()).forEach(this::addItem);
        setSelectedIndex(0);
    }
}