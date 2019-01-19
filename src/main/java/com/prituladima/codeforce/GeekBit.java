package com.prituladima.codeforce;

public class GeekBit {

    public static long nextPowerOf2(long n) {
        n--;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16;
        n++;
        return n;
    }

    public static boolean isPowerOfTwo(long x) {
        return x != 0 && ((x & (x - 1)) == 0);
    }
}
