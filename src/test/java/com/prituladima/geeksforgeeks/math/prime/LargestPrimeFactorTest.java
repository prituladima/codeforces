package com.prituladima.geeksforgeeks.math.prime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class LargestPrimeFactorTest {

    private long n, expected;

    public LargestPrimeFactorTest(long n, long expected) {
        this.n = n;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: LargestPrimeFactorTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(315, 7),
                item(2, 2),
                item(3, 3),
                item(6, 3),
                item(15, 5),
                item(17, 17),
                item(1, 1)
        );
    }


    @Test
    public void text() {

        assertEquals(expected, LargestPrimeFactor.largestPrimeFactor(n));
    }


}