package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;

public class AOpyatOgranicheniya {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        final int n = in.nextInt();
        final int h = in.nextInt();
        int m = in.nextInt();

        int[] houses = new int[n + 1];
        Arrays.fill(houses, h);
        while (m-- > 0) {
            int L = in.nextInt();
            int R = in.nextInt();
            int MAX = in.nextInt();
            for(int i = L; i <= R; i++){
                houses[i] = Math.min(houses[i], MAX);
            }
        }
        long ans = 0;
        for (int i = 1; i < houses.length; i++) {
            ans += houses[i] *houses[i];
        }
        out.printLine(ans);

    }
}