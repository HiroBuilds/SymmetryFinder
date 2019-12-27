package uk.ac.cam.hjf42.Experiment;

import java.util.Comparator;

public class Atom implements Comparable<Atom> {
    private final String element;
    private final Coordinate coordinate;

    public Atom(String element, Coordinate coordinate) {
        this.element = element;
        this.coordinate = coordinate;
    }

    public String getElement() {
        return element;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    @Override
    public String toString() {
        return String.format("{%s, (%s, %s, %s)}", this.element, this.coordinate.getX(), this.coordinate.getY(), this.coordinate.getZ());
    }
    @Override
    public boolean equals(Object o) {
        Atom a = (Atom)o;
        if (a.getElement() == this.getElement() && a.getCoordinate().equals(this.coordinate)) { return true;}
        return false;
    }

    @Override
    public int compareTo(Atom atom) {
        return this.getCoordinate().compareTo(atom.coordinate);
    }
}
