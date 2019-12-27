package uk.ac.cam.hjf42.Experiment;

import java.util.List;

public class Symmetry {
    final Crystal crystal;

    protected Symmetry(Crystal crystal) {
        this.crystal = crystal;
    }
    public Crystal getCrystal() { return crystal;}
}

class Output {
    private final Crystal crystal;
    public Output(Crystal crystal) {
        this.crystal = crystal;
    }
    public void output() {
        new MirrorPlane(crystal).output();
        new Rotation(crystal).mainRotation();
        new Screw(crystal).mainScrew();
    }
}
