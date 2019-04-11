package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class CKlonirovanieIgrushek {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R, x, y;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        x = in.nextInt();
        y = in.nextInt();

        

        if (y == 1) {
            if (x == 0) {
                out.printLine(YES);
            } else {
                out.printLine(NO);
            }
        } else if (x - (y - 1) >= 0 && (x - (y - 1)) % 2 == 0 && y - 1 >= 0) {
            out.printLine(YES);
        } else {
            out.printLine(NO);
        }
    }
}

