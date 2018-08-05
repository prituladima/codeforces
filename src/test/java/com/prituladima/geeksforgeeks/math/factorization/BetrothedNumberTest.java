package com.prituladima.geeksforgeeks.math.factorization;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.Asserts.assertMatrixEquals;
import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 8/5/18.
 */
@RunWith(value = Parameterized.class)
public class BetrothedNumberTest {

    private int n;
    private int[][] expected;

    public BetrothedNumberTest(int n, int[][] expected) {
        this.n = n;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: BetrothedNumberTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(1000,
                        pairList(
                                pair(48, 75),
                                pair(140, 195)
                        )
                ),
                item(2000,
                        pairList(
                                pair(48, 75),
                                pair(140, 195),
                                pair(1050, 1925),
                                pair(1575, 1648)
                        )
                )
        );
    }

    @Test
    public void text() {

        int[][] res = BetrothedNumber.getBetrothedNumbers(n);

        soutln("Expected");
        soutln(expected);

        soutln("Actual");
        soutln(res);


        assertMatrixEquals(expected, res);

    }

}