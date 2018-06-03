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


}
