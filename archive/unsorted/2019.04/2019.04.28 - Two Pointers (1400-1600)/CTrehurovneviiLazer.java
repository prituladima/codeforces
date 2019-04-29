package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class CTrehurovneviiLazer {
    int U, t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b, E;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    double res = -1.0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        U = in.nextInt();
        E = in.nextIntArray(n);
        if (false)
            //OK
            for (int j = 1; j < n - 1; j++) {
                int max = max_(0, n - 1, E, E[j - 1] + U);
                if (max < n && E[max] > E[j]) {
                    res = Math.max(res, ((double) E[max] - E[j]) / (E[max] - E[j - 1]));
                }

            }

        if (false)
            //WRONG
            for (int k = n - 1; k >= 2; k--) {
                int i = minI(E, E[k], k - 1);
                if (i != -1 && i != k - 1) {
                    res = Math.max(res, ((double) E[k] - E[i + 1]) / (E[k] - E[i]));
                }
            }

        if(true) {
            //OK
            int j = 1;
            int k = 2;
            for(int i = 0;  i < n - 2; i++){
                while (k + 1 < n && E[k + 1] - E[i] <= U) k++;
                j = i + 1;
                if(i < j && j < k && E[k] - E[i] <= U)
                res = Math.max(res, ((double) E[k] - E[j]) / (E[k] - E[i]));
            }
        }

        if (res == Double.POSITIVE_INFINITY || res == -1.0) out.printNoAns();
        else out.printLine(res);

    }

    private int max_(int L, int R, int[] arr, int value) {
        int ans = -1;
        while (L <= R) {
            int M = (L + R) >>> 1;
            if (arr[M] <= value) {
                ans = M;
                L = M + 1;
            } else {
                R = M - 1;
            }
        }
        return ans;
    }


    private int minI(int[] E, int value, int finish) {
        int ind = -1;
        int L = 0;
        int R = finish;
        while (L <= R) {
            int M = (L + R) >>> 1;
            if (U >= value - E[M]) {
                ind = M;
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return ind;
    }

}