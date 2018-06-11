package com.prituladima.geeksforgeeks.graphs;

import java.util.LinkedList;

/**
 * @see "https://www.geeksforgeeks.org/graph-and-its-representations/"
 */
public class Graph {

    private int V;
    private LinkedList<Integer>[] adjListArray;

    public Graph(int v) {
        V = v;

        adjListArray = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public Graph addEdge(int src, int dest) {
        adjListArray[src].addLast(dest);
        adjListArray[dest].addLast(src);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int v = 0; v < V; v++) {
            stringBuilder.append(v);
            for (Integer pCrawl : adjListArray[v]) {
                stringBuilder.append("-> " + pCrawl);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
