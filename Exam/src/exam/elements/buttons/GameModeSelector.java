package exam.elements.buttons;

import exam.config.GameModes;
import exam.elements.panels.Menu;

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
                    setDirectionSelectorVisibility(true);
                    setModifierVisibility(true);
                    setRngVisibility(true);
                    // To hide
                    setIndicatorVisibility(false);
                    setDifficultyVisibility(false);
                    setHintButtonVisibility(false);
                    break;
                case DASH:
                    //To Show
                    setIndicatorVisibility(true);
                    //To Hide
                    setDirectionSelectorVisibility(false);
                    setModifierVisibility(false);
                    setRngVisibility(false);
                    break;
                case DRAUGHT:
                    //To Show
                    setIndicatorVisibility(true);
                    //To Hide
                    setDirectionSelectorVisibility(false);
                    setModifierVisibility(false);
                    setRngVisibility(false);
                    break;
                case MASTERMIND:
                    // To show
                    setDifficultyVisibility(true);
                    setHintButtonVisibility(true);
                    // To hide
                    setIndicatorVisibility(false);
                    setDirectionSelectorVisibility(false);
                    setModifierVisibility(false);
                    setRngVisibility(false);
                    break;
                default:
                    break;
            }
        });
    }
    private void setHintButtonVisibility(boolean value) {
        HINTLABEL.setVisible(value);
        HINTBUTTON.setVisible(value);
    }
    private void setDifficultyVisibility(boolean value) {
        DIFFLABEL.setVisible(value);
        DIFFSELECTOR.setVisible(value);
    }

    private void setModifierVisibility(boolean value) {
        MODIFIERLABEL.setVisible(value);
        MODIFIERSELECTOR.setVisible(value);
    }

    private void setDirectionSelectorVisibility(boolean value) {
        CHECKBOXPANEL.setVisible(value);
        VALIDDIRSLABEL.setVisible(value);
    }

    private void setIndicatorVisibility(boolean value) {
        PLAYERINDICATORLABEL.setVisible(value);
        PLAYERINDICATOR.setVisible(value);
    }

    private void setRngVisibility(boolean value) {
        RNGLABEL.setVisible(value);
        MINRNGLABEL.setVisible(value);
        MINRNGSELECTOR.setVisible(value);
        MAXRNGLABEL.setVisible(value);
        MAXRNGSELECTOR.setVisible(value);
    }
}