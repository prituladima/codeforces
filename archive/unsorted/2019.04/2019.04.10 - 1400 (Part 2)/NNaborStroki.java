package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class NNaborStroki {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        s = in.nextToken();
        chars = s.toCharArray();
        ans = 0;
        for (int i = n / 2; i >= 0; i--) {
            String a = String.valueOf(Arrays.copyOfRange(chars, 0, i));
            String b = String.valueOf(Arrays.copyOfRange(chars, i , 2 * i ));
            if(Objects.equals(a, b)) {
                ans = i;
                break;
            }
        }

        out.printLine(Math.min(n, n - ans + 1));

    }

}