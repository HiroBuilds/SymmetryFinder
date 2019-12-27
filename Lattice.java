package uk.ac.cam.hjf42.Experiment;

import java.util.ArrayList;
import java.util.List;

public class Lattice {

    private final char identity;

    public Lattice(char identity) {
        this.identity = identity;
    }

    public List<Coordinate> points() {
        if (identity == 'P') {
            List<Coordinate> points = new ArrayList<Coordinate>();
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    for(int k = 0; k < 2; k++) {
                        points.add(new Coordinate(i, j, k));
                    }
                }
            }
            return points;
        }
        if (identity == 'I') {
            List<Coordinate> points = new ArrayList<Coordinate>();
            for(int i = 0; i < 2; i++) {
                for(int j = 0; j < 2; j++) {
                    for(int k = 0; k < 2; k++) {
                        points.add(new Coordinate(i, j, k));
                    }
                }
            }
            points.add(new Coordinate(0.5f, 0.5f,0.5f));
            return points;
        }
        if (identity == 'F') {
            List<Coordinate> points = new ArrayList<Coordinate>();
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    for(int k = 0; k < 4; k++) {
                        points.add(new Coordinate(i, j, k));
                    }
                }
            }
            points.add(new Coordinate(0.5f, 0.5f, 0));
            points.add(new Coordinate(0.5f, 0, 0.5f));
            points.add(new Coordinate(0, 0.5f, 0.5f));
            points.add(new Coordinate(0.5f, 0.5f, 1f));
            points.add(new Coordinate(0.5f, 1, 0.5f));
            points.add(new Coordinate(1, 0.5f, 0.5f));
            return points;
        }
        return null;
    }
    public List<Coordinate> pointsL() {
        if (identity == 'P') {
            List<Coordinate> points = new ArrayList<Coordinate>();
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    for(int k = 0; k < 4; k++) {
                        points.add(new Coordinate(i, j, k));
                    }
                }
            }
            return points;
        }
        if (identity == 'I') {
            List<Coordinate> points = new ArrayList<Coordinate>();
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    for(int k = 0; k < 4; k++) {
                        points.add(new Coordinate(i, j, k));
                        points.add(new Coordinate(i + 0.5f, j + 0.5f, k + 0.5f));
                    }
                }
            }
            return points;
        }
        if (identity == 'F') {
            List<Coordinate> points = new ArrayList<Coordinate>();
            for(int i = 0; i < 4; i++) {
                for(int j = 0; j < 4; j++) {
                    for(int k = 0; k < 4; k++) {
                        points.add(new Coordinate(i, j, k));
                        points.add(new Coordinate(i + 0.5f, j + 0.5f, k));
                        points.add(new Coordinate(i + 0.5f, j, k + 0.5f));
                        points.add(new Coordinate(i, j + 0.5f, k + 0.5f));
                    }
                }
            }
            return points;
        }
        return null;
    }
}