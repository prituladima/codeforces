package com.prituladima.yaal.generated.collections.hashing;

/**
 *
 */
public class LongHash {
    private LongHash() {
    }

    public static int hash(long c) {
        return (int) ((c >>> 32) ^ c);
    }
}
