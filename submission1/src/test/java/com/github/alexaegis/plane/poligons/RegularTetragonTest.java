package com.github.alexaegis.plane.poligons;

import com.github.alexaegis.plane.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularTetragonTest {

    private Polygon a;
    private Point origo;

    @Before
    public void before() {
        origo = new Point(0, 0);
        a = PolygonFactory.getFactory().createPolygon(RegularPolygons.TETRAGON, origo, 3);
    }

    @Test
    public void areaTest() {
        assertEquals(a.getArea(), 28.63782463805517d, 0);
    }

    @Test
    public void perimeterTest() {
        assertEquals(a.getPerimeter(), 27, 0);
    }

    @Test
    public void differenceTest() {
        assertEquals(Math.abs(a.getPerimeter() - a.getArea()), a.diffInPerimArea(), 0);
    }
}