package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class DNastyaIdetVStolovuyu {
    int n, m;
    int[] array;
    IntIntPair[] pairs;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        array = in.nextIntArray(n);
        int last = array[array.length - 1];
        pairs = in.nextIntPairArray(m);
        Set<IntIntPair> pairsSet = new HashSet<>(Arrays.asList(pairs));
        Map<Integer, Set<Integer>> optimized = new HashMap<>();
        for (IntIntPair intIntPair : pairsSet) {
            int first = intIntPair.getFirst();
            int second = intIntPair.getSecond();
            optimized.computeIfAbsent(first, k -> new HashSet<>());
            optimized.get(first).add(second);
        }

        Set<Integer> P = new HashSet<>();
        for (int i = array.length - 2; i >= 0; i--) {
            boolean acceptAll = true;
            Set<Integer> opt = optimized.get(array[i]);
            if (opt != null) {
                for (Integer j : P) {
                    acceptAll &= opt.contains(j);
                    if(!acceptAll) break;
                }
                acceptAll &= opt.contains(last);
            }
            if (!acceptAll || opt == null) P.add(array[i]);
        }
        out.printLine(n - 1 - P.size());
    }
}