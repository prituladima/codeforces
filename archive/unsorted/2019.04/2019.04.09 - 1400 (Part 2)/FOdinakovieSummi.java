package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FOdinakovieSummi {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes".toUpperCase(), NO = "No".toUpperCase();
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    Map<Integer, IntIntPair> sums = new HashMap<>();
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        k = in.nextInt();
        for(int i = 0; i < k; i++){
            n = in.nextInt();
            a = in.nextIntArray(n);
            int[] rem = GeekInteger.calculateRemSum(GeekInteger.calculatePrefixSum(a), GeekInteger.calculateSuffixSum(a));
            for(int j = 0; j < rem.length; j++){
                if(sums.containsKey(rem[j]) && sums.get(rem[j]).first != i+1){
                    IntIntPair intIntPair = sums.get(rem[j]);
                    out.printLine(YES);
                    out.printFormat("%d %d\n", intIntPair.first, intIntPair.second);
                    out.printFormat("%d %d\n", i+1, j+1);
                    return;
                }else {
                    sums.put(rem[j], IntIntPair.makePair(i+1, j+1));
                }
            }
        }

        out.printLine(NO);
    }

}