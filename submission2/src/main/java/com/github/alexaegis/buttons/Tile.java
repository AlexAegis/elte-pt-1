package com.github.alexaegis.buttons;

import com.github.alexaegis.Main;

import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.GraphicsEnvironment;


public class Tile extends Component implements DragGestureListener, DragSourceListener {

    private static final int TILE_SIZE = Integer.parseInt(Main.getProps().getProperty("tile_size"));

    private DragSource dragSource;

    public Tile() {
        setPreferredSize(new Dimension(TILE_SIZE, TILE_SIZE));
        setMinimumSize(new Dimension(TILE_SIZE, TILE_SIZE));
        setMaximumSize(new Dimension(TILE_SIZE, TILE_SIZE));
        setBackground(Color.black);
        setVisible(true);



        dragSource = new DragSource();
        dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
    }

    public void dragGestureRecognized(DragGestureEvent evt) {
        Transferable t = new StringSelection("aString");
        dragSource.startDrag(evt, DragSource.DefaultCopyDrop, t, this);
    }

    public void dragEnter(DragSourceDragEvent evt) {
        System.out.println("enters");
    }

    public void dragOver(DragSourceDragEvent evt) {

        System.out.println("over");
    }

    public void dragExit(DragSourceEvent evt) {
        System.out.println("leaves");
    }

    public void dropActionChanged(DragSourceDragEvent evt) {
        System.out.println("changes the drag action between copy or move");
    }

    public void dragDropEnd(DragSourceDropEvent evt) {
        System.out.println("finishes or cancels the drag operation");
    }
}