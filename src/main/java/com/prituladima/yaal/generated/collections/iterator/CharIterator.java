package com.prituladima.yaal.generated.collections.iterator;

import java.util.NoSuchElementException;

/**
 *  */
public interface CharIterator {
    public char value() throws NoSuchElementException;

    /**
     * Returns true if next call to isValid will return true
     */
    public boolean advance();

    public boolean isValid();

    public void remove();
}
