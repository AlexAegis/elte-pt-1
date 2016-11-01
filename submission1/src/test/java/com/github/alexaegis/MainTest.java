package com.github.alexaegis;

import com.github.alexaegis.plane.Plane;
import com.github.alexaegis.plane.PlaneReader;
import com.github.alexaegis.plane.Point;
import com.github.alexaegis.plane.poligons.Polygon;
import com.github.alexaegis.plane.poligons.PolygonFactory;
import com.github.alexaegis.plane.poligons.RegularPolygons;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {

    Plane plane;

    @Test
    public void MainTest() throws Exception {
        plane = new PlaneReader(new File("src\\main\\resources\\sample.txt")).getPlane();
        assertEquals(plane.getMostBalanced().toString(),
                PolygonFactory.getFactory().createPolygon(RegularPolygons.TETRAGON, new Point(-2, 4), 2).toString());
    }
}