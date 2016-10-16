package com.github.alexaegis.plane.poligons;

import com.github.alexaegis.plane.Point;

class Circle extends RegularPolygon {

    Circle(Point center, double radius) {
        type = RegularPolygons.CIRCLE;
        this.center = center;
        this.radius = radius;
        apothem = radius;
        perimeter = 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

}