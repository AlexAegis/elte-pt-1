package exam.elements.tiles;

import exam.logic.abstraction.Coordinate;

import javax.swing.*;
import java.awt.*;

import static exam.config.Config.ANTI_ALIASING;
import static exam.config.Config.DEBUG_MODE;

public class Tile extends JComponent {

    private int width;
    private int height;
    private Paint paint;
    private Coordinate coordinate;
    private Component child;

    public Tile() {
    }

    public Tile(Color color, int width, int height) {
        this.height = height;
        this.width = width;
        setLayout(new BorderLayout());
        Color[] colors = {color, new Color(255,255,255,200)};
        float[] dist = {0.08f, 1f};
        paint = new RadialGradientPaint(width / 2, height / 2,40 * 5, dist, colors);
        setPreferredSize(new Dimension(width, height));
        setVisible(true);
    }

    public Tile(Color color, int width, int height, Coordinate coordinate) {
        this(color, width, height);
        this.coordinate = coordinate;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g = (Graphics2D) graphics;
        int fontSize = 10;
        if(ANTI_ALIASING) g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setPaint(paint);
        g.fillRect(0,0, width, height);
        g.setPaint(Color.DARK_GRAY);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, fontSize));
        if(DEBUG_MODE) g.drawString(coordinate.toString(), width - fontSize * 4, fontSize);
    }

    public Component getChild() {
        return child;
    }

    public void setChild(Component child) {
        if(this.child == null) {
            add(child);
            this.child = child;
        } else { // maybe throw something
            System.out.println("Remove child before attempting to add a new");
        }
    }

    public Component removeChild() {
        Component component = child;
        child.getParent().remove(child);
        child = null;
        return component;
    }
}