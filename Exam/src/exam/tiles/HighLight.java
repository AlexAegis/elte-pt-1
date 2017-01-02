package exam.tiles;

import javax.swing.*;
import java.awt.*;

public final class HighLight extends JComponent {
    private int width;
    private int height;

    public HighLight(int width, int height) {
        this.width = width;
        this.height = height;
        setLayout(new BorderLayout());
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        float[] dist = {0.0f, 1.0f};
        Color[] colors = {new Color(255, 255, 255, 180), new Color(255, 255, 255, 120)};
        g.setPaint(new RadialGradientPaint(width / 2, height / 2, width * 2, dist, colors ));
        g.fillRect(0,0, width, height);
        g.setColor(new Color(0, 0, 0, 5));
        g.fillRect(width / 20 , height/ 20, width -  height / 10, height - width / 10);
    }
}