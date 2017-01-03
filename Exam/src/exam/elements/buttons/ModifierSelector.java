package exam.elements.buttons;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.DEFAULT_MODIFIER_VALUE;

public class ModifierSelector extends JTextField {
    public ModifierSelector() {
        setText(Integer.toString(DEFAULT_MODIFIER_VALUE));
        setPreferredSize(new Dimension(30, 20));
        setMinimumSize(new Dimension(30, 20));
        setToolTipText("ModifierSelector");
        setSize(100, 30);
    }
}