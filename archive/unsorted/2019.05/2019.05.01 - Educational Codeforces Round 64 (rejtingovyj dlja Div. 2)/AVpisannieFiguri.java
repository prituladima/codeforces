package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class AVpisannieFiguri {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();

        a = in.nextIntArray(n);
        ans = 0;
        for (int i = 1; i < n; i++) {
            if (checkInfinete(i)) {
                out.printLine("Infinite");
                return;
            }
            ans += get(i);
        }

        for(int i = 2; i < n ; i++){
            if(a[i-2] == 3 && a[i-1] == 1 && a[i] == 2) {
                ans --;
            }
        }

        out.printLine("Finite");
        out.printLine(ans);
    }

    private int get(int i) {
        if (a[i - 1] == 1 && a[i] == 2 || a[i - 1] == 2 && a[i] == 1)
            return 3;
        else
            return 4;
    }

    private boolean checkInfinete(int i) {
        return
//                a[i] == a[i - 1] ||
                (a[i] == 2 && a[i - 1] == 3) || (a[i] == 3 && a[i - 1] == 2);
    }

}