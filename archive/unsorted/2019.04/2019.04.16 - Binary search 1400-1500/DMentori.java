package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.numbers.IntegerUtils;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DMentori {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();

        a = in.nextIntArray(n);
        final Map<Integer, Set<Integer>> integerSetMap = IntegerUtils.valueToIndexSet(a);
        b = a.clone();
        GeekInteger.save_sort(a);
        pairs = in.nextIntPairArray(m);
        int[] res = new int[n];
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int ind = theMostRightLess(a, i - 1, a[i]);
            int localAns = ind + 1;
            if (!used.contains(a[i])) {
                final Set<Integer> indexes = integerSetMap.get(a[i]);
                for (int index : indexes) {
                    res[index] = localAns;
                }
                used.add(a[i]);
            }
        }

        for (IntIntPair pair : pairs) {
            final int x = pair.first;
            final int y = pair.second;
            if (b[x - 1] > b[y - 1]) {
                res[x - 1]--;
            } else if (b[x - 1] < b[y - 1]) {
                res[y - 1]--;
            }
        }

        out.printLine(res);

    }

    private int theMostRightLess(int[] a, int last, int value) {
        int start = 0;
        int finish = last;
        int res = -1;
        while (start <= finish) {
            int middle = (start + finish) >> 1;
            if (a[middle] < value) {
                res = middle;
                start = middle + 1;
            } else {
                finish = middle - 1;
            }
        }
        return res;
    }

}