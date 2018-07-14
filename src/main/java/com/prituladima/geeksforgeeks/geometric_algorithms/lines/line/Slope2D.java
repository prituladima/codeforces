package com.prituladima.geeksforgeeks.geometric_algorithms.lines.line;

/**
 * Created by prituladima on 7/14/18.
 */
public class Slope2D {

    int first;
    int second;

    public Slope2D(Point2D p, Point2D q) {
        first = p.getX() - q.getX();
        second = p.getY() - q.getY();

        int gcd = gcd(first, second);
        if (gcd != 0) {
            first /= gcd;
            second /= gcd;
        }
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Slope2D slope2D = (Slope2D) o;

        if (first != slope2D.first) return false;
        return second == slope2D.second;
    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + second;
        return result;
    }

}