package com.prituladima.geeksforgeeks.math.binomial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class nCrMODTest {

    final nCrMOD nCr_mod = new nCrMOD();
    private static final int MOD = 1000000007;

    private final int modulo;
    private final int n;
    private final int r;
    private final int expected;

    public nCrMODTest(int n, int r, int modulo, int expected) {
        this.n = n;
        this.r = r;
        this.modulo = modulo;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: nCr_mod({0}, {1}, {2})={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {794, 736, MOD, 927517870},
                        {778, 116, MOD, 735309323}
                }
        );
    }

    @Test(timeout = 2000)
    public void test() throws Exception {
        assertEquals(expected, nCr_mod.binomialCoeff_dp_opt(n, r));
        assertEquals(expected, nCr_mod.binomialCoeff_dp(n, r));
    }

}