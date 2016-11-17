package com.github.alexaegis.logic;

import com.github.alexaegis.tiles.Tile;
import com.github.alexaegis.tiles.Pawn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import static com.github.alexaegis.Main.TILE_SIZE;
import static com.github.alexaegis.panels.GamePanel.xOffset;
import static com.github.alexaegis.panels.GamePanel.yOffset;

public class MouseControl implements MouseListener, MouseMotionListener {

    private Pawn pawn;
    private int x;
    private int y;
    private JLayeredPane game;
    private JPanel gameField;
    private Component original;
    private ArrayList<Tile> valids = new ArrayList<>();
    private int actualPlayer = 1; //starting player

    @Override
    public void mousePressed(MouseEvent e) {
        game = (JLayeredPane) e.getSource();
        gameField = (JPanel) game.getParent();
        pawn = null;
        Component c = gameField.findComponentAt(e.getX(), e.getY());
        if (c instanceof JPanel || ((Pawn)c).getPlayer() != actualPlayer) {
            return;
        }
        pawn = (Pawn)c;


        Component c1 = gameField.getParent().findComponentAt(e.getX(), e.getY() - TILE_SIZE);
        Component c2 = gameField.getParent().findComponentAt(e.getX() - TILE_SIZE, e.getY() - TILE_SIZE);
        Component c3 = gameField.getParent().findComponentAt(e.getX() + TILE_SIZE, e.getY() - TILE_SIZE);

        if(pawn.getPlayer() == 0) {
            c1 = gameField.getParent().findComponentAt(e.getX(), e.getY() + TILE_SIZE);
            c2 = gameField.getParent().findComponentAt(e.getX() - TILE_SIZE, e.getY() + TILE_SIZE);
            c3 = gameField.getParent().findComponentAt(e.getX() + TILE_SIZE, e.getY() + TILE_SIZE);
        }

        if(c1 instanceof JPanel) {
            valids.add((Tile) c1);
        } else if(c1 instanceof JLabel) {
            //valids.add((Tile) c1.getParent());  // szembe nem lépünk
        }

        if(c2 instanceof JPanel) {
            valids.add((Tile) c2);
        } else if(c2 instanceof JLabel) {
            valids.add((Tile) c2.getParent());
        }

        if(c3 instanceof JPanel) {
            valids.add((Tile) c3);
        } else if(c3 instanceof JLabel) {
            valids.add((Tile) c3.getParent());
        }

        valids.forEach(v -> {
            v.setBackground(new Color(v.getBackground().getRed(), v.getBackground().getBlue(), v.getBackground().getBlue(), 160));
            v.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        });

        original = c.getParent();

        Point parentLocation = c.getParent().getLocation();
        x = parentLocation.x - e.getX();
        y = parentLocation.y - e.getY();

        pawn.setLocation(e.getX() + x + xOffset, e.getY() + y + yOffset);

        game.add(pawn, JLayeredPane.DRAG_LAYER);
        game.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (pawn == null) {
            return;
        }
        int ix = e.getX() + this.x + xOffset;
        int xMax = game.getWidth() - pawn.getWidth();
        ix = Math.min(ix, xMax);
        ix = Math.max(ix, 0);
        int iy = e.getY() + this.y + yOffset;
        int yMax = game.getHeight() - pawn.getHeight();
        iy = Math.min(iy, yMax);
        iy = Math.max(iy, 0);
        pawn.setLocation(ix, iy);
    }

    @Override
    public void mouseReleased(MouseEvent e) {


        game.setCursor(null);

        if (pawn == null) {
            return;
        }

        pawn.setVisible(false);
        game.remove(pawn);
        pawn.setVisible(true);

        int xMax = game.getWidth() - pawn.getWidth();
        int ix = Math.min(e.getX(), xMax);
        ix = Math.max(ix, 0);

        int yMax = game.getHeight() - pawn.getHeight();
        int iy = Math.min(e.getY(), yMax);
        iy = Math.max(iy, 0);

        Component c = gameField.findComponentAt(ix, iy);

        if (c instanceof Pawn && valids.contains(c.getParent())) {
            
            
            Container parent = c.getParent();
            parent.remove(0);
            parent.add(pawn);
            parent.validate();
            switchActivePlayer(pawn);
        }
        else if(c instanceof Tile && valids.contains(c)) {
            
           
            Container parent = (Container)c;
            parent.add(pawn);
            parent.validate();
             switchActivePlayer(pawn);
            
        }
        else {
            Container parent = (Container) original;
            parent.add(pawn);
            parent.repaint();
            parent.validate();
        }

        valids.forEach(v -> {
            v.applyOriginalColor();
            v.setBorder(null);
        });
        valids.removeAll(valids);

    }
    
    private void switchActivePlayer(Pawn pawn) { // TODO labelchange not works
        actualPlayer = pawn.getOtherPlayer();
        //JLabel act = (JLabel) gameField.getParent().getComponent(2);
        //act.setText("Next player: " + Integer.toString(actualPlayer + 1));
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}