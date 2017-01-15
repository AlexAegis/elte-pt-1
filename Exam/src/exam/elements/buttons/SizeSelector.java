package exam.elements.buttons;

import exam.config.FieldSizes;

import javax.swing.*;
import java.util.Arrays;

import static exam.elements.panels.Menu.*;

public class SizeSelector extends JComboBox<FieldSizes> {

    public SizeSelector() {
        Arrays.stream(FieldSizes.values()).forEach(this::addItem);
        setSelectedIndex(4);
        addActionListener(e -> {
            switch ((FieldSizes) getSelectedItem()) {
                case CUSTOM:
                    CUSTOMNSELECTORLABEL.setVisible(true);
                    CUSTOMNSELECTOR.setVisible(true);
                    CUSTOMMSELECTORLABEL.setVisible(true);
                    CUSTOMMSELECTOR.setVisible(true);
                    break;
                default:
                    CUSTOMNSELECTORLABEL.setVisible(false);
                    CUSTOMNSELECTOR.setVisible(false);
                    CUSTOMMSELECTORLABEL.setVisible(false);
                    CUSTOMMSELECTOR.setVisible(false);
                    break;
            }
        });
    }
}