package com.github.alexaegis.plane.poligons;

import com.github.alexaegis.plane.Point;

public class PolygonFactory {

    private static PolygonFactory instance;

    private PolygonFactory() {

    }

    public static PolygonFactory getFactory() {
        if (instance == null) {
            synchronized(PolygonFactory.class) {
                if (instance == null) {
                    instance = new PolygonFactory();
                }
            }
        }
        return instance;
    }

    public Polygon createPolygon(RegularPolygons type, Point center, double radius) {
        if(radius > 0d) {
            switch (type) {
                case CIRCLE: return new Circle(center, radius);
                case TRIANGLE: return new RegularTriangle(center, radius);
                case TETRAGON: return new RegularTetragon(center, radius);
                case HEXAGON: return new RegularHexagon(center, radius);
                default: return null;
            }
        } else throw new IllegalArgumentException("Can't create polygon with 0 radius");
    }
}
