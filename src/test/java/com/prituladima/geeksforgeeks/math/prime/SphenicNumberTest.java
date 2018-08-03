package com.prituladima.geeksforgeeks.math.prime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class SphenicNumberTest {

    private long n;
    private boolean expected;

    public SphenicNumberTest(long n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: SphenicNumberTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(30, true),
                item(60, false),
                item(42, true),
                item(66, true),
                item(70, true),
                item(102, true)
        );
    }


    @Test
    public void text() {
        assertEquals(expected, SphenicNumber.isSphenic(n));
    }


}