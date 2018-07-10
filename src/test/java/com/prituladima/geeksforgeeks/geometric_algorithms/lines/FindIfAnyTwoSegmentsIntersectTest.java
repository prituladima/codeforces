package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.Print.printMatrix;
import static com.prituladima.geeksforgeeks.util.Util.array;
import static com.prituladima.geeksforgeeks.util.Util.matrix;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 7/10/18.
 */
@RunWith(value = Parameterized.class)
public class FindIfAnyTwoSegmentsIntersectTest {

    private int n;
    private int[][] points;
    private int expected;

    public FindIfAnyTwoSegmentsIntersectTest(int n, int[][] points, int expected) {
        this.n = n;
        this.points = points;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: Sweep Line Algorithm (" +
            "Amounts of segments {0})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {7, matrix(array(4, 16, 9, 19),
                                array(6, 14, 12, 16),
                                array(6, 9, 10, 14),
                                array(9, 9, 13, 13),
                                array(17, 17, 17, 13),
                                array(11, 6, 27, 15),
                                array(14, 10, 17, 8)),
                                1},
                        {6, matrix(array(4, 16, 9, 19),
                                array(6, 14, 12, 16),
                                array(6, 9, 10, 14),
                                array(9, 9, 13, 13),
                                array(17, 17, 17, 13),
                                array(11, 6, 27, 15)),
                                0},
                        {7, matrix(array(4, 16, 9, 19),
                                array(6, 14, 12, 16),
                                array(6, 9, 10, 14),
                                array(9, 9, 13, 13),
                                array(17, 17, 17, 13),
                                array(11, 6, 27, 15),
                                array(20, 4, 34, 10)),
                                0},
                        {8, matrix(array(4, 16, 9, 19),
                                array(6, 14, 12, 16),
                                array(6, 9, 10, 14),
                                array(9, 9, 13, 13),
                                array(17, 17, 17, 13),
                                array(11, 6, 27, 15),
                                array(20, 4, 34, 10),
                                array(5, 20, 30, 3)),
                                1}
                }
        );
    }

    FindIfAnyTwoSegmentsIntersect o = new FindIfAnyTwoSegmentsIntersect();

    @Test
    public void test1() {
        printMatrix(points);
        assertEquals(expected, o.sweepLineAlgorithm(n, points));
    }

}