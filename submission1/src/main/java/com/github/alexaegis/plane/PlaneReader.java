package com.github.alexaegis.plane;

import com.github.alexaegis.plane.poligons.exceptions.NoSuchPolygonException;
import com.github.alexaegis.plane.poligons.PolygonFactory;
import com.github.alexaegis.plane.poligons.RegularPolygons;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.github.alexaegis.plane.poligons.RegularPolygons.isPolygon;

public class PlaneReader {

    private Plane plane;

    public PlaneReader(File file) throws FileNotFoundException {
        plane = new Plane();
        read(file);
    }

    private void read(File file) throws FileNotFoundException {
        try(Scanner scanner = new Scanner(file)) {
            plane.setPolygonCount(scanner.nextInt());
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                try(Scanner line = new Scanner(scanner.nextLine())) {
                    String name = line.next();
                    List<Integer> params = new ArrayList<>();
                    line.forEachRemaining(e -> params.add(Integer.valueOf(e)));
                    if(isPolygon(name) && params.size() == 3) {
                        plane.addPolygon(PolygonFactory.getFactory().createPolygon(
                                RegularPolygons.getByName(name),
                                new Point((double) params.get(0), (double) params.get(1)),
                                params.get(2)));
                    }
                } catch (NoSuchPolygonException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Plane getPlane() {
        return plane;
    }
}