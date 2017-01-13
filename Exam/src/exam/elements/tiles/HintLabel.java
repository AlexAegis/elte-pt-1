package exam.elements.tiles;

import javax.swing.*;

public class HintLabel extends JLabel {

    private int correctColors = 0;
    private int correctPlaces = 0;


    public HintLabel() {
        setText(toString());
    }

    @Override
    public String toString() {
        return "Colors: " + correctColors +
                "Places: " + correctPlaces;
    }
}
