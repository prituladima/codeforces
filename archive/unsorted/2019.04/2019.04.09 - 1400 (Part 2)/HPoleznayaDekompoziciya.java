package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class HPoleznayaDekompoziciya {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used = new boolean[(int) 1e5];
    Map<Integer, Set<Integer>> graph = new HashMap<>();

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        graph = in.readTree(n - 1);

        int amount = 0;
        int keey = -1;
        for (int key : graph.keySet()) {
            if (graph.get(key).size() > 2) {
                amount++;
                keey = key;
            }
        }
        if (amount >= 2) {
            out.printLine(NO);
        } else if (amount == 1) {
            out.printLine(YES);
            List<Integer> set = new ArrayList<>();
            for (int key : graph.keySet()) {
                if (graph.get(key).size() == 1) set.add(key);
            }
            out.printLine(set.size());
            for (int i = 0; i < set.size(); i++)
                out.printFormat("%d %d\n", set.get(i), keey);
        } else {
            out.printLine(YES);
            out.printLine(1);
            List<Integer> set = new ArrayList<>();
            for (int key : graph.keySet()) {
                if (graph.get(key).size() == 1) set.add(key);
            }
            out.printFormat("%d %d\n", set.get(0), set.get(1));
        }


    }

    private void dfs(int from) {
        used[from] = true;
        Set<Integer> set = graph.getOrDefault(from, new HashSet<>());
        if (set.size() == 3)
            for (int to : set) if (!used[to]) dfs(to);
    }

}