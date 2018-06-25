package com.prituladima.geeksforgeeks.graphs;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @see "http://e-maxx-ru.1gb.ru/algo/bfs"
 */
public class DirectedGraph {

    private int V;
    private LinkedList<Integer>[] adjListArray;

    public DirectedGraph(int v) {
        V = v;

        adjListArray = new LinkedList[V];

        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public DirectedGraph addEdge(int src, int dest) {
        adjListArray[src].addLast(dest);
        return this;
    }

    public int[][] breadthFirstSearch(int s) {
        return breadthFirstSearch(s, null);
    }

    public int[][] breadthFirstSearch(int s, boolean[] used) {
        if (used == null)
            used = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] d = new int[V];
        int[] p = new int[V];

        queue.push(s);
        used[s] = true;
        p[s] = -1;
        while (!queue.isEmpty()) {
            int from = queue.pop();
            for (int i = 0; i < adjListArray[from].size(); i++) {
                int to = adjListArray[from].get(i);
                if (!used[to]) {
                    used[to] = true;
                    queue.push(to);
                    p[to] = from;
                    d[to] = d[from] + 1;
                }
            }
        }

        int[][] path = new int[V][];
        for (int i = 0; i < V; i++) {
            if (!used[i]) {
                path[i] = null;
            } else {
                path[i] = new int[d[i]];
                int k = i;
                for (int j = path[i].length - 1; j >= 0; j--) {
                    path[i][j] = k;
                    k = p[k];
                }
            }
        }

        return path;
    }


    public int amountOfConnectedComponent() {
        boolean[] used = new boolean[V];
        int amount = 0;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                breadthFirstSearch(i, used);
                amount++;
            }
        }
        return amount;

    }

    public int[] motherVertexes() {
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            boolean[] used = new boolean[V];
            breadthFirstSearch(i, used);
            boolean mother = true;
            for (int j = 0; j < used.length; j++) {
                if (!used[j]) {
                    mother = false;
                    break;
                }
            }
            if(mother){
                arr.add(i);
            }
        }
        int[] res = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            res[i] = arr.get(i);
        }

        return res;
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
