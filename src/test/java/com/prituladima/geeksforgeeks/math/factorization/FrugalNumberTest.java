package com.prituladima.geeksforgeeks.math.factorization;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class FrugalNumberTest {

    private long n;
    private boolean expected;

    public FrugalNumberTest(long n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: FrugalNumberTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(125, true),
                item(128, true),
                item(243, true),
                item(256, true),
                item(17, false),
                item(5, false),
                item(1, false)
        );
    }


    @Test
    public void text() {
        assertEquals(expected, FrugalNumber.isFrugalNumber(n));
    }


}