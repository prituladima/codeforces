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
public class AliquotSumTest {

    private int n;
    private int expected;

    public AliquotSumTest(int n, int expected) {
        this.n = n;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: AliquotSumTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(12, 16),
                item(15, 9),
                item(6, 6)
        );
    }

    @Test
    public void text() {
        assertEquals(expected, AliquotSum.aliquotSum(n));
    }

}