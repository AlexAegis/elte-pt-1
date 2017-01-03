package exam.elements.buttons;

import exam.config.FieldSizes;

import javax.swing.*;
import java.util.Arrays;

public class SizeSelector extends JComboBox<FieldSizes> {

    public SizeSelector() {
        Arrays.stream(FieldSizes.values()).forEach(this::addItem);
        setSelectedIndex(0);
    }
}