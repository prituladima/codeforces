package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class BQueen {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph = new HashMap<>();
    int[] respect;
    Set<Integer> toDelete = new HashSet<>();

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        used = new boolean[n + 1];
        respect = new int[n + 1];
        int root = -1;
        for (int i = 0; i < n; i++) {
            int to = in.nextInt();
            if (to != -1) {
                graph.computeIfAbsent(i + 1, (key) -> new HashSet<>());
                graph.computeIfAbsent(to, (key) -> new HashSet<>());
                graph.get(i + 1).add(to);
                graph.get(to).add(i + 1);
            } else {
                root = i + 1;
            }
            respect[i + 1] = in.nextInt();
        }

        dfs(root);

        ArrayList<Integer> anss = new ArrayList<>(toDelete);
        anss.sort(Comparator.naturalOrder());
        if (anss.size() != 0) {
            for (int val : anss) {
                out.print(val).printSpace();
            }
            out.printLine();
        } else out.printNoAns();

    }

    private void dfs(int from) {
        used[from] = true;

        boolean match = respect[from] == 1;
        for (int to : graph.getOrDefault(from, new HashSet<>())) {
            if (!used[to]) {
                match &= respect[to] == 1;
                dfs(to);
            }
        }
        if (match) toDelete.add(from);
    }


}