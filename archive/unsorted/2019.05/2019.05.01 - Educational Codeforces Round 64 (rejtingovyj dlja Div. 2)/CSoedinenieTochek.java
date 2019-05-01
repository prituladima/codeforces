package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;

public class CSoedinenieTochek {

    int z, n, ans;
    int[] x;


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        z = in.nextInt();
        x = in.nextIntArray(n);
        Arrays.sort(x);

        ans = 0;
        for (int i = n / 2, j = 0; i < n; i++) {
            if (j >= n / 2) break;
            if (x[i] - x[j] >= z) {
                ans++;
                j++;
            }

        }
        out.printLine(ans);
    }

}