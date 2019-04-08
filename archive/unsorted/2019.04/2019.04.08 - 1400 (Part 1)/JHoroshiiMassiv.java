package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JHoroshiiMassiv {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    long[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        a = in.nextLongArray(n);

        Map<Long, Integer> ms = GeekInteger.multiSet(a);
        long[] pref = new long[n];
        long[] suff = new long[n];

        pref[0] = a[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + a[i];
        }

        suff[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] + a[i];
        }

        List<Integer> res = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            long sum = 0;
            if (i > 0) {
                sum += pref[i - 1];
            }
            if (i < n - 1) {
                sum += suff[i + 1];
            }
            if (sum % 2 == 1) continue;
            long potValueToCheckINMS = sum / 2;
            if (a[i] == potValueToCheckINMS) {
                if (ms.getOrDefault(potValueToCheckINMS, 0) >= 2) {
                    res.add(i + 1);
                }
            } else {
                if (ms.getOrDefault(potValueToCheckINMS, 0) >= 1) {
                    res.add(i + 1);
                }
            }
        }

        out.printLine(res.size());
//        out.printList(res);
        for (Integer re : res) {
            out.print(re).printSpace();
        }
        out.printLine();

    }

}