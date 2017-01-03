package exam.elements.buttons;

import javax.swing.*;
import java.awt.*;

public class CloseButton extends JButton {
    public CloseButton() {
        setText("Exit");
        setPreferredSize(new Dimension(80, 40));
        addActionListener(e -> System.exit(0));
    }
}