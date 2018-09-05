package com.prituladima.stankevich;

import java.util.ArrayList;
import java.util.LinkedList;

public class GeeksGraphs {

    int n = 500;
    LinkedList<Integer>[] graph = new LinkedList[n + 1];

    boolean[] used = new boolean[n + 1];
    int[] color = new int[n + 1];


    private void dfs(int dest) {
        used[dest] = true;
        for (int to : graph[dest])
            if (!used[to])
                dfs(to);
    }


    private void dfs_color(int dest) {
        color[dest] = 1;
        for (int to : graph[dest])
            if (color[to] == 0)
                dfs(dest);
        color[dest] = 2;
    }

    ArrayList<Integer> cycle = new ArrayList<>();
    int endOfCycle = -1;

    private void dfs_find_cycles(int dest) {
        color[dest] = 1;
        for (int to : graph[dest]) {
            if (color[to] == 0) {
                dfs(to);
            }
            if (color[to] == 1) {
                endOfCycle = to;
            }
            if (endOfCycle != -1) {
                cycle.add(dest);
            }
            if (dest == endOfCycle) {
                endOfCycle = -1;
            }
        }
        color[dest] = 2;
    }
}