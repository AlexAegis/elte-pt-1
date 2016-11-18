package com.github.alexaegis.logic;

import com.github.alexaegis.tiles.HightLight;
import com.github.alexaegis.tiles.Tile;
import com.github.alexaegis.tiles.Pawn;
import com.sun.xml.internal.ws.api.ha.HaInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

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
        if (c instanceof Tile || ((Pawn)c).getPlayer() != actualPlayer) {
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

        if(c1 instanceof Tile) {
            valids.add((Tile) c1);
        } else if(c1 instanceof Pawn) {
            //valids.add((Tile) c1.getParent());  // szembe nem lépünk
        }

        if(c2 instanceof Tile) {
            valids.add((Tile) c2);
        } else if(c2 instanceof Pawn) {
            valids.add((Tile) c2.getParent());
        }

        if(c3 instanceof Tile) {
            valids.add((Tile) c3);
        } else if(c3 instanceof Pawn) {
            valids.add((Tile) c3.getParent());
        }


        valids.forEach(v ->
                v.add(new HightLight()));

        original = c.getParent();

        Point parentLocation = c.getParent().getLocation();
        x = parentLocation.x - e.getX();
        y = parentLocation.y - e.getY();

        pawn.setLocation(e.getX() + x + xOffset, e.getY() + y + yOffset);

        game.add(pawn, JLayeredPane.DRAG_LAYER);
        game.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));

        game.revalidate();
        game.repaint();
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

        valids.stream().flatMap(valid -> Stream.of(valid.getComponents()))
                .filter(component -> component instanceof HightLight)
                .forEach(highLight -> highLight.getParent().remove(highLight));

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

        }else if(c instanceof HightLight) {
            Container parent = c.getParent();
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


/*
        valids.forEach(v -> {
            /*System.out.println(v);
            System.out.println("COMP0" + v.getComponent(0));
            System.out.println("PARENT" + v.getParent());
            if(Arrays.stream(v.getComponents()).allMatch(component -> component instanceof HightLight)) {

            }
            if(v.getComponent(0) instanceof HightLight) {
                v.remove(v.getComponent(0));
            } else if(v.getComponent(0) instanceof Pawn) {

                System.out.println("COMP0" + v.getComponent(0));

                v.remove(v.getComponent(1));
            }
        });*/
        valids.clear();

        game.revalidate();
        game.repaint();

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