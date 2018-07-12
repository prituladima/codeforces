package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by prituladima on 7/12/18.
 */
@RunWith(value = Parameterized.class)
public class AmountOfPointOnTheSameLineTest {

    int n;
    int[] x;
    int[] y;
    int expected;

    public AmountOfPointOnTheSameLineTest(int n, int[] x, int[] y, int expected) {
        this.n = n;
        this.x = x;
        this.y = y;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Points in Straight Line")
    public static Iterable<Object[]> data() {
        return testSet(
                item(2,
                        array(1, 1),
                        array(2, 2),
                        2),
                item(3,
                        array(0, 0, 0),
                        array(4, 5, 6),
                        3),
                item(35,
                        array(21, 42, 18, 28, 39, 22, 8, 8, 48, 36, 8, 3, 48, 3, 33, 33, 48, 40, 4, 17, 46, 18, 29, 0, 46, 38, 47, 49, 40, 3, 33, 13, 47, 3, 42),
                        array(36, 25, 2, 46, 25, 38, 7, 29, 36, 10, 14, 21, 10, 4, 28, 27, 0, 48, 6, 2, 44, 47, 49, 43, 39, 2, 28, 3, 0, 31, 47, 38, 9, 1, 35),
                        4),
                item(1,
                        array(5),
                        array(42),
                        1)
        );
    }

    AmountOfPointOnTheSameLine o = new AmountOfPointOnTheSameLine();

    @Test
    public void naive(){
        assertEquals(expected, o.noOfPoints(x, y, n));
    }

    @Test
    public void fast(){
        assertEquals(expected, o.noOfPointsFast(x, y, n));
    }


}