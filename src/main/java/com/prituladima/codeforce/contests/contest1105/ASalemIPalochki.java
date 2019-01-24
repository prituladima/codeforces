package com.prituladima.codeforce.contests.contest1105;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;


public class ASalemIPalochki {
    int n, m;
    int[] a;
    int ansT, R;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextInt();
        a = in.nextArr(n);

        int result = Integer.MAX_VALUE;
        ansT = 0;
        for (int t = 1; t < 101; t++) {
            int curSum = 0;
            for (int j = 0; j < n; j++) {
                curSum += Math.max(Math.abs(t - a[j]) - 1, 0);
            }

            if (curSum < result) {
                ansT = t;
                result = curSum;
            }
        }

        out.println(ansT + " " + result);

    }

}