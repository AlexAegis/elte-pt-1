package com.github.alexaegis.plane.poligons;


import com.github.alexaegis.plane.Point;

public interface Polygon {

    double getArea();

    double getPerimeter();

    Point getCenter();

    void show();

    double diffInPerimArea();

}