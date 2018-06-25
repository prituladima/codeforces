package com.prituladima.geeksforgeeks.graphs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static com.prituladima.geeksforgeeks.util.Asserts.assertArrayEqualsWithNull;
import static com.prituladima.geeksforgeeks.util.Util.array;
import static com.prituladima.geeksforgeeks.util.Util.matrix;

@RunWith(value = Parameterized.class)
public class MotherVertexGraph {

    private int vertex_amount;
    private int[][] pairs;

    private int[] expected;

    public MotherVertexGraph(int vertex_amount, int[][] pairs, int[] expected) {
        this.vertex_amount = vertex_amount;
        this.pairs = pairs;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "{index}: mother(V = {0}, mtx = {1}, from {2})={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {5, matrix(
                                array(0, 3),
                                array(0, 2),
                                array(1, 0),
                                array(2, 1),
                                array(3, 4)
                        ),
                                array(0, 1, 2)}
                }
        );
    }

    @Test
    public void mather_vertex_test(){
        DirectedGraph graph = new DirectedGraph(5);
        //assertArrayEqualsWithNull(expected, graph.motherVertexes());
    }

}
