package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import com.prituladima.geeksforgeeks.geometric_algorithms.lines.line.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.*;
import org.junit.runners.*;

import static java.util.stream.IntStream.range;

import static com.prituladima.geeksforgeeks.util.TestSetWrapper.*;
import static org.junit.Assert.*;

/**
 * Created by prituladima on 7/14/18.
 */
@RunWith(value = Parameterized.class)
public class MinJumpsToReachDestinationTest {

    private Point2D start;
    private Point2D dest;
    private int n;
    private List<Line2D> lines;
    private int expected;


    public MinJumpsToReachDestinationTest(int n, int[] start, int[] dest, int[][] lines, int expected) {
        this.n = n;
        this.start = new Point2D(start[0], start[1]);
        this.dest = new Point2D(dest[0], dest[1]);
        this.lines = new ArrayList<>();
        range(0, n).forEach(i -> this.lines.add(new Line2D(lines[i][0], lines[i][1], lines[i][2])));
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: MinJumpsToReachDestinationTest")
    public static Iterable<Object[]> data() {
        return testSet(
                item(3,
                        point(1, 1),
                        point(-2, -1),
                        lineSet(
                                line(1, 0, 0),
                                line(0, 1, 0),
                                line(1, 1, -2)
                        ),
                        2)
        );
    }

    MinJumpsToReachDestination o = new MinJumpsToReachDestination();

    @Test
    public void test() {
        assertEquals(expected, o.minJumpToReachDestination(start, dest, lines));
    }

}