package com.github.alexaegis;


import com.github.alexaegis.plane.Plane;
import com.github.alexaegis.plane.PlaneReader;

import java.io.File;

public class Main {

    private Main() {

    }

    public static void main(String[] args) throws Exception {
        Plane plane = new PlaneReader(new File("src\\main\\resources\\sample.txt")).getPlane();
        plane.show();
        System.out.println("\nThe one who has the least amount of difference in it's perimeter and area: ");
        plane.getMostBalanced().show();
    }
}