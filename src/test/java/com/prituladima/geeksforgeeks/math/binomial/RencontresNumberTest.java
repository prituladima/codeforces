package com.prituladima.geeksforgeeks.math.binomial;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class RencontresNumberTest {

    private final int modulo = 1000000007;
    private final int n;
    private final int m;
    private final int expected;

    private final RencontresNumber rencontresNumber = new RencontresNumber();

    public RencontresNumberTest(int n, int m, int expected) {
        this.n = n;
        this.m = m;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: rencontres({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {0, 0, 1},
                        {1, 0, 0},
                        {1, 1, 1},
                        {2, 0, 1},
                        {2, 2, 1},
                        {4, 0, 9},
                        {5, 2, 20}
                }
        );
    }


    @Test
    public void rencontres_number_test(){
        assertEquals(expected, rencontresNumber.rencontres_number_rec(n, m));
        assertEquals(expected, rencontresNumber.rencontres_number_dp(n, m));
    }

}
