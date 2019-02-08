package com.prituladima.codeforce.contests.contest1068;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;


public class DMassivBezLokalnihMaksimumov {
    int n;
    int[] a;
    long ans;
    long MOD = 998244353;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextInt();
        a = in.nextArr(n);
        for (int i = 0; i < a.length; i++) {
            a[i]--;
        }

        int MAX = 200;
        long[][] prev = new long[2][MAX];
        long[][] current = new long[2][MAX];

        if (a[0] != -2) {
            prev[0][a[0]] = 1;
        } else {
            for (int i = 0; i < MAX; i++) {
                prev[0][i] = 1;
            }
        }

        for (int i = 1; i < a.length; i++) {
            if (a[i] == -2) {
                long sum = 0;
                for (int j = 0; j < MAX; j++) {
                    current[0][j] = sum;
                    sum += prev[0][j] + prev[1][j];
                    sum %= MOD;
                }
                sum = 0;
                for (int j = MAX - 1; j >= 0; j--) {
                    sum += prev[1][j];
                    sum %= MOD;
                    current[1][j] = (sum + prev[0][j]) % MOD;
                }
            } else {
                for (int j = 0; j < a[i]; j++) {
                    current[0][a[i]] += prev[0][j] + prev[1][j];
                    current[0][a[i]] %= MOD;
                }

                current[1][a[i]] = prev[0][a[i]];
                for (int j = a[i]; j < MAX; j++) {
                    current[1][a[i]] += prev[1][j];
                    current[1][a[i]] %= MOD;
                }
            }
            prev = current;
            current = new long[2][MAX];
        }

        ans = 0;
        if (a[n - 1] != -2) {
            ans = (prev[1][a[n - 1]]) % MOD;
        } else {
            for (int i = 0; i < prev[0].length; i++) {
                ans = (ans + prev[1][i]) % MOD;
            }
        }

        out.println(ans);

    }

}