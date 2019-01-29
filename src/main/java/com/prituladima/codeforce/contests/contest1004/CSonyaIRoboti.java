package com.prituladima.codeforce.contests.contest1004;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class CSonyaIRoboti {
    int t, n, m, k;
    long ans;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        a = in.nextIntArray(n);

        if (n == 1) {
            out.printLine(0);
            return;
        }

        int[] suffix = new int[n];
        Set<Integer> set = new HashSet<>();
        suffix[n - 1] = 1;
        set.add(a[n - 1]);
        for (int i = n - 2; i > 0; i--) {
            suffix[i] = suffix[i + 1];
            if (!set.contains(a[i]))
                suffix[i]++;
            set.add(a[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        set2.add(a[0]);
        ans += suffix[1];
        for (int i = 1; i < n - 1; i++) {
            if (!set2.contains(a[i])) {
                ans += suffix[i + 1];
                set2.add(a[i]);
            }
        }

        out.printLine(ans);

    }

}