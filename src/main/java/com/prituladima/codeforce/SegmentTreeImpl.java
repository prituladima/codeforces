package com.prituladima.codeforce;

import java.util.Arrays;

public class SegmentTreeImpl {
    long DEFAULT = (long)-1e18;
    long[] t, len, sum, add_mod, set_mod;
    int n;

    void build(long[] a, int v, int tl, int tr) {
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

    SegmentTreeImpl(long[] a) {
        n = a.length;
        t = new long[4 * n];
        sum = new long[4 * n];
        add_mod = new long[4 * n];
        set_mod = new long[4 * n];
        Arrays.fill(set_mod, DEFAULT);
        len = new long[4 * n];
        build(a, 1, 0, n - 1);
    }

    void apply_add_mod(int v, long val) {
        if (set_mod[v] != DEFAULT) {
            set_mod[v] += val;
        } else {
            add_mod[v] += val;
        }
    }

    void apply_set_mod(int v, long val) {
        add_mod[v] = 0;
        set_mod[v] = val;
    }

    void push(int v) {
        assert (add_mod[v] == 0 || set_mod[v] == DEFAULT);
        if (add_mod[v] != 0) {
            t[v] += add_mod[v];
            sum[v] += add_mod[v] * len[v];
            apply_add_mod(v * 2, add_mod[v]);
            apply_add_mod(v * 2 + 1, add_mod[v]);
            add_mod[v] = 0;
        }
        if (set_mod[v] != DEFAULT) {
            t[v] = set_mod[v];
            sum[v] = set_mod[v] * len[v];
            apply_set_mod(v * 2, set_mod[v]);
            apply_set_mod(v * 2 + 1, set_mod[v]);
            set_mod[v] = DEFAULT;
        }
    }

    long get_sum(int v) {
        if (set_mod[v] != DEFAULT) {
            return set_mod[v] * len[v];
        }
        if (add_mod[v] != 0) {
            return add_mod[v] * len[v] + sum[v];
        }
        return sum[v];
    }

    long get_t(int v) {
        if (set_mod[v] != DEFAULT) {
            return set_mod[v];
        }
        if (add_mod[v] != 0) {
            return add_mod[v] + t[v];
        }
        return t[v];
    }

    void recalc(int v) {
        t[v] = Math.max(get_t(v * 2), get_t(v * 2 + 1));
        sum[v] = get_sum(v * 2) + get_sum(v * 2 + 1);
    }

    void add_update(int l, int r, long val, int v, int tl, int tr) {
        if (l > r) {
            return;
        }
        if (l == tl && r == tr) {
            apply_add_mod(v, val);
            return;
        }
        int tm = (tl + tr) >> 1;
        push(v);
        add_update(l, Math.min(r, tm), val, v * 2, tl, tm);
        add_update(Math.max(l, tm + 1), r, val, v * 2 + 1, tm + 1, tr);
        recalc(v);
    }

    void set_update(int l, int r, long val, int v, int tl, int tr) {
        if (l > r) {
            return;
        }
        if (l == tl && r == tr) {
            apply_set_mod(v, val);
            return;
        }
        int tm = (tl + tr) >> 1;
        push(v);
        set_update(l, Math.min(r, tm), val, v * 2, tl, tm);
        set_update(Math.max(l, tm + 1), r, val, v * 2 + 1, tm + 1, tr);
        recalc(v);
    }

    long get_sum(int l, int r, int v, int tl, int tr) {
        if (l > r) {
            return 0;
        }
        if (l == tl && r == tr) {
            return get_sum(v);
        }
        int tm = (tl + tr) >> 1;
        push(v);
        long res_l = get_sum(l, Math.min(r, tm), v * 2, tl, tm);
        long res_r = get_sum(Math.max(l, tm + 1), r, v * 2 + 1, tm + 1, tr);
        return res_l + res_r;
    }

    int lower_bound(long val, int v, int tl, int tr) {
        if (tl == tr) {
            return tl;
        }
        push(v);
        int tm = (tl + tr) >> 1;
        if (get_t(v * 2) >= val) {
            return lower_bound(val, v * 2, tl, tm);
        } else {
            return lower_bound(val, v * 2 + 1, tm + 1, tr);
        }
    }

    //interface

    void add_update(int l, int r, long val) {
        add_update(l, r, val, 1, 0, n - 1);
    }

    void set_update(int l, int r, long val) {
        set_update(l, r, val, 1, 0, n - 1);
    }

    long get_sum(int l, int r) {
        long res = get_sum(l, r, 1, 0, n - 1);
        return res;
    }


    int lower_bound(long val) {
        if (get_t(1) < val) {
            return n;
        } else {
            return lower_bound(val, 1, 0, n - 1);
        }
    }
};
