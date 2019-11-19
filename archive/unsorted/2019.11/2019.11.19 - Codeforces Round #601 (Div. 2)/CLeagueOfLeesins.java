package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class CLeagueOfLeesins {
    private static final boolean MULTI_TEST = false;

    private void solve(InputReader in, OutputWriter out) {

        int n = in.nextInt() - 2;
        int[][] a = in.nextIntMatrix(n, 3);
        int[] ms = new int[n + 20];
        for (int i = 0; i < a.length; i++) {
            ms[a[i][0]]++;
            ms[a[i][1]]++;
            ms[a[i][2]]++;
        }

        //find first
        //find last
        int f = 0, l = 0;
        for (int i = 0; i < ms.length; i++) {
            if (ms[i] == 1) {
                if (f == 0) {
                    f = i;
                } else {
                    l = i;
                }
            }
        }

        Set<Integer> found = new HashSet<>();
        found.add(f);
        found.add(l);

        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(a[i][0], new HashSet<>());
            graph.putIfAbsent(a[i][1], new HashSet<>());
            graph.putIfAbsent(a[i][2], new HashSet<>());

            graph.get(a[i][0]).add(a[i][1]);
            graph.get(a[i][0]).add(a[i][2]);

            graph.get(a[i][1]).add(a[i][0]);
            graph.get(a[i][1]).add(a[i][2]);

            graph.get(a[i][2]).add(a[i][0]);
            graph.get(a[i][2]).add(a[i][1]);

        }


        List<Integer> res = new ArrayList<>();
        dfs(res, graph, f, found);

//        int k01 = res.get(res.size() - 2);
//        int k02 = res.get(res.size() - 1);
//        final Iterator<Integer> iterator = graph.keySet().iterator();
//        int k1 = iterator.next();
//        int k2 = iterator.next();
//        int k3 = iterator.next();
//        Set<Integer> set = new HashSet<>(Arrays.asList(k1, k2, k3));
//        set.remove(l);
//        for(int i = 0; i < n + 2;  i++){
//
//        }

        for (int i = 1; i <= n+2; i++) {
            if (!found.contains(i)) {
                res.add(i);
                res.add(l);
                break;
            }

        }


        int k00 = res.get(res.size() - 1);
        int k01 = res.get(res.size() - 2);
        int k02 = res.get(res.size() - 3);
        int k03 = res.get(res.size() - 4);
        int k04 = res.get(res.size() - 5);

        int     valid = 0;
        Set<Integer> set1 = new HashSet<>(Arrays.asList(k00, k01, k02));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(k01, k02, k03));
        Set<Integer> set3 = new HashSet<>(Arrays.asList(k02, k03, k04));
        for(int i = 0; i < n; i ++){
            if(set1.contains(a[i][0]) && set1.contains(a[i][1]) && set1.contains(a[i][2])) valid++;
            else if(set2.contains(a[i][0]) && set2.contains(a[i][1]) && set2.contains(a[i][2])) valid++;
            else if(set3.contains(a[i][0]) && set3.contains(a[i][1]) && set3.contains(a[i][2])) valid++;
        }


        if(valid != 3){
            int b1 = res.get(res.size() - 2);
            int b2 = res.get(res.size() - 3);
            res.set(res.size() - 2, b2);
            res.set(res.size() - 3, b1);
        }
        for (int i = 0; i < res.size(); i++) {
            out.print(res.get(i) + " ");
        }

    }

    private void dfs(List<Integer> res, Map<Integer, Set<Integer>> graph, int f, Set<Integer> found) {
        res.add(f);
        found.add(f);
        final Set<Integer> neg = graph.get(f);
        graph.remove(f);
        for (Integer to : neg) {
            graph.get(to).remove(f);
        }

//        if(graph.size() == 3) return;

        for (Integer to : neg) {
            if (graph.get(to).size() == 2) {
                dfs(res, graph, to, found);
                break;
            }
        }


    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = MULTI_TEST ? in.nextInt() : 1;
        while (t-- > 0) {
            solve(in, out);
        }
    }

}
