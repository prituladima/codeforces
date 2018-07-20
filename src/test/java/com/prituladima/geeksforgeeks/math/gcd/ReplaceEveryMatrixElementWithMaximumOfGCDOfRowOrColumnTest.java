package com.prituladima.geeksforgeeks.math.gcd;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.prituladima.geeksforgeeks.util.Asserts.assertMatrixEquals;
import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;

@RunWith(value = Parameterized.class)
public class ReplaceEveryMatrixElementWithMaximumOfGCDOfRowOrColumnTest {

    private int[][] matrix;
    private int[][] expected;

    public ReplaceEveryMatrixElementWithMaximumOfGCDOfRowOrColumnTest(int[][] matrix, int[][] expected) {
        this.matrix = matrix;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: ReplaceEveryMatrixElementWithMaximumOfGCDOfRowOrColumn")
    public static Iterable<Object[]> data() {
        return testSet(
                item(
                        matrix(
                                vector(1, 2, 3, 3),
                                vector(4, 5, 6, 6),
                                vector(7, 8, 9, 9)
                        ),
                        matrix(
                                vector(1, 1, 3, 3),
                                vector(1, 1, 3, 3),
                                vector(1, 1, 3, 3)
                        )
                )
        );
    }

    ReplaceEveryMatrixElementWithMaximumOfGCDOfRowOrColumn o = new ReplaceEveryMatrixElementWithMaximumOfGCDOfRowOrColumn();

    @Before
    public void log() {
        soutln("INPUT");
        soutln(matrix);
        soutln("EXPECTED");
        soutln(expected);
    }

    @Test
    public void run() {

        int[][] res = o.solveNaive(matrix);
        soutln("NAIVE");
        soutln(res);
        assertMatrixEquals(expected, res);

        res = o.solveEfficient(matrix);
        soutln("EFFICIENT");
        soutln(res);
        assertMatrixEquals(expected, res);
    }

}