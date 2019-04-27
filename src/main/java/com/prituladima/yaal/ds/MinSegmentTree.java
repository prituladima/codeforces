package com.prituladima.yaal.ds;

import java.util.Arrays;

public class MinSegmentTree {

    int INF = Integer.MAX_VALUE;
    private int n;
    private int[] t;

    public MinSegmentTree(int[] a) {
        n = a.length;
        t = new int[4 * n];
        Arrays.fill(t, INF);
        build(a, 1, 0, n - 1);
    }

    public int min(int l, int r) {
        return min(1, 0, n - 1, l, r);
    }

    public void update(int pos, int new_val) {
        update(1, 0, n - 1, pos, new_val);
    }

    private void build(int a[], int v, int tl, int tr) {
        if (tl == tr)
            t[v] = a[tl];
        else {
            int tm = (tl + tr) / 2;
            build(a, v * 2, tl, tm);
            build(a, v * 2 + 1, tm + 1, tr);
            t[v] = Math.min(t[v * 2], t[v * 2 + 1]);
        }
    }

    private int min(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return INF;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return Math.min(min(v * 2, tl, tm, l, Math.min(r, tm)),
                min(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
    }

    private void update(int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr)
            t[v] = new_val;
        else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v * 2, tl, tm, pos, new_val);
            else
                update(v * 2 + 1, tm + 1, tr, pos, new_val);
            t[v] = Math.min(t[v * 2], t[v * 2 + 1]);
        }
    }


}
