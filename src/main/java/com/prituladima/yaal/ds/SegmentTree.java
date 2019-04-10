package com.prituladima.yaal.ds;

import com.prituladima.Reliable;

import java.util.Arrays;

@Reliable
public class SegmentTree {

    private long DEFAULT = (long) -1e18;
    private long[] t, len, sum, add_mod, set_mod;
    private int n;

    public SegmentTree(long[] a) {
        n = a.length;
        t = new long[4 * n];
        sum = new long[4 * n];
        add_mod = new long[4 * n];
        set_mod = new long[4 * n];
        Arrays.fill(set_mod, DEFAULT);
        len = new long[4 * n];
        build(a, 1, 0, n - 1);
    }

    public void addOnTheRange(int l, int r, long val) {
        addOnTheRange(l, r, val, 1, 0, n - 1);
    }

    public void setOnTheRange(int l, int r, long val) {
        setOnTheRange(l, r, val, 1, 0, n - 1);
    }

    public long getSum(int l, int r) {
        return getSum(l, r, 1, 0, n - 1);
    }

    public int lowerBound(long val) {
        if (getValue(1) < val) {
            return n;
        } else {
            return lowerBound(val, 1, 0, n - 1);
        }
    }


    private void build(long[] a, int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = sum[v] = a[tl];
            len[v] = 1;
        } else {
            int tm = (tl + tr) >> 1;
            build(a, v * 2, tl, tm);
            build(a, v * 2 + 1, tm + 1, tr);
            t[v] = Math.max(t[v * 2], t[v * 2 + 1]);
            sum[v] = sum[v * 2] + sum[v * 2 + 1];
            len[v] = (tr - tl + 1);
        }
    }


    private void applyAddMod(int v, long val) {
        if (set_mod[v] != DEFAULT) {
            set_mod[v] += val;
        } else {
            add_mod[v] += val;
        }
    }

    private void applySetMod(int v, long val) {
        add_mod[v] = 0;
        set_mod[v] = val;
    }

    private void push(int v) {
        assert (add_mod[v] == 0 || set_mod[v] == DEFAULT);
        if (add_mod[v] != 0) {
            t[v] += add_mod[v];
            sum[v] += add_mod[v] * len[v];
            applyAddMod(v * 2, add_mod[v]);
            applyAddMod(v * 2 + 1, add_mod[v]);
            add_mod[v] = 0;
        }
        if (set_mod[v] != DEFAULT) {
            t[v] = set_mod[v];
            sum[v] = set_mod[v] * len[v];
            applySetMod(v * 2, set_mod[v]);
            applySetMod(v * 2 + 1, set_mod[v]);
            set_mod[v] = DEFAULT;
        }
    }

    private long getSum(int v) {
        if (set_mod[v] != DEFAULT) {
            return set_mod[v] * len[v];
        }
        if (add_mod[v] != 0) {
            return add_mod[v] * len[v] + sum[v];
        }
        return sum[v];
    }

    private long getValue(int v) {
        if (set_mod[v] != DEFAULT) {
            return set_mod[v];
        }
        if (add_mod[v] != 0) {
            return add_mod[v] + t[v];
        }
        return t[v];
    }

    private void propagate(int v) {
        t[v] = Math.max(getValue(v * 2), getValue(v * 2 + 1));
        sum[v] = getSum(v * 2) + getSum(v * 2 + 1);
    }

    private void addOnTheRange(int l, int r, long val, int v, int tl, int tr) {
        if (l > r) {
            return;
        }
        if (l == tl && r == tr) {
            applyAddMod(v, val);
            return;
        }
        int tm = (tl + tr) >> 1;
        push(v);
        addOnTheRange(l, Math.min(r, tm), val, v * 2, tl, tm);
        addOnTheRange(Math.max(l, tm + 1), r, val, v * 2 + 1, tm + 1, tr);
        propagate(v);
    }

    private void setOnTheRange(int l, int r, long val, int v, int tl, int tr) {
        if (l > r) {
            return;
        }
        if (l == tl && r == tr) {
            applySetMod(v, val);
            return;
        }
        int tm = (tl + tr) >> 1;
        push(v);
        setOnTheRange(l, Math.min(r, tm), val, v * 2, tl, tm);
        setOnTheRange(Math.max(l, tm + 1), r, val, v * 2 + 1, tm + 1, tr);
        propagate(v);
    }

    private long getSum(int l, int r, int v, int tl, int tr) {
        if (l > r) {
            return 0;
        }
        if (l == tl && r == tr) {
            return getSum(v);
        }
        int tm = (tl + tr) >> 1;
        push(v);
        long res_l = getSum(l, Math.min(r, tm), v * 2, tl, tm);
        long res_r = getSum(Math.max(l, tm + 1), r, v * 2 + 1, tm + 1, tr);
        return res_l + res_r;
    }

    private int lowerBound(long val, int v, int tl, int tr) {
        if (tl == tr) {
            return tl;
        }
        push(v);
        int tm = (tl + tr) >> 1;
        if (getValue(v * 2) >= val) {
            return lowerBound(val, v * 2, tl, tm);
        } else {
            return lowerBound(val, v * 2 + 1, tm + 1, tr);
        }
    }

}