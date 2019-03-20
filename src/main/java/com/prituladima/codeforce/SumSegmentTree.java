package com.prituladima.codeforce;

import java.util.function.BiFunction;

public class SumSegmentTree implements SegmentTree<Integer> {

    private int n;
    int[] tree;

    public SumSegmentTree(int[] array) {
        this.n = array.length;
        build(array, 1, 0, n - 1);
    }

    @Override
    public void build(int array[], int v, int left, int right) {
        if (left == right)
            tree[v] = array[left];
        else {
            int tm = (left + right) / 2;
            build(array, v * 2, left, tm);
            build(array, v * 2 + 1, tm + 1, right);
            tree[v] = tree[v * 2] + tree[v * 2 + 1];
        }
    }


    @Override
    public void update(int cur, int from, int upTo, Integer newValue, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {
        if (from == upTo)
            tree[cur] = remappingFunction.apply(tree[cur], newValue);
        else {
//            int tm = (tl + tr) / 2;
//            if (pos <= tm)
//                update (v*2, tl, tm, pos, new_val);
//            else
//                update (v*2+1, tm+1, tr, pos, new_val);
//            tree[v] = t[v*2] + t[v*2+1];
        }
    }

    @Override
    public void update(int cur, int index, Integer value, BiFunction<? super Integer, ? super Integer, ? extends Integer> remappingFunction) {



    }
}
