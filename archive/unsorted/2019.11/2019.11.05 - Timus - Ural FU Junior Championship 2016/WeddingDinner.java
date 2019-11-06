package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class WeddingDinner {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        long ans = 2;
        for (int i = 0; i < n; i++) {
            String g = in.nextToken();
            ans++;
            if (g.contains("+")) {
                ans++;
            }
        }
        if (ans == 13) ans++;

        out.println(ans * 100);

    }
}
