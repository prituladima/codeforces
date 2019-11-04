package com.prituladima.yaal.bit;

public class BitMasksUtil {

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
        return x == Long.highestOneBit(x);
    }

    public static int binaryLen(int number) {
        return (int) (Math.log(number) / Math.log(2) + 1);
    }

    public static int binaryPrefix(int n, int prefLen) {
        return n >> (binaryLen(n) - prefLen);
    }

    public static int amountOfBitMasksWithLen(int len) {
        return 1 << len;
    }

    public static int checkBit(int mask, int shift) {
        return (mask >> shift) & 1;
    }

}
