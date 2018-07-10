package com.prituladima.geeksforgeeks.geometric_algorithms.lines.sweep;

/**
 * Created by prituladima on 7/10/18.
 */
public class SPoint {

    int id;
    double x;
    double y;

    Segment s;

    boolean isLeft;

    public SPoint(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Segment getS() {
        return s;
    }

    public boolean isLeft() {
        return isLeft;
    }
}
