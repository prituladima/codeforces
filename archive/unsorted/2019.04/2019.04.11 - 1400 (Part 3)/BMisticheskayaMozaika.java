package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.prituladima.yaal.collections.SetUtil.areFullyIntersect;
import static com.prituladima.yaal.collections.SetUtil.areIntersect;

public class BMisticheskayaMozaika {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    char[][] M;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        m = in.nextInt();
        M = in.nextCharMatrix(n, m);

        Map<Integer, Set<Integer>> rowIndexSet = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Set<Integer> curSet = new HashSet<>();
            for (int j = 0; j < m; j++) {
                if (M[i][j] == '#') {
                    curSet.add(j);
                }
            }
            if (curSet.size() != 0)
                for (Set<Integer> prevSet : rowIndexSet.values()) {
                    if (prevSet.size() == 0) continue;
                    Set<Integer> toReataine1 = new HashSet<>(prevSet);
                    Set<Integer> toReataine2 = new HashSet<>(curSet);
                    int before1 = toReataine1.size();
                    int before2 = toReataine2.size();
                    toReataine1.retainAll(toReataine2);
                    boolean ok = (toReataine1.size() == 0 || (before1 == toReataine1.size() && before2 == toReataine1.size()));
                    if (!ok) {
                        out.printLine(NO);
                        return;
                    }
                }
            rowIndexSet.put(i, curSet);
        }

        rowIndexSet = new HashMap<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> curSet = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if (M[j][i] == '#') {
                    curSet.add(j);
                }
            }
            if (curSet.size() != 0)
                for (Set<Integer> prevSet : rowIndexSet.values()) {
                    if (prevSet.size() == 0) continue;
                    boolean ok = (!areIntersect (curSet, prevSet) || areFullyIntersect(curSet, prevSet));
                    if (!ok) {
                        out.printLine(NO);
                        return;
                    }
                }
            rowIndexSet.put(i, curSet);
        }

        out.printLine(YES);
    }


}