package exam.elements.buttons;

import javax.swing.*;
import java.awt.*;

public class CloseButton extends JButton {

    private String name = "Exit";

    public CloseButton() {
        setText(name);
        setPreferredSize(new Dimension(80, 40));
        addActionListener(e -> System.exit(0));
    }
}