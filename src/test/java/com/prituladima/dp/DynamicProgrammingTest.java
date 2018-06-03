package com.prituladima.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DynamicProgrammingTest {

    DynamicProgramming dp = new DynamicProgramming();

    @Test
    public void fib() {
        assertEquals(1, dp.fib(1));
        assertEquals(1, dp.fib(2));
        assertEquals(5, dp.fib(5));
        assertEquals(34, dp.fib(9));
        assertEquals(34, dp.fib(9));
        assertEquals(757853473, dp.fib(467));

        assertEquals(1, dp.fib_fast(1));
        assertEquals(1, dp.fib_fast(2));
        assertEquals(5, dp.fib_fast(5));
        assertEquals(34, dp.fib_fast(9));
        assertEquals(34, dp.fib_fast(9));
    }

    @Test
    public void nCr() {
        assertEquals(3, dp.nCr(3, 2));
        assertEquals(1, dp.nCr(3, 0));
        assertEquals(1, dp.nCr(3, 0));
        assertEquals(1, dp.nCr(3, 3));
        assertEquals(1, dp.nCr(200, 200));

        assertEquals(1, dp.nCr(1, 1));
        assertEquals(1, dp.nCr(2, 2));
        assertEquals(2, dp.nCr(2, 1));

        assertEquals(3, dp.nCr(3, 2));
        assertEquals(3, dp.nCr(3, 1));

        assertEquals(4, dp.nCr(4, 1));
        assertEquals(6, dp.nCr(4, 2));
        assertEquals(4, dp.nCr(4, 3));

        assertEquals(927517870, dp.nCr(794, 736));

    }


    @Test
    public void lcs() {
        String X = "ABCDGH", Y = "AEDFHR";
        assertEquals(3, dp.lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
        assertEquals(X.length(), dp.lcs(X.toCharArray(), X.toCharArray(), X.length(), X.length()));


        X = "ABC";
        Y = "AC";
        assertEquals(2, dp.lcs(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
        assertEquals(X.length(), dp.lcs(X.toCharArray(), X.toCharArray(), X.length(), X.length()));


        assertEquals(0, dp.lcs("".toCharArray(), "".toCharArray(), 0, 0));

    }


    @Test
    public void kadane() {
        assertEquals(7, dp.kadane_max(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}, 8));

        assertEquals(6, dp.kadane_max(new int[]{1, 2, 3}, 3));
        assertEquals(-1, dp.kadane_max(new int[]{-1, -2, -3, -4}, 4));

        assertEquals(1, dp.kadane_min(new int[]{1, 2, 3}, 3));
        assertEquals(-10, dp.kadane_min(new int[]{-1, -2, -3, -4}, 4));


    }

}
