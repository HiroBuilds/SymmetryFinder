package uk.ac.cam.hjf42.Experiment;

import com.sun.jdi.Mirror;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.CheckedOutputStream;

@RunWith(JUnit4.class)
public class FibonacciTest {

    @Test
    public void fibonacci_returns1_for1() {
        // ARRANGE
        Crystal crystal = new Crystal(List.of(new Atom("Fe", new Coordinate(0,0,0))), new Lattice('P'));
        MirrorPlane plane = new MirrorPlane(crystal);
        System.out.println(plane.transform(new Coordinate((float) 0.5,0,0)));
        System.out.println(crystal.getStructure());

    }
}

        // ASSERT


