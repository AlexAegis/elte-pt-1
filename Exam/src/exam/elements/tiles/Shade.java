package exam.elements.tiles;

import java.awt.*;

public class Shade extends Pawn {

    private static Color shadeColor = new Color(60, 60, 60, 191);

    public Shade(Color color, int player, int width, int height) {
        super(color, player, width, height);
    }

    public Shade(Color color, int player,  Dimension dimension) {
        super(color, player, dimension);
    }

    public Shade(int width, int height) {
        super(shadeColor, 0, width, height);
    }

    public Shade(Dimension dimension) {
        super(shadeColor, 0, dimension);
    }
}