package com.github.alexaegis.plane.poligons;

import com.github.alexaegis.plane.Point;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegularTriangleTest {

    private Polygon a;
    private Point origo;

    @Before
    public void before() {
        origo = new Point(0, 0);
        a = PolygonFactory.getFactory().createPolygon(RegularPolygons.TRIANGLE, origo, 3);
    }

    @Test
    public void areaTest() {
        assertEquals(a.getArea(), 23.382685902179844d, 0);
    }

    @Test
    public void perimeterTest() {
        assertEquals(a.getPerimeter(), 18, 0);
    }

    @Test
    public void differenceTest() {
        assertEquals(Math.abs(a.getPerimeter() - a.getArea()), a.diffInPerimArea(), 0);
    }
}