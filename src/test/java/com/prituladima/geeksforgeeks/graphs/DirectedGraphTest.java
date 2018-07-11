package com.prituladima.geeksforgeeks.graphs;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static com.prituladima.geeksforgeeks.util.Asserts.assertMatrixEquals;
import static com.prituladima.geeksforgeeks.util.PrintWrapper.soutMatrix;
import static com.prituladima.geeksforgeeks.util.PrintWrapper.sout;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.array;
import static com.prituladima.geeksforgeeks.util.TestSetWrapper.matrix;
import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class DirectedGraphTest {

    private int vertex_amount;
    private int[][] pairs;
    private int path_to;
    private int[][] result;
    private int connectedComponent;

    public DirectedGraphTest(int vertex_amount, int[][] pairs, int path_to, int[][] result, int connectedComponent) {
        this.vertex_amount = vertex_amount;
        this.pairs = pairs;
        this.path_to = path_to;
        this.result = result;
        this.connectedComponent = connectedComponent;
    }


    @Parameterized.Parameters(name = "{index}: breadth_first_search(V = {0}, mtx = {1}, from {2})={3}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][]{
                        {4, matrix(), 0, matrix(array(), null, null, null), 4},
                        {4, matrix(), 1, matrix(null, array(), null, null), 4},
                        {4, matrix(), 2, matrix(null, null, array(), null), 4},
                        {4, matrix(), 3, matrix(null, null, null, array()), 4},


                        {4, matrix(array(0, 2), array(2, 1), array(1, 3)),
                                0, matrix(array(), array(2, 1), array(2), array(2, 1, 3)), 1},
                        {4, matrix(array(0, 2), array(2, 1), array(1, 3)),
                                1, matrix(null, array(), null, array(3)), 1},
                        {4, matrix(array(0, 2), array(2, 1), array(1, 3)),
                                2, matrix(null, array(1), array(), array(1, 3)), 1},
                        {4, matrix(array(0, 2), array(2, 1), array(1, 3)),
                                3, matrix(null, null, null, array()), 1},


                }
        );
    }

    @Test
    public void test_breadth_first_search() {
        sout("----------------------------------------------");

        DirectedGraph graph = new DirectedGraph(vertex_amount);
        for (int i = 0; i < pairs.length; i++) {
            graph.addEdge(pairs[i][0], pairs[i][1]);
        }

        int[][] minPath = graph.breadthFirstSearch(path_to);

        assertMatrixEquals(result, minPath);
        sout(graph);
        soutMatrix(minPath);

        assertEquals(connectedComponent, graph.amountOfConnectedComponent());
        sout("----------------------------------------------");
    }


}
