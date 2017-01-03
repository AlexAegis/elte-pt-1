package exam.elements.buttons;

import javax.swing.*;
import java.awt.*;

public class RangeSelector extends JTextField {

    public RangeSelector() {
        setText("0");
        setPreferredSize(new Dimension(30, 20));
        setMinimumSize(new Dimension(30, 20));
        this.setToolTipText("RangeSelector");
        setSize(100, 30);
    }
}