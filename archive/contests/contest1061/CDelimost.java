package com.prituladima.codeforce.contests.contest1061;

import static com.prituladima.codeforce.GeekDP.Pair;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;



public class CDelimost {
    final long MODULO = (long) 1e9 + 7;
    final int INF = (int) 1e9;
    int n, m;
    int[] a;
    long L, R;
    int ans;
    int min = INF, max = -INF;
    String s;
    private List<Pair> pairs = new ArrayList<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextInt();
        a = in.nextArr(n);


        int divCnt[] = new int[1000001];
        for(int i = 1000000; i >= 1; --i) {
            for(int j = i; j <= 1000000; j += i)
                divCnt[j]++;
        }

        int div[][] = new int[1000001][];
        for(int i = 1; i <= 1000000; ++i)
            div[i] = new int[divCnt[i]];

        int ptr[] = new int[1000001];
        for(int i = 1000000; i >= 1; --i) {
            for(int j = i; j <= 1000000; j += i)
                div[j][ptr[j]++] = i;
        }

        long mod = (long)1e9 + 7;

        long ans[] = new long[1000001];
        ans[0] = 1;

        for(int i = 0; i < n; ++i) {
            for(int j : div[a[i]]) {
                ans[j] = (ans[j] + ans[j - 1]) % mod;
            }
        }

        long fans = 0;
        for(int i = 1; i <= 1000000; ++i) {
            fans = (fans + ans[i]) % mod;
        }

        out.println(fans);

    }

}