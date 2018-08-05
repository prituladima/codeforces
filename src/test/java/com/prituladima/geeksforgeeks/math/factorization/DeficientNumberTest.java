package com.prituladima.geeksforgeeks.math.factorization;

import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 8/5/18.
 */
@RunWith(value = Parameterized.class)
public class DeficientNumberTest {


    private int[] a;
    private boolean expected;

    public DeficientNumberTest(int[] a, boolean expected) {
        this.a = a;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: DeficientNumberTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(vector(1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 13, 14, 15, 16, 17, 19), true)
        );
    }

    @Test
    public void text() {
        Arrays.stream(a).forEach(i ->
                {
                    soutln("-----DeficientNumberTest----");
                    soutln(i);
                    assertTrue(DeficientNumber.isDeficient(i));
                    soutln("-----DeficientNumberTest----");
                }
        );
    }


}