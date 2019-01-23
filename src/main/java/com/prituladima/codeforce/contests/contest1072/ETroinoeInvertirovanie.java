package com.prituladima.codeforce.contests.contest1072;

import static com.prituladima.codeforce.GeekDP.Pair;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;



public class ETroinoeInvertirovanie {
    final long MODULO = (long) 1e9 + 9;
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
        m = in.nextInt();
        a = in.nextArr(n);
        s = in.nextToken();
        char[] chars = s.toCharArray();
        L = in.nextLong();
        R = in.nextLong();
        for (int i = 0; i < m; i++) pairs.add(new Pair(i, in.nextInt(), in.nextInt()));


        out.println(ans);

    }

}