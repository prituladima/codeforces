package com.prituladima.geeksforgeeks.math.factorization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;


@RunWith(value = Parameterized.class)
public class HoaxNumberTest {

    private long n;
    private boolean expected;

    public HoaxNumberTest(long n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: HoaxNumberTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(22, true),
                item(84, true),
                item(19, false),
                item(1, false)
        );
    }


    @Test
    public void text() {
        assertEquals(expected, HoaxNumber.isHoax(n));
    }


}