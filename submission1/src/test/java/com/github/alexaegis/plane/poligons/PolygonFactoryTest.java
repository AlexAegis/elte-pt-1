package com.github.alexaegis.plane.poligons;

import com.github.alexaegis.plane.Point;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PolygonFactoryTest {

    @Test
    public void getFactory() throws Exception {
        assertNotNull(PolygonFactory.getFactory());
    }

    @Test
    public void createPolygon() throws Exception {
        assertNotNull(PolygonFactory.getFactory().createPolygon(RegularPolygons.CIRCLE, new Point(0, 0), 10));
    }

}