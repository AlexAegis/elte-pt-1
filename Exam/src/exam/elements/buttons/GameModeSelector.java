package exam.elements.buttons;

import exam.config.GameModes;

import javax.swing.*;
import java.util.Arrays;

import static exam.elements.panels.Menu.*;

public class GameModeSelector extends JComboBox<GameModes> {

    public GameModeSelector() {
        Arrays.stream(GameModes.values()).forEach(this::addItem);
        setSelectedIndex(0);
        addActionListener(e -> {
            switch ((GameModes) getSelectedItem()) {
                case NUMBER_GAME:
                    // To show
                    CHECKBOXPANEL.setVisible(true);
                    VALIDDIRSLABEL.setVisible(true);
                    MODIFIERLABEL.setVisible(true);
                    MODIFIERSELECTOR.setVisible(true);
                    VALIDDIRSLABEL.setVisible(true);
                    CHECKBOXPANEL.setVisible(true);
                    // To hide
                    DIFFLABEL.setVisible(false);
                    DIFFSELECTOR.setVisible(false);
                    HINTLABEL.setVisible(false);
                    HINTBUTTON.setVisible(false);
                    break;
                case DASH:
                    //To Hide
                    VALIDDIRSLABEL.setVisible(false);
                    CHECKBOXPANEL.setVisible(false);
                    break;
                case DRAUGHT:

                    //To Hide
                    VALIDDIRSLABEL.setVisible(false);
                    CHECKBOXPANEL.setVisible(false);
                    break;
                case MASTERMIND:
                    // To show
                    DIFFLABEL.setVisible(true);
                    DIFFSELECTOR.setVisible(true);
                    HINTLABEL.setVisible(true);
                    HINTBUTTON.setVisible(true);

                    // To hide

                    MODIFIERLABEL.setVisible(false);
                    MODIFIERSELECTOR.setVisible(false);
                    CHECKBOXPANEL.setVisible(false);
                    VALIDDIRSLABEL.setVisible(false);
                    break;
                default:
                    break;
            }
        });
    }
}