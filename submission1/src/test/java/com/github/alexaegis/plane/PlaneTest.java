package com.github.alexaegis.plane;

import com.github.alexaegis.plane.poligons.Polygon;
import com.github.alexaegis.plane.poligons.PolygonFactory;
import com.github.alexaegis.plane.poligons.RegularPolygons;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaneTest {

    private Plane plane;
    private Point origo;
    private Polygon a;
    private Polygon b;
    private Polygon c;


    @Before
    public void before() {
        plane = new Plane();
        origo = new Point(0, 0);
        a = PolygonFactory.getFactory().createPolygon(RegularPolygons.HEXAGON, origo, 2);
        b = PolygonFactory.getFactory().createPolygon(RegularPolygons.TETRAGON, origo, 4);
        c = PolygonFactory.getFactory().createPolygon(RegularPolygons.TRIANGLE, origo, 3);

    }

    @Test
    public void addPolygon() throws Exception {
        plane.addPolygon(a);
        plane.addPolygon(b);
        assertEquals(plane.getPolygonCount(), 2);
    }

    @Test
    public void getMostBalanced() throws Exception {
        plane.addPolygon(a);
        plane.addPolygon(b);
        plane.addPolygon(c);
        assertEquals(plane.getMostBalanced(), c);
    }

}