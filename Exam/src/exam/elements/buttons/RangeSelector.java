package exam.elements.buttons;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.DEFAULT_DIFFICULTY;

public class RangeSelector extends JTextField {
    public RangeSelector() {
        setText(DEFAULT_DIFFICULTY);
        setPreferredSize(new Dimension(30, 20));
        setMinimumSize(new Dimension(30, 20));
        this.setToolTipText("RangeSelector");
        setSize(100, 30);
    }
}