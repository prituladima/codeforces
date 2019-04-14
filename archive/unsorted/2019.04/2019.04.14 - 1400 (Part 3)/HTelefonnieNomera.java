package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class HTelefonnieNomera {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        t = n = in.nextInt();
        Map<String, Set<String>> map = new HashMap<>();
        while (t-- > 0) {
            String name = in.nextToken();
            int amount = in.nextInt();
            map.computeIfAbsent(name, key -> new HashSet<>());
            while (amount-- > 0) map.get(name).add(in.nextToken());

            //all suffixes of string


        }

        out.printLine(map.keySet().size());
        for (String name : map.keySet()) {
            List<String> list = new ArrayList<>(map.get(name));
            list.sort(Comparator.reverseOrder());
            for (String cur : list) {
                for (int i = 1; i < cur.length(); i++) {
                    map.get(name).remove(cur.substring(i, cur.length()));
                }
            }
            out.print(name).printSpace().print(map.get(name).size()).printSpace();
            out.printListInOneLine(map.get(name));
            out.printLine();
        }


    }

}