package com.prituladima.timus;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class Task1930 {

    /**
     * O(n!) - https://www.geeksforgeeks.org/find-paths-given-source-destination/
     * O(?) - https://www.geeksforgeeks.org/print-paths-given-source-destination-using-bfs/
     */

    private Map<Integer, Set<Integer>> graph = new HashMap<>();
    private Map<Integer, Set<Integer>> up = new HashMap<>();
    private Map<Integer, Set<Integer>> down = new HashMap<>();

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int vertexCount = in.nextInt(), edgeCount = in.nextInt();
        for (int vertex = 1; vertex <= vertexCount; vertex++) {
            graph.put(vertex, new HashSet<>());
            up.put(vertex, new HashSet<>());
            down.put(vertex, new HashSet<>());
        }

        for (int i = 0; i < edgeCount; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            graph.get(from).add(to);
            graph.get(to).add(from);

            up.get(from).add(to);
            down.get(to).add(from);
        }

        int from = in.nextInt();
        int dest = in.nextInt();

        Arrays.fill(minDist, Integer.MAX_VALUE);

        countPathsUtil(-1, from, dest, visited, 0);
        out.println(minCost);

    }


    private int minCost = Integer.MAX_VALUE;
    private int MAXN = 10010;
    private boolean[] visited = new boolean[MAXN];
    private int[] minDist = new int[MAXN];

    private void countPathsUtil(int prev, int from, int dest, boolean[] visited, int curCost) {



        visited[from] = true;

        if (from == dest) {
            minCost = Math.min(minCost, curCost);
        } else {
            for (int to : graph.get(from))
                if (!visited[to]) {
                    //Updating count prev - from - to
                    final boolean toggle = prev != -1 && ((up.get(prev).contains(from) && down.get(from).contains(to)) || (down.get(prev).contains(from) && up.get(from).contains(to)));

                    if (toggle) {
                        curCost++;
                    }

                    if(curCost < minDist[to]) {
                        countPathsUtil(from, to, dest, visited, curCost);
                        minDist[to] = curCost;
                    }

                    if (toggle) {
                        curCost--;
                    }
                }

        }



        visited[from] = false;
        minDist[from] = Math.min(minDist[from], curCost);
    }


}
