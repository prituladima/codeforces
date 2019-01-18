package com.prituladima.codeforce.contests.contest1061;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
public class BEksponat {
    int n, m;
    int[] a;
    long ans;
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        a = in.nextArr(n);
        long sum = 0;
        for (int i : a) sum += i;
        GeekInteger.save_sort(a);
        int h = 0;
        for (int i = 0; i < n ; i++) {
            if (h < a[i]) h++;
        }
        int need = (a[n - 1] - h) + n;
        out.println(sum - need);
    }
}