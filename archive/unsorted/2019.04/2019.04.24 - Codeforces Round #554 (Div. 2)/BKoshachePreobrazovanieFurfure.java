package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class BKoshachePreobrazovanieFurfure {
    int t, n, m, k, x, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        x = in.nextInt();
        List<Integer> res = new ArrayList<>();
        int counter = 0;
        while (!ok(x)) {
            String s = Integer.toBinaryString(x);
            int len = s.length();
            int i = s.indexOf('0');
            char[] m = new char[len - i];
            Arrays.fill(m, '1');
            int step = Integer.parseInt(String.valueOf(m), 2);
            x ^= step;
            res.add(String.valueOf(m).length());
            counter++;
            if (ok(x)) break;
            x += 1;
            counter++;
        }

//        out.printLine(res.size()res.size());
        out.printLine(counter);
        for (Integer re : res) {
            out.print(re).space();
        }
        out.printLine();

    }

    private boolean ok(int x) {
        char[] s = Integer.toBinaryString(x).toCharArray();
        boolean ok = true;
        for (int i = 0; i < s.length; i++) {
            ok &= s[i] == '1';
        }
        return ok;
    }

}