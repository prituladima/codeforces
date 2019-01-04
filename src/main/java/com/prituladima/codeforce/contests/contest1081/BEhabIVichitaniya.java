package com.prituladima.codeforce.contests.contest1081;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class BEhabIVichitaniya {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.nextInt(), k = in.nextInt();
        long[] a = in.nextArrL(n);
        Arrays.sort(a);
        int st = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                st = i;
                break;
            }
        }

        a = Arrays.copyOfRange(a, st, n);
        Map<Long, Long> co = new HashMap<>();

        long sum = 0L;
        for (int i = 0; i < a.length && k > 0; i++) {
            a[i] -= sum;
            out.println(a[i]);
            sum += a[i];
            k--;
        }
        while (k-- > 0) {
            out.println(0);
        }

    }
}
