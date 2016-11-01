package com.github.alexaegis.plane;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {

    private Point a;
    private final int X = 1;
    private final int Y = 2;

    @Before
    public void createPoint() {
        a = new Point(X, Y);
    }

    @Test
    public void getX() throws Exception {
        assertEquals("Impossible", a.getX(), X, 0);
    }

    @Test
    public void getY() throws Exception {
        assertEquals("Impossible", a.getY(), Y, 0);
    }

}