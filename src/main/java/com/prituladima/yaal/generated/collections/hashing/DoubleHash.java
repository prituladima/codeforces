package com.prituladima.yaal.generated.collections.hashing;

/**
 *
 */
public class DoubleHash {
    private DoubleHash() {
    }

    public static int hash(double c) {
        long bits = Double.doubleToLongBits(c);
        return LongHash.hash(bits);
    }
}
