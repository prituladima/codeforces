package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LMahmudEhabIDvudolnost {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    Set<Integer> LEFT = new HashSet<>();
    Set<Integer> RIGHT = new HashSet<>();
    long longAns = 0;
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        used = new boolean[2 * n];
        for (int i = 0; i < n-1; i++) {
            int from = in.nextInt();
            int to = in.nextInt();
            graph.computeIfAbsent(from - 1, key -> new HashSet<>());
            graph.computeIfAbsent(to - 1, key -> new HashSet<>());
            graph.get(from - 1).add(to - 1);
            graph.get(to - 1).add(from - 1);
        }
        dfs(0, 0);

        if(LEFT.size() + RIGHT.size() != n) throw new AssertionError();
        for (int curLeft : LEFT) {
            longAns += (RIGHT.size() - graph.get(curLeft).size());
        }
        out.printLine(longAns);

    }

    private void dfs(int from, int deep) {
        if (deep % 2 == 0) LEFT.add(from);
        else RIGHT.add(from);
        used[from] = true;
        for (int to : graph.getOrDefault(from, new HashSet<>()))
            if (!used[to]) dfs(to, deep+1);
    }

}