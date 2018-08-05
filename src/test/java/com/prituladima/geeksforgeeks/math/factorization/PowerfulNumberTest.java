package com.prituladima.geeksforgeeks.math.factorization;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 8/5/18.
 */
@RunWith(value = Parameterized.class)
public class PowerfulNumberTest {

    private int n;
    private boolean expected;

    public PowerfulNumberTest(int n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: PowerfulNumberTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(       27, true),
                item(32, true),
                item(12, false)
        );
    }


    @Test
    public void text() {
        assertEquals(expected, PowerfulNumber.isPowerfulNumber(n));
    }

}