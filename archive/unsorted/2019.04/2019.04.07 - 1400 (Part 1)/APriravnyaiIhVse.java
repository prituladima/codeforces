package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class APriravnyaiIhVse {
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
        if (n == 1) {
            out.printLine(0);
            return;
        }

        a = in.nextIntArray(n);

        Map<Integer, Integer> ms = GeekInteger.multiSet(a);
        ans = -INF;
        int pl = 0;
        for (int key : ms.keySet()) {
            int value = ms.get(key);
            if (value > ans) {
                ans = value;
                pl = key;
            }
        }

        int start = -1;
        for (int i = 0; i < n; i++) {
            if (pl == a[i]) {
                start = i;
            }
        }

        int levelFromR = a[start];
        int curAnsR = 0;
        for (int i = start - 1; i >= 0; i--) {
            if (levelFromR != a[i]) {
                curAnsR++;
            }
        }

        int levelFromL = a[start];
        int curAnsL = 0;
        for (int i = start + 1; i < n; i++) {
            if (levelFromL != a[i]) {
                curAnsL++;
            }
        }



        out.printLine(curAnsR + curAnsL);
        for (int i = start - 1; i >= 0; i--) {
            if (levelFromR < a[i]) {
                out.printFormat("%d %d %d\n", 2, i + 1, i + 2);
            } else if (levelFromR > a[i]) {
                out.printFormat("%d %d %d\n", 1, i + 1, i + 2);
            }
        }
        for (int i = start + 1; i < n; i++) {
            if (levelFromL < a[i]) {
                out.printFormat("%d %d %d\n", 2, i + 1, i);
            } else if (levelFromL > a[i]) {
                out.printFormat("%d %d %d\n", 1, i + 1, i);
            }
        }
//        }
    }
}