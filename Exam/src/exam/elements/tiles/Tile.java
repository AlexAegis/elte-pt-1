package exam.elements.tiles;

import exam.config.ResizeableElement;
import exam.elements.panels.Grid;
import exam.logic.abstraction.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static exam.config.Config.ANTI_ALIASING;
import static exam.config.Config.DEBUG_MODE;

public class Tile extends JComponent implements ResizeableElement {

    private int width;
    private int height;
    private Coordinate coordinate;
    private Component child;
    private Color[] colors;
    private float[] dist;

    public Tile() {
    }

    public Tile(Color color, int width, int height) {
        this.height = height;
        this.width = width;
        setLayout(new BorderLayout());
        colors = new Color[]{color, new Color(255,255,255,200)};
        dist = new float[]{0.08f, 1f};
        setPreferredSize(new Dimension(width, height));
        EventQueue.invokeLater(this::onResize);
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
        g.setPaint(new RadialGradientPaint(width / 2, height / 2,width * 3, dist, colors));
        g.fillRect(0,0, height, width);
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
        try{ child.getParent().remove(child);
        } catch (NullPointerException ignored) {}
        child = null;
        return component;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public void onResize() {
        this.height = ((Grid)getParent()).getTileWidthByPixels();
        this.width =((Grid)getParent()).getTileHeightByPixels();
        setPreferredSize(new Dimension(width, height));
        setSize(width, height);
        revalidate();
        repaint();
    }

    public boolean gotChild() {
        return child != null;
    }

    @Override
    public String toString() {
        return "Tile: " + coordinate.toString() +
                "child=" + child.toString() +
                '}';
    }
}