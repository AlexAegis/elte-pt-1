package exam.tiles;

import sun.rmi.server.InactiveGroupException;

import javax.swing.*;
import java.awt.*;

public class Tile extends JComponent {

    private float[] dist = {0.08f, 1f};
    private int width;
    private int height;
    private Paint paint;
    private int no;

    public Tile(Color color, int width, int height) {
        this.height = height;
        this.width = width;
        setLayout(new BorderLayout());
        Color[] colors = {color, new Color(255,255,255,200)};
        paint = new RadialGradientPaint(width / 2, height / 2,40 * 5, dist, colors);
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
    }

    public Tile(Color color, int width, int height, int no) {
        this(color, width, height);
        this.no = no;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        int fontSize = 10;

        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(paint);
        g.fillRect(0,0, width, height);
        g.setPaint(Color.DARK_GRAY);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, fontSize));
        g.drawString(Integer.toString(no), width - fontSize * 2, fontSize);
    }
}