package com.prituladima.timus;

import com.prituladima.yaal.ds.GCDIterativeSegmentTree;
import com.prituladima.yaal.ds.GCDSegmentTree;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class Task1846 {
    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final String yes = "YES", no = "NO";
    private static final boolean MULTI_TEST = false;

    private void solve(InputReader in, OutputWriter out) {
        final int n = in.nextInt();
//        int[] a = new int[n];
        GCDIterativeSegmentTree segmentTree = new GCDIterativeSegmentTree(n);
        int pointer = 0;

        int counter = 0;
        Map<Integer, Set<Integer>> valToIndexes = new HashMap<>();
        for(int i = 0 ; i < n ; i++){
            String command = in.nextToken();
            int val = in.nextInt();
            if ("+".equals(command)) {
                counter++;
                int newIndex = pointer++;

                segmentTree.modify(newIndex, val);
                valToIndexes.computeIfAbsent(val, key -> new LinkedHashSet<>());

                valToIndexes.get(val).add(newIndex);

            } else if ("-".equals(command)) {
                counter--;
                int firstInd = valToIndexes.get(val).iterator().next();

                valToIndexes.get(val).remove(firstInd);

                segmentTree.modify(firstInd, 0);
            } else {
                throw new IllegalStateException();
            }

            final int ans = segmentTree.query(0, n);
            out.println(counter != 0 ? ans : 1);
        }


    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = MULTI_TEST ? in.nextInt() : 1;
        while (t-- > 0) {
            solve(in, out);
        }
    }
}