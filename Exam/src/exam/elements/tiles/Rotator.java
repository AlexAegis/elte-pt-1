package exam.elements.tiles;

import exam.config.ArrowFactory;
import exam.config.ResizeableElement;
import exam.logic.abstraction.Directions;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static exam.config.Config.ANTI_ALIASING;

public class Rotator extends JComponent implements ResizeableElement, MouseListener {

    private Timer timer;
    private Directions direction;
    private int width;
    private int height;

    private int deltaX = 0;
    private int deltaY = 0;

    private Color backGroundColor = new Color(255,255,255,255);
    private Color directionColor = new Color(0,0,0,255);


    public Rotator(Directions direction, int width, int height) {
        this.direction = direction;
        this.width = width;
        this.height = height;
        addMouseListener(this);
    }

    public Rotator(Directions direction, Dimension dimension) {
        this(direction, (int) dimension.getWidth(), (int) dimension.getHeight());
    }

    public void changeDirection(Directions direction) {
        this.direction = direction;
        revalidate();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ((Graphics2D) g).setPaint(backGroundColor);
        if(ANTI_ALIASING) ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.fillRect(0, 0, height, width);
        g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, (int) (Math.min(height, width) * 0.2)));
        ((Graphics2D) g).setPaint(directionColor);
        switch (direction) {
            case UP:
                Polygon up = ArrowFactory.getFactory().createUpArrow(width, height);
                up.translate(deltaX, deltaY);
                g.fillPolygon(up);
                break;
            case RIGHT:
                Polygon right = ArrowFactory.getFactory().createRightArrow(width, height);
                right.translate(deltaX, deltaY);
                g.fillPolygon(right);
                break;
            case DOWN:
                Polygon down = ArrowFactory.getFactory().createDownArrow(width, height);
                down.translate(deltaX, deltaY);
                g.fillPolygon(down);
                break;
            case LEFT:
                Polygon left = ArrowFactory.getFactory().createLeftArrow(width, height);
                left.translate(deltaX, deltaY);
                g.fillPolygon(left);
                break;
            case UPLEFT:
                Polygon upLeft = ArrowFactory.getFactory().createUpArrow(width, height);
                Polygon leftUp = ArrowFactory.getFactory().createLeftArrow(width, height);
                upLeft.translate(deltaX, deltaY);
                leftUp.translate(deltaX, deltaY);
                g.fillPolygon(upLeft);
                g.fillPolygon(leftUp);
                break;
            case UPRIGHT:
                Polygon upRight = ArrowFactory.getFactory().createUpArrow(width, height);
                Polygon rightUp = ArrowFactory.getFactory().createRightArrow(width, height);
                upRight.translate(deltaX, deltaY);
                rightUp.translate(deltaX, deltaY);
                g.fillPolygon(upRight);
                g.fillPolygon(rightUp);
                break;
            case DOWNLEFT:
                Polygon downLeft = ArrowFactory.getFactory().createDownArrow(width, height);
                Polygon leftDown = ArrowFactory.getFactory().createLeftArrow(width, height);
                downLeft.translate(deltaX, deltaY);
                leftDown.translate(deltaX, deltaY);
                g.fillPolygon(downLeft);
                g.fillPolygon(leftDown);
                break;
            case DOWNRIGHT:
                Polygon downRight = ArrowFactory.getFactory().createDownArrow(width, height);
                Polygon rightDown = ArrowFactory.getFactory().createRightArrow(width, height);
                downRight.translate(deltaX, deltaY);
                rightDown.translate(deltaX, deltaY);
                g.fillPolygon(downRight);
                g.fillPolygon(rightDown);
                break;
            default:
                g.fillPolygon(ArrowFactory.getFactory().createDownArrow(width, height));
                g.fillPolygon(ArrowFactory.getFactory().createLeftArrow(width, height));
                g.fillPolygon(ArrowFactory.getFactory().createUpArrow(width, height));
                g.fillPolygon(ArrowFactory.getFactory().createRightArrow(width, height));
                break;
        }
    }

    @Override
    public void onResize() {
        setSize(getParent().getSize());
        width = getParent().getWidth();
        height = getParent().getHeight();
        revalidate();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        final int[] dir = {1};
        timer = new Timer(40, a -> {
            if(deltaX > width / 4
                    || deltaX < 0 - width / 4
                    || deltaY > height / 4
                    || deltaY < 0 - height / 4) {
                dir[0] = 0 - dir[0];
            }
            if (direction.equals(Directions.LEFT)) {
                deltaX -= (width / 20) * dir[0];
            } else if (direction.equals(Directions.RIGHT)) {
                deltaX += (width / 20) * dir[0];
            } else if (direction.equals(Directions.UP)) {
                deltaY -= (height / 20) * dir[0];
            } else if (direction.equals(Directions.DOWN)) {
                deltaY += (height / 20) * dir[0];
            }
            revalidate();
            repaint();
        });
        timer.start();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        timer.stop();
        deltaX = 0;
        deltaY = 0;
        revalidate();
        repaint();
    }
}
