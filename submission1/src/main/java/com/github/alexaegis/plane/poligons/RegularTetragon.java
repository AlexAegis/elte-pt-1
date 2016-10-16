package com.github.alexaegis.plane.poligons;

import com.github.alexaegis.plane.Point;

class RegularTetragon extends RegularPolygon {

    RegularTetragon(Point center, double radius) {
        type = RegularPolygons.TETRAGON;
        this.center = center;
        this.radius = radius;
        apothem = Math.sin(Math.toRadians(type.getVertexAngle() / 2)) * radius;
        edgeLength = radius * radius / apothem * apothem;
        perimeter = edgeLength * (type.getVertices() - 1);
    }
}