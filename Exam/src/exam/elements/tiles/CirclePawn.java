package exam.elements.tiles;

import java.awt.*;

public class CirclePawn extends Pawn{

    public CirclePawn(Color color, int player, int width, int height) {
        this.width = width;
        this.height = height;
        this.player = player;
        this.padding = ((width + height) / 2) / 16;
        setLayout(new BorderLayout());
        colors = new Color[]{color, new Color(255,255,255,200)};
        dist = new float[]{0.2f, 1f};
        paint = new RadialGradientPaint(width / 2, height / 2,width, dist, colors);
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
    }

    public CirclePawn(Color color, int player, Dimension dimension) {
        this(color, player, (int) dimension.getWidth(), (int) dimension.getHeight());
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        paint = new RadialGradientPaint(width / 2, height / 2,width, dist, colors);
        g.setPaint(paint);
        g.fillOval(padding, padding, height - padding, width - padding);
    }
}
