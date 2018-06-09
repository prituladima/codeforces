package com.prituladima.math;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;


@RunWith(value = Parameterized.class)
public class nCrTest {

    final nCr nCr = new nCr();

    private final int modulo = 1000000007;
    private final int n;
    private final int r;
    private final int expected;

    public nCrTest(int n, int r, int expected) {
        this.n = n;
        this.r = r;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: nCr({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {0, 0, 1},
                        {2, 2, 1},
                        {200, 200, 1},
                        {2, 0, 1},
                        {23, 0, 1},
                        {234, 0, 1},
                        {12, 0, 1},

                        {4, 1, 4},
                        {4, 2, 6},
                        {4, 3, 4},

                        {794, 736, 927517870},
                        {778, 116, 735309323},
                        {5, 2, 10}
                }
        );
    }


    @Test(timeout = 2000)
    public void test() throws Exception {
        assertEquals(expected, nCr.nCr_mod_p_lucas(n, r, modulo));
    }
}
