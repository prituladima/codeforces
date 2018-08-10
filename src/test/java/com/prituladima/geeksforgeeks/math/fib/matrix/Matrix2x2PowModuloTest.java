package com.prituladima.geeksforgeeks.math.fib.matrix;

import com.prituladima.geeksforgeeks.math.factorization.AliquotSum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.Asserts.assertMatrixEquals;
import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class Matrix2x2PowModuloTest {


    private long[][] M;
    private long pow;
    private long modulo;
    private long[][] expected;

    public Matrix2x2PowModuloTest(long[][] M, long pow, long modulo, long[][] expected) {
        this.M = M;
        this.pow = pow;
        this.modulo = modulo;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Matrix2x2PowModuloTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(matrix2x2(1, 1, 1, 0), 6, 10, matrix2x2(3, 8, 8, 5)),
                item(matrix2x2(1, 1, 1, 0), 6, 2, matrix2x2(1, 0, 0, 1)),
                item(matrix2x2(1, 1, 1, 0), 6, 5, matrix2x2(3, 3, 3, 0)),


                item(matrix2x2(1, 1, 1, 0), 6, 1000000007, matrix2x2(13, 8, 8, 5)),
                item(matrix2x2(1, 1, 1, 0), 5, 1000000007, matrix2x2(8, 5, 5, 3)),
                item(matrix2x2(1, 1, 1, 0), 4, 1000000007, matrix2x2(5, 3, 3, 2)),
                item(matrix2x2(1, 1, 1, 0), 3, 1000000007, matrix2x2(3, 2, 2, 1)),
                item(matrix2x2(1, 1, 1, 0), 2, 1000000007, matrix2x2(2, 1, 1, 1)),
                item(matrix2x2(1, 1, 1, 0), 1, 1000000007, matrix2x2(1, 1, 1, 0))
        );
    }

    GeneralisedFibonacciNumbers o = new GeneralisedFibonacciNumbers();

    @Test
    public void text() {
        soutln("Pow");
        soutln(pow);
        soutln("Expected");
        soutln(expected);
        long[][] R = o.matrix2x2_pow_modulo(M, pow, modulo);
        soutln("Actual");
        soutln(R);
        assertMatrixEquals(expected, R);
    }


}