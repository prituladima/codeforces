package com.prituladima.geeksforgeeks.geometric_algorithms.lines.line;

/**
 * Created by prituladima on 7/14/18.
 */
public class Line2D {

    int A, B, C;

    public Line2D(int a, int b, int c) {
        A = a;
        B = b;
        C = c;
    }

    public int getA() {
        return A;
    }

    public int getB() {
        return B;
    }

    public int getC() {
        return C;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line2D line2D = (Line2D) o;

        if (A != line2D.A) return false;
        if (B != line2D.B) return false;
        return C == line2D.C;
    }

    @Override
    public int hashCode() {
        int result = A;
        result = 31 * result + B;
        result = 31 * result + C;
        return result;
    }
}