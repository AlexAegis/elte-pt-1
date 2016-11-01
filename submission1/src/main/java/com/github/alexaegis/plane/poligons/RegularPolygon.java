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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegularPolygon that = (RegularPolygon) o;

        if (Double.compare(that.edgeLength, edgeLength) != 0) return false;
        if (Double.compare(that.radius, radius) != 0) return false;
        if (Double.compare(that.apothem, apothem) != 0) return false;
        if (Double.compare(that.perimeter, perimeter) != 0) return false;
        if (type != that.type) return false;
        if (center != null ? !center.equals(that.center) : that.center != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = type != null ? type.hashCode() : 0;
        result = 31 * result + (center != null ? center.hashCode() : 0);
        temp = Double.doubleToLongBits(edgeLength);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(radius);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(apothem);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perimeter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}