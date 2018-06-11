package com.prituladima.geeksforgeeks.graphs;

import org.junit.Test;

/**
 * Created by prituladima on 6/12/18.
 */
public class GraphTest {

    @Test
    public void test() {

        int V = 5;
        Graph graph = new Graph(V);
        graph.addEdge(0, 1)
                .addEdge(0, 4)
                .addEdge(1, 2)
                .addEdge(1, 3)
                .addEdge(1, 4)
                .addEdge(2, 3)
                .addEdge(3, 4);

        System.out.println(graph);

    }

}