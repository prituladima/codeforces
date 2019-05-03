package com.prituladima.yaal.greedy;

public class Tuple<X, Y, Z> {
    private X x;
    private Y y;
    private Z z;

    public Tuple(X x, Y y, Z z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public X getX() {
        return x;
    }

    public Y getY() {
        return y;
    }

    public Z getZ() {
        return z;
    }
}