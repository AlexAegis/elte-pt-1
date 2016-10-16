package com.github.alexaegis.plane.poligons;

import com.github.alexaegis.plane.Point;

public abstract class RegularPolygon implements Polygon {

    protected RegularPolygons type = null;
    protected Point center = new Point(0, 0);
    protected double edgeLength = 0;        // length of the edges
    protected double radius = 0;            // the radius of the circumscribed circle
    protected double apothem = 0; // the radius of the inscribed circle
    protected double perimeter = 0;

    RegularPolygon() {

    }

    @Override
    public double getArea() {
        return 0.5d * apothem * perimeter;
    }

    @Override
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public Point getCenter() {
        return new Point(center);
    }

    @Override
    public double diffInPerimArea() {
        return Math.abs(getArea() - getPerimeter());
    }

    @Override
    public void show() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Regular Polygon{" +
                "type = " + type.getName() +
                ", vertices = " + Integer.toString(type.getVertices() - 1) +
                ", center = " + center.toString() +
                ", edgeLength = " + edgeLength +
                ", radius = " + radius +
                ", apothem = " + apothem +
                ", area = " + getArea() +
                ", perimeter = " + perimeter +
                '}';
    }
}