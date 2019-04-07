package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class GKPokraskaMassiva {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes".toUpperCase(), NO = "No".toUpperCase();
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        a = in.nextIntArray(n);
        pairs = new IntIntPair[n];
        for (int i = 0; i < pairs.length; i++) {
            pairs[i] = IntIntPair.makePair(a[i], i);
        }
        Arrays.sort(pairs);
        int[] coloredArray = new int[n];
        Map<Integer, List<Integer>> bucket = new HashMap<>();
        for (int i = 0; i < n; i++) {
            bucket.computeIfAbsent(i % k, k1 -> new ArrayList<>());
            bucket.get(i % k).add(pairs[i].first);
            coloredArray[pairs[i].second] = i % k;
        }
        for (int i = 0; i < k; i++) {
            List<Integer> values = bucket.get(i);
            Set<Integer> valuesUniq = new HashSet<>(values);
            if (valuesUniq.size() != values.size()) {
                out.printLine(NO);
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            coloredArray[i]++;
        }
        out.printLine(YES);
        out.printLine(coloredArray);
    }
}