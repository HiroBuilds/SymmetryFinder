package uk.ac.cam.hjf42.Experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        try {
        System.out.print("Firstly, how many atoms does the motif have? ");
        String line = in.readLine();
        int atomNumber = Integer.parseInt(line);
        List<Atom> motif = new ArrayList<Atom>();
        for (int i = 1; i <= atomNumber; i++) {
            System.out.printf("What element is Atom %s? ", i);
            String element = in.readLine();
            System.out.print("Type its x coordinate: ");
            float x = Float.parseFloat(in.readLine());
            System.out.print("Type its y coordinate: ");
            float y = Float.parseFloat(in.readLine());
            System.out.print("Type its z coordinate: ");
            float z = Float.parseFloat(in.readLine());
            Atom atom = new Atom(element, new Coordinate(x,y,z));
            motif.add(atom);
        }
        System.out.print("What is the crystal's lattice type? ");
        char input = in.readLine().charAt(0);
        Lattice lattice = new Lattice(input);
        Crystal crystal = new Crystal(motif, lattice);
        new Output(crystal).output();
        }
        catch (Exception a){
            System.out.println("You entered an invalid value");

        }
    }
}
