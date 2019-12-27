package uk.ac.cam.hjf42.Experiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Screw extends Symmetry{  //large lattice must be used

    private static List<String> angles = new ArrayList<String>(List.of("2-1", "3-1", "3-2", "4-1", "4-2", "4-3", "6-1", "6-2", "6-3", "6-4", "6-5"));

    protected Screw(Crystal crystal) {
        super(crystal);
    }
    public void mainScrew() {
        System.out.println("Screw axes along x: " + outputX());
        System.out.println("Screw axes along y: " + outputY());
        System.out.println("Screw axes along z: " + outputZ());
    }
    public List<String> outputX() {
        List<String> lst = new ArrayList<>();
        for (String a : angles) {
            if (check(a, 'x')) {
                lst.add(a);
            }
        }
        return lst;
    }
    public List<String> outputY() {
        List<String> lst = new ArrayList<>();
        for (String a : angles) {
            if (check(a, 'y')) {
                lst.add(a);
            }
        }
        return lst;
    }
    public List<String> outputZ() {
        List<String> lst = new ArrayList<>();
        for (String a : angles) {
            if (check(a, 'z')) {
                lst.add(a);
            }
        }
        return lst;
    }
    public boolean check(String string, char axis) {  //change to contained in large lattice
        if (this.getCrystal().getStructureL().containsAll(transform(string, axis))) {
            return true;
        }
        return false;
    }
    public List<Atom> transform(String string, char axis) {
        float c;
        float number;
        if (string == "2-1") {
            c = 180;
            number = (float) 0.5;
        }
        else if (string == "3-1") {
            c = 120;
            number = (float) 1/3;
        }
        else if (string == "3-2") {
            c = 120;
            number = (float) 2/3;
        }
        else if (string == "4-1") {
            c = 90;
            number = (float) 0.25;
        }
        else if (string == "4-2") {
            c = 90;
            number = (float) 0.5;
        }
        else if (string == "4-3") {
            c = 90;
            number = (float) 0.75;
        }
        else if (string == "6-1") {
            c = 60;
            number = (float) 1/6;
        }
        else if (string == "6-2") {
            c = 60;
            number = (float) 2/6;
        }
        else if (string == "6-3") {
            c = 60;
            number = (float) 3/6;
        }
        else if (string == "6-4") {
            c = 60;
            number = (float) 4/6;
        }
        else {
            c = 60;
            number = (float) 5/6;
        }
        List<Atom> list = new ArrayList<>();
        for (Atom a : super.getCrystal().getStructure()) {
            Coordinate value = a.getCoordinate();
            if ((value.getX() <= 1 && value.getY() <= 1 && value.getZ() <= 1)) {
                Coordinate newval = new Coordinate(value.getX(),value.getY(),value.getZ());
                if (axis == 'x') {
                    float newZ = (float) (((newval.getZ() - 0.5)*Math.cos(Math.toRadians(c)) - (newval.getY() - 0.5)*Math.sin(Math.toRadians(c))) + 0.5);
                    float newY = (float) (((newval.getZ() - 0.5)*Math.sin(Math.toRadians(c)) + (newval.getY() - 0.5)*Math.cos(Math.toRadians(c))) + 0.5);
                    float newX = (float) (newval.getX() + number);
                    if (newZ < 0.001 && newZ > -0.001) { newZ = 0;}
                    if (newY < 0.001 && newY > -0.001) { newY = 0;}
                    newval.setZ(newZ);
                    newval.setY(newY);
                    newval.setX(newX);
                }
                if (axis == 'y') {
                    float newX = (float) (((newval.getX() - 0.5)*Math.cos(Math.toRadians(c)) - (newval.getZ() - 0.5)*Math.sin(Math.toRadians(c))) + 0.5);
                    float newZ = (float) (((newval.getX() - 0.5)*Math.sin(Math.toRadians(c)) + (newval.getZ() - 0.5)*Math.cos(Math.toRadians(c))) + 0.5);
                    float newY = (float) (newval.getY() + number);
                    if (newZ < 0.001 && newZ > -0.001) { newZ = 0;}
                    if (newX < 0.001 && newX > -0.001) { newX = 0;}
                    newval.setX(newX);
                    newval.setZ(newZ);
                    newval.setY(newY);
                }
                if (axis == 'z') {
                    float newX = (float) (((newval.getX() - 0.5)*Math.cos(Math.toRadians(c)) - (newval.getY() - 0.5)*Math.sin(Math.toRadians(c))) + 0.5);
                    float newY = (float) (((newval.getX() - 0.5)*Math.sin(Math.toRadians(c)) + (newval.getY() - 0.5)*Math.cos(Math.toRadians(c))) + 0.5);
                    float newZ = (float) (newval.getZ() + number);
                    if (newX < 0.001 && newX > -0.001) { newX = 0;}
                    if (newY < 0.001 && newY > -0.001) { newY = 0;}
                    newval.setX(newX);
                    newval.setY(newY);
                    newval.setZ(newZ);
                }
                list.add(new Atom(a.getElement(), newval));
            }
        }
        return list;
    }
}