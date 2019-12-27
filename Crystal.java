package uk.ac.cam.hjf42.Experiment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Crystal {
    public final List<Atom> motif;
    public final Lattice lattice;


    public Crystal(List<Atom> motif, Lattice lattice) {
        this.motif = motif;
        this.lattice = lattice;
    }

    public List<Atom> getStructure() {
        List<Atom> structure = new ArrayList<>();
        Lattice lattice = this.lattice;
        for (Coordinate p : lattice.points()) {
            for (Atom atom : motif) {
                if (atom.getCoordinate().getX() + p.getX() <= 1 && atom.getCoordinate().getY() + p.getY() <= 1 && atom.getCoordinate().getZ() + p.getZ() <= 1) {
                    structure.add(new Atom(atom.getElement(),
                            new Coordinate(atom.getCoordinate().getX() + p.getX(), atom.getCoordinate().getY() + p.getY(), atom.getCoordinate().getZ() + p.getZ())));
                    // for each coordinate point, for each atom in the motif, makes a new list with a new atom with identity of motif atom and coordinate of sum of lattice and atom coordinate
                }
            }
        }
        return structure;
    }
    public List<Atom> getStructureL() {
        List<Atom> structure = new ArrayList<>();
        Lattice lattice = this.lattice;
        for (Coordinate p : lattice.pointsL()) {
            for (Atom atom : motif) {
                structure.add(new Atom(atom.getElement(),
                        new Coordinate(atom.getCoordinate().getX() + p.getX(), atom.getCoordinate().getY() + p.getY(), atom.getCoordinate().getZ() + p.getZ())));
                // for each coordinate point, for each atom in the motif, makes a new list with a new atom with identity of motif atom and coordinate of sum of lattice and atom coordinate
            }
        }
        return structure;
    }

    @Override
    public boolean equals(Object o) {
        List<Atom> a = (List<Atom>) o;
        Iterator<Atom> step1 = this.getStructure().iterator();
        Iterator<Atom> step2 = a.iterator();
        while (step1.hasNext() && step2.hasNext()) {
            if (!step1.next().equals(step2.next())) { return false;}
        }
        return true;
    }
}

