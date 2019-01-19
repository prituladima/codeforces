package com.prituladima.yaal.generated.collections;

import com.prituladima.yaal.generated.collections.iterator.IntIterator;

public interface IntReversableCollection extends IntCollection {
    //abstract
    public IntIterator reverseIterator();

    //base
    default public int last() {
        return reverseIterator().value();
    }

    default IntStream reversed() {
        return () -> reverseIterator();
    }
}
