package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.array;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 7/13/18.
 */
@RunWith(value = Parameterized.class)
public class MinimumLinesToCoverAllPointsWhichGoThroughASpecificPointTest {


    int x;
    int y;
    int[][] points;
    int expected;

    public MinimumLinesToCoverAllPointsWhichGoThroughASpecificPointTest(int x, int y, int[][] points, int expected) {
        this.x = x;
        this.y = y;
        this.points = points;
        this.expected = expected;
    }


    @Parameterized.Parameters(name = "{index}: MinimumLinesToCoverAllPointsWhichGoThroughASpecificPointTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(1, 0,
                        pointSet(
                                array(-1, 3),
                                array(4, 3),
                                array(2, 1),
                                array(-1, -2),
                                array(3, -3)
                        ),
                        2)
        );
    }

    MinimumLinesToCoverAllPointsWhichGoThroughASpecificPoint o = new MinimumLinesToCoverAllPointsWhichGoThroughASpecificPoint();

    @Test
    public void test() {
        assertEquals(expected, o.minLinesToCoverPoints(x, y, points));
    }

}