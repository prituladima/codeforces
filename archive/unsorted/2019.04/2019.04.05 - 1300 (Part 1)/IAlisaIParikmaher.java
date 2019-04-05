package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class IAlisaIParikmaher {
    int INF = Integer.MAX_VALUE;
    int t, n, m, k, ans, l;
    long[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        l = in.nextInt();
        a = in.nextLongArray(n);

        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] > l) {
                if (i + 1 == n || a[i + 1] <= l) {
                    answer++;//amount of ranges
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int t = in.nextInt();
            if (t == 0) {
                out.printLine(answer);
            } else {
                int p = in.nextInt() - 1;
                int d = in.nextInt();
                if (a[p] <= l && a[p] + d > l) {
                    answer++;
                    if (p > 0 && a[p - 1] > l) {
                        answer--;
                    }
                    if (p + 1 < n && a[p + 1] > l) {
                        answer--;
                    }
                }
                a[p] += d;
            }
        }
    }


}