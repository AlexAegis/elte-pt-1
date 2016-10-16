package com.github.alexaegis.plane;

import com.github.alexaegis.plane.poligons.exceptions.NoSuchPolygonException;
import com.github.alexaegis.plane.poligons.Polygon;

import java.util.ArrayList;
import java.util.List;

public class Plane {

    private List<Polygon> polygons;
    private int polygonCount;

    public Plane() {
        polygons = new ArrayList<>();
    }

    public void addPolygon(Polygon polygon) {
        polygons.add(polygon);
    }

    public void setPolygonCount(int polygonCount) {
        this.polygonCount = polygonCount;
    }

    public int getPolygonCount() {
        return polygonCount;
    }

    public void show() {
        polygons.forEach(Polygon::show);
    }

    public Polygon getMostBalanced() throws NoSuchPolygonException {
        return polygons.stream().min((a, b) -> {
            if(a.diffInPerimArea() < b.diffInPerimArea()) return -1;
            else if(a.diffInPerimArea() > b.diffInPerimArea()) return 1;
            else return 0;
        }).orElseThrow(() -> new NoSuchPolygonException("The plane is empty"));
    }
}