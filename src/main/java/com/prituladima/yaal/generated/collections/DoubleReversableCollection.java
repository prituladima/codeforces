package com.prituladima.yaal.generated.collections;

import com.prituladima.yaal.generated.collections.iterator.DoubleIterator;

public interface DoubleReversableCollection extends DoubleCollection {
    //abstract
    public DoubleIterator reverseIterator();

    //base
    default public double last() {
        return reverseIterator().value();
    }

    default DoubleStream reversed() {
        return () -> reverseIterator();
    }
}
