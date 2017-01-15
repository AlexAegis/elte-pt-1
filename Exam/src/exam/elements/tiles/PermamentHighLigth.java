package exam.elements.tiles;

import java.awt.*;

public class PermamentHighLigth extends HighLight {

    public PermamentHighLigth(int width, int height) {
        super(width, height);
        switchToCold();
    }

    public PermamentHighLigth(Dimension dimension) {
        this((int) dimension.getWidth(), (int) dimension.getHeight());
    }

}