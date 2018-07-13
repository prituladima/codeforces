package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 7/13/18.
 */
@RunWith(value = Parameterized.class)
public class EquationOfLineTest {

    int[] u;
    int[] v;
    int[] expected;

    public EquationOfLineTest(int[] u, int[] v, int[] expected) {
        this.u = u;
        this.v = v;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Points in Straight Line")
    public static Iterable<Object[]> data() {
        return testSet(
                item(point(0, 0),
                        point(1, 1),
                        vector(-1, 1, 0)),
                item(point(0, 1),
                        point(0, 1),
                        null)
        );
    }

    EquationOfLine o = new EquationOfLine();

    @Test
    public void test() {
        assertArrayEquals(expected, o.getEquationOfLine(u, v));
    }

}