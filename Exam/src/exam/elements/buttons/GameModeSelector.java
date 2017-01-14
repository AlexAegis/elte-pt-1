package exam.elements.buttons;

import exam.config.GameModes;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static exam.elements.panels.Menu.*;

public class GameModeSelector extends JComboBox<GameModes> {

    public GameModeSelector() {
        Arrays.stream(GameModes.values()).forEach(this::addItem);
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
                    setBackVisibility(false);
                    setPauseVisibility(false);
                    break;
                case QUEENS:
                case KNIGHTSTOUR:
                    //To Show
                    setBackVisibility(true);
                    setPauseVisibility(true);
                    //To Hide
                    setIndicatorVisibility(false);
                    setDifficultyVisibility(false);
                    setHintButtonVisibility(false);
                    setDirectionSelectorVisibility(false);
                    setModifierVisibility(false);
                    setRngVisibility(false);
                    break;
                case DASH:
                    //To Show
                    setIndicatorVisibility(true);
                    //To Hide
                    setDirectionSelectorVisibility(false);
                    setModifierVisibility(false);
                    setRngVisibility(false);
                    setBackVisibility(false);
                    setPauseVisibility(false);
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
                    setBackVisibility(false);
                    setPauseVisibility(false);
                    break;
                default:
                    break;
            }
        });
        EventQueue.invokeLater(() -> setSelectedIndex(0));
    }

    private void setBackVisibility(boolean value) {
        BACKBUTTON.setVisible(value);
    }

    private void setPauseVisibility(boolean value) {
        PAUSEBUTTON.setVisible(value);
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