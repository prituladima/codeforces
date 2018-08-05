package com.prituladima.geeksforgeeks.math.factorization;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 8/4/18.
 */
@RunWith(value = Parameterized.class)
public class BlumIntegerTest {

    private int n;
    private boolean expected;

    public BlumIntegerTest(int n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: BlumIntegerTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(249, true),
                item(33, true),
                item(77, true),
                item(25, false)
        );
    }


    @Test
    public void text() {
        assertEquals(expected, BlumInteger.isBlumInteger(n));
    }

}