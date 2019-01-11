package com.prituladima.codeforce.contests.contest1099;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class ASnezhniiKom {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int w = in.nextInt(), h = in.nextInt();
        int u1 = in.nextInt(), d1 = in.nextInt();
        int u2 = in.nextInt(), d2 = in.nextInt();

        int ans = w;
        for (int i = h; i > 0; i--) {
            ans += i;
            if (i == d1) {
                ans = Math.max(0, ans - u1);
                continue;
            }
            if (i == d2) {
                ans = Math.max(0, ans - u2);
                continue;
            }

        }

        out.print(ans);

    }
}
