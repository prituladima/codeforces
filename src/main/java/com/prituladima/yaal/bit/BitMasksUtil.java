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

    /**
     * Set 0 to specific bit in mask
     */
    public static int turnOffK(int mask, int ind) {
        return (mask & ~(1 << ind));
    }

    /**
     * Set 1 to specific bit in mask
     */
    public static int turnOnK(int mask, int ind) {
        return (mask | (1 << ind));
    }

    /**
     * Toggle specific bit in mask
     */
    public static int toggleBit(int mask, int ind){
        return (mask ^ (1 << ind));
    }

    /**
     * Check specific index in mask
     */
    public static boolean maskToIndex(int bitmask, int index){
        return (bitmask & (1 << index)) > 0;
    }


}
