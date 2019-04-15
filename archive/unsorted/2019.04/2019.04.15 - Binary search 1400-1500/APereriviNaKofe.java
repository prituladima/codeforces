package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class APereriviNaKofe {
    int d, t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        d = in.nextInt();
        a = in.nextIntArray(n);

        Map<Integer, Integer> valIndexRestore = valueToIndex(a);
        GeekInteger.save_sort(a);
        int[] numberOfSet = new int[n];
        int amountOfSet = 0;
        int[] res = new int[n];
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[j] >= a[i] - d) {
                amountOfSet++;
                numberOfSet[i] = amountOfSet;
            } else {
                numberOfSet[i] = numberOfSet[j];
                j++;
            }
            int oldIndex = valIndexRestore.get(a[i]);
            res[oldIndex] = numberOfSet[i];
        }
        out.printLine(amountOfSet);
        out.printLine(res);
    }

    private Map<Integer, Integer> valueToIndex(int[] a) {
        Map<Integer, Integer> res = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            res.put(a[i], i);
        }
        return res;
    }

}