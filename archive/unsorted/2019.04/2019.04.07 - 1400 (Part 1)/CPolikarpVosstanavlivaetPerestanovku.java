package com.prituladima.codeforce;

import com.prituladima.geeksforgeeks.dp.DynamicProgramming;
import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class CPolikarpVosstanavlivaetPerestanovku {
    int INF = Integer.MAX_VALUE;
    int t, n, m, ans;
    int[] q, arrayAns, P, ans2;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    int minLeftInd = -1, minRightInd = -1;
    int maxLeftInd = -1, maxRightInd = -1;

    long maxDiff = -INF;
    long minDiff = -INF;

    long curDiff = 0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        q = in.nextIntArray(n - 1);

        P = new int[n];

        int[] kadane_max_full = DynamicProgramming.kadane_max_full(q, n - 1);
        int[] kadane_min_full = DynamicProgramming.kadane_min_full(q, n - 1);

        maxDiff = kadane_max_full[0];
        maxLeftInd = kadane_max_full[1];
        maxRightInd = kadane_max_full[2];

        minDiff = kadane_min_full[0];
        minLeftInd = kadane_min_full[1];
        minRightInd = kadane_min_full[2];

        if (maxDiff == n - 1) {
            P[maxLeftInd] = 1;
            P[maxRightInd + 1] = n;
            fill(maxLeftInd, maxRightInd);
        } else if (minDiff == 1 - n) {
            P[minLeftInd] = n;
            P[minRightInd + 1] = 1;
            fill(minLeftInd, minRightInd);
        } else {
            out.printNoAns();
            return;
        }
        boolean ok = GeekInteger.uniq(P).length == n;
        for (int i = 0; i < n; i++){
            ok &= 0 < P[i] && P[i] <= n;
        }
        if (ok)
            out.print(P);
        else out.printNoAns();
    }

    private void fill(int L, int R) {
        for (int i = L - 1; i >= 0; i--) {
            P[i] = P[i + 1] - q[i];
        }
        for (int i = L + 1; i < R + 1; i++) {
            P[i] = P[i - 1] + q[i - 1];
        }
        for (int i = R + 2; i < n; i++) {
            P[i] = P[i - 1] + q[i - 1];
        }
    }
}