package com.prituladima.geeksforgeeks.math.fib.matrix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.item;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.testSet;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class GeneralisedFibonacciNumbersTest {


    long a;
    long b;
    long c;
    long n;
    long m;
    long exp;

    public GeneralisedFibonacciNumbersTest(long a, long b, long c, long n, long m, long exp) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.n = n;
        this.m = m;
        this.exp = exp;
    }

    @Parameterized.Parameters(name = "{index}: GeneralisedFibonacciNumbersTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(3, 3, 3, 3, 5, 4),
                item(2, 2, 2, 4, 100, 16),
                item(4289384, 6930887, 1692778, 714636916, 7747794, 1578715),
                item(4238336, 9885387, 9760493, 596516650, 9641422, 1865271)
        );
    }

    GeneralisedFibonacciNumbers o = new GeneralisedFibonacciNumbers();


    @Test
    public void test_(){
        assertEquals(exp, o.fibonacci_gen_mod(a, b, c, n, m));
    }

}