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
public class SuperperfectNumberTest {


    private int n;
    private boolean expected;

    public SuperperfectNumberTest(int n, boolean expected) {
        this.n = n;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: SuperperfectNumberTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(16, true),
                item(8, false),
                item(6, false)
        );
    }


    @Test
    public void text() {
        assertEquals(expected, SuperperfectNumber.isSuperPerfect(n));
    }

}