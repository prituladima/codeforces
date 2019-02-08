package com.prituladima.codeforce.contests.contest1065;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class CViravnivaemVisoti {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        int[] h = in.nextArr(n);
        GeekInteger.save_sort(h);
        reverce(h);
        int ans = 0;
        int[] gh = new int[n - 1];
        int curSum = 0;
        for (int i = 0; i < gh.length; i++) {
            gh[i] = (h[i] - h[i + 1]) * (i + 1);

            for (int j = 1; j <= (h[i] - h[i + 1]); j++) {
                curSum += i + 1;
                if (k - curSum < 0) {
                    ans++;
                    curSum = i + 1;
                }

                if (k - curSum == 0) {
                    ans++;
                    curSum = 0;
                }
            }
        }
        if (curSum > 0) ans++;
        out.println(ans);
    }

    private void reverce(int[] a) {
        for (int i = 0, j = a.length - 1; i < j; i++, j--) {
            int c = a[i];
            a[i] = a[j];
            a[j] = c;
        }
    }
}