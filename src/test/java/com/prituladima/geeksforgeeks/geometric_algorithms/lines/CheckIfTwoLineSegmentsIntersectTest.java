package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class CheckIfTwoLineSegmentsIntersectTest {

    private CheckIfTwoLineSegmentsIntersect.IntPoint p1;
    private CheckIfTwoLineSegmentsIntersect.IntPoint q1;

    private CheckIfTwoLineSegmentsIntersect.IntPoint p2;
    private CheckIfTwoLineSegmentsIntersect.IntPoint q2;

    private int expected;

    public CheckIfTwoLineSegmentsIntersectTest(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int expected) {
        this.p1 = new CheckIfTwoLineSegmentsIntersect.IntPoint(x1, y1);
        this.q1 = new CheckIfTwoLineSegmentsIntersect.IntPoint(x2, y2);
        this.p2 = new CheckIfTwoLineSegmentsIntersect.IntPoint(x3, y3);
        this.q2 = new CheckIfTwoLineSegmentsIntersect.IntPoint(x4, y4);
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: doIntersect({0}, {1}, {2}, {3}, {4}, {5}, {6}, {7})={8}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {1, 1, 10, 1, 1, 2, 10, 2, 0},
                        {10, 0, 0, 10, 0, 0, 10, 10, 1},
                        {695, 456640, 304, 199362, 806, 529678, 11, 6568, 1},
                        {745, -744896, 740, -739901, -349, 348010, -687, 685672, 0}
                }
        );
    }

    CheckIfTwoLineSegmentsIntersect o = new CheckIfTwoLineSegmentsIntersect();

    @Test
    public void test() {
        assertEquals(expected, o.doIntersect(p1, q1, p2, q2) ? 1 : 0);
    }
}