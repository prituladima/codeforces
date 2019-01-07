package com.prituladima.codeforce.contests.contest1084;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class AOrehusILift {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt();
        int[] a = in.nextArr(n);

        int ans = Integer.MAX_VALUE;
        for (int x = 1; x <= n; x++) {
            int cur_sum = 0;
            for (int i = 1; i <= n; i++) {
//                if (x != i) {
                    cur_sum += 4 * (Math.max(i ,  x) -1) * a[i - 1];
//                }
//                cur_sum += 2 * (i - 1) * a[i - 1];
            }
            ans = Math.min(ans, cur_sum);
        }

        out.println(ans);
    }
}
