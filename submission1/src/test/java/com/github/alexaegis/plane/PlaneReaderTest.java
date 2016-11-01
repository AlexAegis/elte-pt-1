package com.github.alexaegis.plane;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.*;

public class PlaneReaderTest {

    private Plane plane;

    @Test
    public void getPlane() throws Exception {
        plane = new PlaneReader(new File("src\\main\\resources\\sample.txt")).getPlane();
        assertNotNull(plane);
    }

    @Test(expected = FileNotFoundException.class)
    public void fileNotFoundTest() throws Exception {
        plane = new PlaneReader(new File("nonexistinglocation")).getPlane();
    }

}