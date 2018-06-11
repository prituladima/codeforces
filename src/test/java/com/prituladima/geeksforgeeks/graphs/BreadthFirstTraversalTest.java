package com.prituladima.geeksforgeeks.graphs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;


@RunWith(value = Parameterized.class)
public class BreadthFirstTraversalTest {

    private final String input;
    private final int output;

    public BreadthFirstTraversalTest(String input, int output) {
        this.input = input;
        this.output = output;
    }

    @Parameterized.Parameters(name = "{index}: BFS({0}, {1})={2}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {"OOOOXXO OXOXOOX XXXXOXO OXXXOOO", 4},
                        {"XXO OOX OXO OOO XOX XOX OXO XXO XXX OOO", 6},
                        {"XXX OOO XXX", 2},
                        {"OOOXOOO OXXXXXO OXOOOXO", 1},
                        {"", -1},
                        {"X X O X", 2}
                }
        );
    }

    BreadthFirstTraversal bfs = new BreadthFirstTraversal();

    @Test
    public void testBFS() {
        assertEquals(output, bfs.islands(input));
    }

}
