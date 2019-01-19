package com.prituladima.yaal.collections.intervaltree;

/**
 *  */
public abstract class ArrayBasedIntervalTree extends LongIntervalTree {
    private long[] array;

    protected ArrayBasedIntervalTree(long[] array) {
        super(array.length, false);
        this.array = array;
        init();
    }

    @Override
    protected long initValue(int index) {
        return array[index];
    }
}
