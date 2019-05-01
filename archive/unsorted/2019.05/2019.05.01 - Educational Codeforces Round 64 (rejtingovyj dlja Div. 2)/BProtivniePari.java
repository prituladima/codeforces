package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class BProtivniePari {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        t = in.nextInt();
        while (t-- > 0) {
            s = in.nextToken().toCharArray();
            if (ok(s)) {
                out.printLine(String.valueOf(s));
            } else {
                char[] cl = s.clone();
                Arrays.sort(cl);
                StringBuilder sbEven = new StringBuilder();
                StringBuilder sbOdd = new StringBuilder();
                for (char ch : cl) {
                    if (ch % 2 == 0) {
                        sbEven.append(ch);
                    } else
                        sbOdd.append(ch);
                }

                final String pos1 = sbEven.toString() + sbOdd.toString();
                final String pos2 = sbOdd.toString() + sbEven.toString();

                if (ok(pos1.toCharArray())) {
                    out.printLine(pos1);
                } else if (ok(pos2.toCharArray())) {
                    out.printLine(pos2);
                } else {
                    out.printLine("No answer");
                }

            }
        }
    }

    private boolean ok(char[] s) {
        boolean ok = true;
        for (int i = 1; i < s.length; i++) {
            ok &= Math.abs(s[i - 1] - s[i]) != 1;
        }
        return ok;
    }
}