package exam.controllers;


import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseController implements MouseMotionListener {

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("DRAG");
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
