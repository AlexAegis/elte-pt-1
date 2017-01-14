package exam.elements.tiles;

import java.awt.*;

public class Shade extends Pawn {

    private static Color shadeColor = new Color(60, 60, 60, 191);

    public Shade(Color color, int player, int width, int height) {
        super(color, player, width, height);
    }

    public Shade(int width, int height) {
        super(shadeColor, 0, width, height);
    }
}
