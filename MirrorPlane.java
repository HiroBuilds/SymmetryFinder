package uk.ac.cam.hjf42.Experiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MirrorPlane extends Symmetry{

    private static List<Coordinate> planes = new ArrayList<>(List.of(new Coordinate((float) 0.5, 0, 0), new Coordinate(0, (float) 0.5, 0), new Coordinate(0, 0, (float) 0.5),
            new Coordinate(0, 1, 1), new Coordinate(1, 0, 1), new Coordinate(1, 1, 0),
            new Coordinate(0, -1, 1), new Coordinate(-1, 0, 1), new Coordinate(-1, 1, 0)));

    protected MirrorPlane(Crystal crystal) {
        super(crystal);
    }
    public void output() {
        List<Coordinate> lst = new ArrayList<>();
        for (Coordinate a : planes) {
            if (check(a)) {
                lst.add(a);
            }
        }
        System.out.println("Mirror planes: " + lst);
    }
    public boolean check(Coordinate c) {
        if (this.getCrystal().getStructure().containsAll(transform(c))) {
            return true;
        }
        return false;
    }
    public List<Atom> transform(Coordinate c) {
        List<Atom> list = new ArrayList<>();
        // create plane Xx + Yy + Zz = D
        int D = 0;
        if (!(c.getX() < 0 || c.getY() < 0 || c.getZ() < 0)) { D++;}
        int X = (int) c.getX(); int Y = (int) c.getY(); int Z = (int) c.getZ();
        for (Atom a : super.getCrystal().getStructure()) {
            Coordinate value = a.getCoordinate();
            Coordinate newval = new Coordinate(value.getX(),value.getY(),value.getZ());
            Coordinate positiveC = new Coordinate(Math.abs(c.getX()), Math.abs(c.getY()),Math.abs(c.getZ()));
            if (c.equals(new Coordinate((float)0.5, 0,0)) || c.equals(new Coordinate(0, (float)0.5,0)) || c.equals(new Coordinate(0, 0,(float)0.5))) {
                if (c.getX() != 0) {newval.setX(2*c.getX()-value.getX());}
                if (c.getY() != 0) {newval.setY(2*c.getY()-value.getY());}
                if (c.getZ() != 0) {newval.setZ(2*c.getZ()-value.getZ());}
            }
            else {
                if (X*value.getX() + Y*value.getY() + Z*value.getZ() != D) { //doesn't lie on plane
                    final float t = (D - (c.getX()*value.getX() + c.getY()*value.getY() + c.getZ()*value.getZ()))/(c.getX()*c.getX() + c.getY()*c.getY() + c.getZ()*c.getZ());
                    newval.setX(value.getX() + 2*t*c.getX());
                    newval.setY(value.getY() + 2*t*c.getY());
                    newval.setZ(value.getZ() + 2*t*c.getZ());
                }
            }
            list.add(new Atom(a.getElement(), newval));

        }
        Collections.sort(list);
        return list;
    }
}
