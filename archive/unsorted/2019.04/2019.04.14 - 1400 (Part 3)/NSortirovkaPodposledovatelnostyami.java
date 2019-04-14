package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class NSortirovkaPodposledovatelnostyami {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;

    Map<Integer, Set<Integer>> graph = new HashMap<>();
    boolean[] used;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        a = in.nextIntArray(n);
        b = a.clone();
        used = new boolean[ n+20];
        Arrays.sort(b);

        Map<Integer, Integer> ValueToInd = new HashMap<>();
        for (int i = 0; i < n; i++) {
            ValueToInd.put(b[i], i);
        }

        for (int i = 0; i < n; i++) {
            int j = ValueToInd.get(a[i]);
            graph.computeIfAbsent(i + 1, key -> new HashSet<>());
            graph.computeIfAbsent(j + 1, key -> new HashSet<>());
            graph.get(j + 1).add(i + 1);
            graph.get(i + 1).add(j + 1);
        }

        ArrayList<Set<Integer>> res = new ArrayList<>();
        for (int from = 1; from <= n; from++) {
            if (!used[from]) {
                Set<Integer> curRes = new HashSet<>();
                dfs(from, curRes);
                res.add(curRes);
            }
        }

        int size = res.size();
        out.printLine(size);
        for (Set<Integer> re : res) {
            out.print(re.size()).space().printListInOneLine(re).printLine();
        }
    }

    private void dfs(int from, Set<Integer> compMember) {
        compMember.add(from);
        used[from] = true;
        for (int to : graph.getOrDefault(from, new HashSet<>())) {
            if (!used[to]) dfs(to, compMember);
        }
    }
}