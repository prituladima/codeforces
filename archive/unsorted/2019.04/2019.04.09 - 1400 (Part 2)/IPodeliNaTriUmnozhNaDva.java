package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class IPodeliNaTriUmnozhNaDva {
    int t, n, m, k, ans = 0;
    long INF = Long.MAX_VALUE, gg = 3 * (long) 3e18;
    long[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Long, Set<Long>> graph = new HashMap<>();
    Set<Long> usedSet = new HashSet<>();
    List<Long> res = new ArrayList<>();

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        a = in.nextLongArray(n);
        Set<Long> set = stream(a).boxed().collect(Collectors.toSet());
        for (int i = 0; i < n; i++) {
            long val = a[i];

            if (val % 3 == 0 && set.contains(val / 3)) {
                graph.computeIfAbsent(val, key -> new HashSet<>());
                graph.computeIfAbsent(val/3, key -> new HashSet<>());

                graph.get(val).add(val / 3);
                graph.get(val / 3).add(val);
            }

            if (val % 2 == 0 && set.contains(val / 2)) {
                graph.computeIfAbsent(val, key -> new HashSet<>());
                graph.computeIfAbsent(val/2, key -> new HashSet<>());

                graph.get(val).add(val / 2);
                graph.get(val / 2).add(val);
            }

            if (set.contains(val * 2)) {
                graph.computeIfAbsent(val, key -> new HashSet<>());
                graph.computeIfAbsent(val*2, key -> new HashSet<>());


                graph.get(val).add(val * 2);
                graph.get(val * 2).add(val);
            }

            if (set.contains(val * 3)) {
                graph.computeIfAbsent(val, key -> new HashSet<>());
                graph.computeIfAbsent(val*3, key -> new HashSet<>());


                graph.get(val).add(val * 3);
                graph.get(val * 3).add(val);
            }
        }

        for (long key : graph.keySet()) if (graph.get(key).size() == 1) dfs(key);

        if (res.get(0) / 3 == res.get(1) || res.get(0) * 2 == res.get(1)) {
            for (int i = 0; i < n; i++) {
                out.print(res.get(i)).printSpace();
            }
            out.printLine();
        } else {
            for (int i = n - 1; i >= 0; i--) {
                out.print(res.get(i)).printSpace();
            }
            out.printLine();
        }
    }

    private void dfs(long from) {
        usedSet.add(from);
        res.add(from);
        for (long to : graph.get(from)) if (!usedSet.contains(to)) dfs(to);
    }


}