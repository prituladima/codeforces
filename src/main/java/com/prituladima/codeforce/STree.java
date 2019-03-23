package com.prituladima.codeforce;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
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

    /**
     * build segment tree
     * @param a a with n length
     * @param v temp index (by default is 1)
     * @param tl temp left index of current node inclusive (by default is 0)
     * @param tr temp right index of current node inclusive (by default is n - 1)
     */
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

    /**
     *  Not Java style, but works very good.
     * todo Make not recursive optimization
     * todo Make general solution to be able using BinaryOperator
     * @param v temp index (by default is 1)
     * @param tl temp left index of current node inclusive (by default is 0)
     * @param tr temp right index of current node inclusive (by default is n - 1)
     * @param l range query inclusive (0 based)
     * @param r range query inclusive (0 based)
     * @return result on the range inclusive
     */
    int sum(int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return sum(v * 2, tl, tm, l, Math.min(r, tm)) + sum(v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r);
    }

    /**
     * update
     * @param v temp index (by default is 1)
     * @param tl temp left index of current node inclusive (by default is 0)
     * @param tr temp right index of current node inclusive (by default is n - 1)
     * @param pos index to update
     * @param new_val value to put
     */
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

        int[] array = IntStream.rangeClosed(0, 10).toArray();
//        https://codeforces.com/contest/1136/submission/51197694
        System.out.println(Arrays.toString(array));
        STree tree = new STree(array);
        System.out.println(tree.sum(1, 0, array.length - 1, 0, 10));
        tree.update(1, 0, array.length - 1, 9, 70);
        System.out.println(tree.sum(1, 0, array.length - 1, 8, 8));


    }

}
