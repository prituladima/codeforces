package com.prituladima.yaal.generated.collections.iterator;

import java.util.NoSuchElementException;

/**
 *  */
public interface DoubleIterator {
    public double value() throws NoSuchElementException;

    /**
     * Returns true if next call to isValid will return true
     */
    public boolean advance();

    public boolean isValid();

    public void remove();
}
