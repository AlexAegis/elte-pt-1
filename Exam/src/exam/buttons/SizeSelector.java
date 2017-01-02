package exam.buttons;


import exam.logic.FieldSize;

import javax.swing.*;
import java.util.Arrays;

public class SizeSelector extends JComboBox<FieldSize> {

    public SizeSelector() {
        Arrays.stream(FieldSize.values()).forEach(this::addItem);
        setSelectedIndex(0);
    }
}