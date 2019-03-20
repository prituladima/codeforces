package com.prituladima.codeforce;

import java.util.function.BiFunction;
import java.util.stream.IntStream;

// TODO: 3/20/2019
//MAKE GENERAL CASE
//Associative operation
//IDEMPOTENT ELEMENT
public class STree {

    BiFunction<Integer, Integer, Integer> SUM = Integer::sum;
    BiFunction<Integer, Integer, Integer> MIN = Integer::min;
    BiFunction<Integer, Integer, Integer> GCD = STree::gcd;

    int neitralElement = 0;

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd( b, a % b);
    }

    int n;
    int[] t;

    public STree(int[] a) {
        this.n = a.length;
        t = new int[4 * n];
        build(a, 1, 0, a.length - 1);
    }

    void build(int a[], int v, int tl, int tr) {
        if (tl == tr)
            t[v] = a[tl];
        else {
            int tm = (tl + tr) / 2;
            build(a, v * 2, tl, tm);
            build(a, v * 2 + 1, tm + 1, tr);
            t[v] = t[v * 2] + t[v * 2 + 1];
        }
    }

    int sum(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return sum(v * 2, tl, tm, l, Math.min(r, tm)) + sum(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }

    void update(int v, int tl, int tr, int pos, int new_val) {
        if (tl == tr)
            t[v] = new_val;
        else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update(v * 2, tl, tm, pos, new_val);
            else
                update(v * 2 + 1, tm + 1, tr, pos, new_val);
            t[v] = t[v * 2] + t[v * 2 + 1];
        }
    }

    public static void main(String[] args) {

        int[] array = IntStream.rangeClosed(1, 32).toArray();

        STree tree = new STree(array);
        System.out.println(tree.sum(1, 0, array.length - 1, 0, 9));
        tree.update(1, 0, array.length - 1, 10, 70);
        System.out.println(tree.sum(1, 0, array.length - 1, 8, 11));


    }

}
