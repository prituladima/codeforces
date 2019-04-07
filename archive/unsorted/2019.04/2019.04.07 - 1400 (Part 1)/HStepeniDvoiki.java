package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.numbers.IntegerUtils;

import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class HStepeniDvoiki {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes".toUpperCase(), NO = "No".toUpperCase();
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        k = in.nextInt();

        if (k > n) {
            out.printLine(NO);
            return;
        }

        String s = Integer.toBinaryString(n);
        chars = s.toCharArray();
        int len = chars.length;
        PriorityQueue<Long> integers = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < len; i++) {
            if (chars[i] == '1') {
                long power = IntegerUtils.power(2, len - i -1);
                integers.add(power);
            }
        }

        if(k < integers.size()) {
            out.printLine(NO);
            return;
        }
        while (integers.size() < k) {
            Long power2 = integers.remove();
            integers.add(power2 / 2);
            integers.add(power2 / 2);
        }

        out.printLine(YES);
        for (Long val : integers) {
            out.print(val).printSpace();
        }
        out.printLine();

    }

}