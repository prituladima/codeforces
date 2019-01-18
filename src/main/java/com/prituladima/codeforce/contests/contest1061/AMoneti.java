package com.prituladima.codeforce.contests.contest1061;

import static com.prituladima.codeforce.GeekDP.Pair;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;



public class AMoneti {
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

        ans = GeekInteger.ceiling(m, n);

        out.println(ans);

    }

}