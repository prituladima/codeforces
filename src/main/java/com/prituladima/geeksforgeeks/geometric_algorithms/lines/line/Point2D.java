package com.prituladima.geeksforgeeks.geometric_algorithms.lines.line;

/**
 * Created by prituladima on 7/14/18.
 */
public class Point2D {

    int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point2D point2D = (Point2D) o;

        if (x != point2D.x) return false;
        return y == point2D.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}