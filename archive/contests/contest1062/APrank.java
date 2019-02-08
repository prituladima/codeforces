package com.prituladima.codeforce.contests.contest1062;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.prituladima.codeforce.GeekDP.Pair;
import static java.lang.Math.max;


public class APrank {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    int n, m;
    int[] a;
    long L, R;
    int ans = Integer.MIN_VALUE;
    int min = INF, max = -INF;
    String s;
    private List<Pair> pairs = new ArrayList<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextInt();
//        a = in.nextArr(n);
        a = new int[n + 4];
        for (int i = 2; i < n + 2; i++) {
            a[i] = in.nextInt();
        }
        a[0] = -INF;
        a[1] = 0;
        a[n + 2] = 1001;
        a[n + 3] = INF;

//        System.out.println(Arrays.toString(a));

        int cur_ans = 0;
        for (int k = 0; k < a.length - 1; k++) {
            if (a[k] + 1 == a[k + 1]) cur_ans++;
            else cur_ans = 0;

            ans = max(ans, cur_ans);
        }


        out.println(max(ans - 1, 0));

    }

}