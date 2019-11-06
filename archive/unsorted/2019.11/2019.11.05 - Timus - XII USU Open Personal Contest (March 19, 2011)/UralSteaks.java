package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class UralSteaks {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int ans = solve(n, k);
        assert 2 <= ans && ans <= 2 * n;
        out.println(ans);
    }

    private int solve(int n, int k) {
        if (n / k > 0)
            return 2 * (n / k) + (2 * (n % k) + k - 1) / k;
        else {
            return 2;
        }
    }
}