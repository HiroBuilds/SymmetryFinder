package uk.ac.cam.hjf42.Experiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rotation extends Symmetry{

    private static List<Float> angles = new ArrayList<Float>(List.of((float)180, (float)120, (float)90, (float)60));

    protected Rotation(Crystal crystal) {
        super(crystal);
    }
    public void mainRotation() {
        System.out.println("Rotation angles along x axis: " + outputX());
        System.out.println("Rotation angles along y axis: " + outputY());
        System.out.println("Rotation angles along z axis: " + outputZ());
    }
    public List<Float> outputX() {
        List<Float> lst = new ArrayList<>();
        for (float a : angles) {
            if (check(a, 'x')) {
                lst.add(a);
            }
        }
        return lst;
    }
    public List<Float> outputY() {
        List<Float> lst = new ArrayList<>();
        for (float a : angles) {
            if (check(a, 'y')) {
                lst.add(a);
            }
        }
        return lst;
    }
    public List<Float> outputZ() {
        List<Float> lst = new ArrayList<>();
        for (float a : angles) {
            if (check(a, 'z')) {
                lst.add(a);
            }
        }
        return lst;
    }
    public boolean check(Float c, char axis) {
        if (this.getCrystal().getStructure().containsAll(transform(c, axis))) {
            return true;
        }
        return false;
    }
    public List<Atom> transform(Float c, char axis) {
        List<Atom> list = new ArrayList<>();
        for (Atom a : super.getCrystal().getStructure()) {
            Coordinate value = a.getCoordinate();
            if ((value.getX() <= 1 && value.getY() <= 1 && value.getZ() <= 1)) {
                Coordinate newval = new Coordinate(value.getX(),value.getY(),value.getZ());
                if (axis == 'x') {
                    float newZ = (float) (((newval.getZ() - 0.5)*Math.cos(Math.toRadians(c)) - (newval.getY() - 0.5)*Math.sin(Math.toRadians(c))) + 0.5);
                    float newY = (float) (((newval.getZ() - 0.5)*Math.sin(Math.toRadians(c)) + (newval.getY() - 0.5)*Math.cos(Math.toRadians(c))) + 0.5);
                    if (newZ < 0.001 && newZ > -0.001) { newZ = 0;}
                    if (newY < 0.001 && newY > -0.001) { newY = 0;}
                    newval.setZ(newZ);
                    newval.setY(newY);
                }
                if (axis == 'y') {
                    float newX = (float) (((newval.getX() - 0.5)*Math.cos(Math.toRadians(c)) - (newval.getZ() - 0.5)*Math.sin(Math.toRadians(c))) + 0.5);
                    float newZ = (float) (((newval.getX() - 0.5)*Math.sin(Math.toRadians(c)) + (newval.getZ() - 0.5)*Math.cos(Math.toRadians(c))) + 0.5);
                    if (newX < 0.001 && newX > -0.001) { newX = 0;}
                    if (newZ < 0.001 && newZ > -0.001) { newZ = 0;}
                    newval.setX(newX);
                    newval.setZ(newZ);
                }
                if (axis == 'z') {
                    float newX = (float) (((newval.getX() - 0.5)*Math.cos(Math.toRadians(c)) - (newval.getY() - 0.5)*Math.sin(Math.toRadians(c))) + 0.5);
                    float newY = (float) (((newval.getX() - 0.5)*Math.sin(Math.toRadians(c)) + (newval.getY() - 0.5)*Math.cos(Math.toRadians(c))) + 0.5);
                    if (newX < 0.001 && newX > -0.001) { newX = 0;}
                    if (newY < 0.001 && newY > -0.001) { newY = 0;}
                    newval.setX(newX);
                    newval.setY(newY);
                }
                list.add(new Atom(a.getElement(), newval));
            }
        }
        return list;
    }
}
