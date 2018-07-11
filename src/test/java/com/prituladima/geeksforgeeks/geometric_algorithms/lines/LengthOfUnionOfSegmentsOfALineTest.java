package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static com.prituladima.geeksforgeeks.util.Util.*;
import static org.junit.Assert.*;

/**
 * @see "https://www.geeksforgeeks.org/klees-algorithm-length-union-segments-line/"
 */

@RunWith(value = Parameterized.class)
public class LengthOfUnionOfSegmentsOfALineTest {

    private int n;
    private int[][] points;
    private int expected;

    public LengthOfUnionOfSegmentsOfALineTest(int n, int[][] points, int expected) {
        this.n = n;
        this.points = points;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}:Length Of Union Of Segments Of A Line Test (" +
            "Amounts of segments {0})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {3, asArray(segment(2, 5),
                                segment(4, 8),
                                segment(9, 12)),
                                9},
                        {4, asArray(segment(2, 5),
                                segment(4, 8),
                                segment(9, 12),
                                segment(15, 20)),
                                14},
                        {5, asArray(segment(2, 5),
                                segment(4, 8),
                                segment(9, 12),
                                segment(15, 20),
                                segment(0, 8)),
                                16}
                }
        );
    }

    LengthOfUnionOfSegmentsOfALine o = new LengthOfUnionOfSegmentsOfALine();

    @Test
    public void klee(){
        assertEquals(expected, o.klee(points));
    }

}