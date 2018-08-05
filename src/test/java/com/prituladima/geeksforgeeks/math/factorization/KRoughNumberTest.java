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
public class KRoughNumberTest {

    private int n;
    private int k;
    private boolean expected;

    public KRoughNumberTest(int n, int k, boolean expected) {
        this.n = n;
        this.k = k;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: KRoughNumberTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(10, 2, true),
                item(55, 7, false),
                item(75, 3, true),
                item(49, 7, true)
        );
    }


    @Test
    public void text() {
        assertEquals(expected, KRoughNumber.isKRoughNumber(n, k));
    }

}