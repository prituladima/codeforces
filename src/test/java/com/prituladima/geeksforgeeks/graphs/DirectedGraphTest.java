package com.prituladima.geeksforgeeks.graphs;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static com.prituladima.geeksforgeeks.util.Util.array;
import static com.prituladima.geeksforgeeks.util.Util.matrix;
import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)
public class DirectedGraphTest {

    private int vertex_amount;
    private int[][] pairs;
    private int path_to;
    private int[][] result;

    public DirectedGraphTest(int vertex_amount, int[][] pairs, int path_to, int[][] result) {
        this.vertex_amount = vertex_amount;
        this.pairs = pairs;
        this.path_to = path_to;
        this.result = result;
    }


    @Parameterized.Parameters(name = "{index}: breadth_first_search(V = {0}, mtx = {1}, from {2})={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {4, matrix(), 0, matrix(array(), null, null, null)},
                        {4, matrix(), 1, matrix(null, array(), null, null)},
                        {4, matrix(), 2, matrix(null, null, array(), null)},
                        {4, matrix(), 3, matrix(null, null, null, array())},


                        {4, matrix(array(0, 2), array(2, 1), array(1, 3)),
                                0, matrix(array(), array(2, 1), array(2), array(2, 1, 3))},
                        {4, matrix(array(0, 2), array(2, 1), array(1, 3)),
                                1, matrix(null, array(), null, array(3))},
                        {4, matrix(array(0, 2), array(2, 1), array(1, 3)),
                                2, matrix(null, array(), array(1), array(1, 3))},
                        {4, matrix(array(0, 2), array(2, 1), array(1, 3)),
                                3, matrix(null, null, null, array())},


                }
        );
    }

    @Test
    public void test_breadth_first_search() {

        System.out.println("----------------------------------------------");

        DirectedGraph graph = new DirectedGraph(vertex_amount);
        for (int i = 0; i < pairs.length; i++) {
            graph.addEdge(pairs[i][0], pairs[i][1]);
        }

        System.out.println(graph);

        int[][] minPath = graph.breadthFirstSearch(path_to);
        assertEquals(result.length, minPath.length);


        for (int i = 0; i < minPath.length; i++) {
            System.out.println(Arrays.toString(minPath[i]));
            assertArrayEqualsWithNull(result[i], minPath[i]);
        }
        System.out.println("----------------------------------------------");
    }


    private void assertArrayEqualsWithNull(int[] a, int[] b) {
        if (a == null) {
            assertTrue(b == null);
        } else
            assertArrayEquals(a, b);
    }


}
