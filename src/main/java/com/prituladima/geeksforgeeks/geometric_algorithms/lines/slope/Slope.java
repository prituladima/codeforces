package com.prituladima.geeksforgeeks.geometric_algorithms.lines.slope;

/**
 * Created by prituladima on 7/13/18.
 */
public class Slope {

    int first;
    int second;

    public Slope(int x1, int y1, int x2, int y2) {
        first = x1 - x2;
        second = y1 - y2;

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

        Slope slope = (Slope) o;

        if (first != slope.first) return false;
        return second == slope.second;
    }

    @Override
    public int hashCode() {
        int result = first;
        result = 31 * result + second;
        return result;
    }
}
