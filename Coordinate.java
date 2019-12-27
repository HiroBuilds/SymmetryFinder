package uk.ac.cam.hjf42.Experiment;

public class Coordinate implements Comparable<Coordinate> {
    private float x;
    private float y;
    private float z;

    public Coordinate(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float z) {
        this.z = z;
    }

    float getX(){return this.x;};
    float getY(){return this.y;};
    float getZ(){return this.z;};

    @Override
    public String toString() {
        return String.format("(%s, %s, %s)", this.x, this.y, this.z);
    }
    @Override
    public boolean equals(Object o) {
        Coordinate a = (Coordinate) o;
        if (a.getX() == this.x && a.getY() == this.y && a.getZ() == this.z) { return true;}
        return false;
    }

    @Override
    public int compareTo(Coordinate coordinate) {
        int v = Float.compare(this.x, coordinate.x);
        if (v != 0) {
            return v;
        }
        v = Float.compare(this.y, coordinate.y);
        if (v != 0) {
            return v;
        }
        return Float.compare(this.z, coordinate.z);
    }
}
