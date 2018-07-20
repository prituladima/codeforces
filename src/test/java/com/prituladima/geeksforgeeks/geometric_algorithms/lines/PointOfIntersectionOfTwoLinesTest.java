package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutln;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.line;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 7/15/18.
 */
@RunWith(value = Parameterized.class)
public class PointOfIntersectionOfTwoLinesTest {

    int[][] line1;
    int[][] line2;
    double[] expected;
    boolean noAns;

    public PointOfIntersectionOfTwoLinesTest(int[][] line1, int[][] line2, double[] expected, boolean noAns) {
        this.line1 = line1;
        this.line2 = line2;
        this.expected = expected;
        this.noAns = noAns;
    }

    @Parameterized.Parameters(name = "{index}: PointOfIntersectionOfTwoLines")
    public static Iterable<Object[]> data() {
        return testSet(
                item(
                        line(
                                point(1, 1),
                                point(4, 4)
                        ),
                        line(
                                point(1, 8),
                                point(2, 4)
                        ),
                        point(2.4, 2.4),
                        false
                ),
                item(
                        line(
                                point(0, 0),
                                point(3, 3)
                        ),
                        line(
                                point(5, 0),
                                point(9, 4)
                        ),
                        null,
                        true
                ),
                item(
                        line(
                                point(0, 0),
                                point(3, 3)
                        ),
                        line(
                                point(0, 3),
                                point(3, 0)
                        ),
                        point(1.5, 1.5),
                        false
                )
        );
    }


    PointOfIntersectionOfTwoLines o = new PointOfIntersectionOfTwoLines();

    double EPS = 1E-10;

    @Test
    public void test() {

        soutln(line1);
        soutln(line2);

        if (noAns) {
            assertNull(o.pointOfIntersectionOfTwoLines(line1, line2));
        } else {
            double[] point = o.pointOfIntersectionOfTwoLines(line1, line2);
            assertEquals(expected[0], point[0], EPS);
            assertEquals(expected[1], point[1], EPS);
        }
    }
}