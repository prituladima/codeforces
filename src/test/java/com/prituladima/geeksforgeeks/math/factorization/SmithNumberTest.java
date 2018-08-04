package com.prituladima.geeksforgeeks.math.factorization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;


@RunWith(value = Parameterized.class)
public class SmithNumberTest {


    private long n;
    private boolean expected;

    public SmithNumberTest(long n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: SmithNumberTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(4, true),
                item(6, false),
                item(666, true),
                item(13, false),
                item(60493, false),
                item(1, false)
        );
    }


    @Test
    public void text() {
        assertEquals(expected, SmithNumber.isSmithNumber(n));
    }





}