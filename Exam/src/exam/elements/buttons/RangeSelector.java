package exam.elements.buttons;

import javax.swing.*;
import java.awt.*;

class RangeSelector extends JTextField {
    RangeSelector() {
        setText("0");
        setPreferredSize(new Dimension(30, 20));
        setMinimumSize(new Dimension(30, 20));
        this.setToolTipText("RangeSelector");
        setSize(100, 30);
    }
}