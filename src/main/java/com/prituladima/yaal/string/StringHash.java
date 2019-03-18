package com.prituladima.yaal.string;

/**
 *
 */
public interface StringHash {
    long hash(int from, int to);

    long hash(int from);

    int length();
}
