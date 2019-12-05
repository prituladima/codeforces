package com.prituladima.yaal.ds;

public class GCDIterativeSegmentTree {
    //    int N = (int) 1e5 + 10;  // limit for array size
    int n;  // array size
    int[] t;

    public GCDIterativeSegmentTree(int n) {
        this.n = n;
        this.t = new int[2 * n];
    }

    public void build() {  // build the tree
        for (int i = n - 1; i > 0; --i) t[i] = gcd(t[i << 1], t[i << 1 | 1]);
    }

    public void modify(int p, int value) {  // set value at position p
        for (t[p += n] = value; p > 1; p >>= 1) t[p >> 1] = gcd(t[p], t[p ^ 1]);
    }

    public int query(int l, int r) {  // sum on interval [l, r)
        int res = 0;
        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l & 1) == 1) res = gcd(res, t[l++]);
            if ((r & 1) == 1) res = gcd(res, t[--r]);
        }
        return res;
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
