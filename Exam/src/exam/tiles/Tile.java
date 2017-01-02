package exam.tiles;

import javax.swing.*;
import java.awt.*;

public class Tile extends JComponent {

    private float[] dist = {0.08f, 1f};
    private int width;
    private int height;
    private Paint paint;

    public Tile(Color color, int width, int height) {
        this.height = height;
        this.width = width;
        setLayout(new BorderLayout());
        Color[] colors = {color, new Color(255,255,255,200)};
        paint = new RadialGradientPaint(width / 2, height / 2,40 * 5, dist, colors);
        setPreferredSize(new Dimension(width, height));
        setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(paint);
        g.fillRect(0,0, width, height);
    }

}