package com.prituladima.codeforce.contests.contest1105;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;


public class CAyubIUteryanniiMassiv {
    final long MODULO = (long) 1e9 + 7;
    int n;
    long L, R;
    int ans;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextInt();
        L = in.nextLong();
        R = in.nextLong();

        long div3 = R / 3 - (L - 1) / 3;
        long div_1 = div3 - 1 + ((L + 1) % 3 == 0 ? 1 : 0);
        long div_2 = div3 - 1 + ((R - 1) % 3 == 0 ? 1 : 0);
//        long div_3 = div3 - 1 + ((L + 2) % 3 == 0 ? 1 : 0);
//        long div_4 = div3 - 1 + ((R - 2) % 3 == 0 ? 1 : 0);

        long[][] dp = new long[n][3];
        dp[0][0] = div3;

        for (int i = 0; i < n; i++) {
            dp[i][0] = div3 * (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]);
            dp[i][0] %= MODULO;
            if (dp[i - 1][2] == 0)
                dp[i][1] = div_1;

            dp[i][2] = dp[i - 1][1];
        }

        out.println(ans);

    }

}