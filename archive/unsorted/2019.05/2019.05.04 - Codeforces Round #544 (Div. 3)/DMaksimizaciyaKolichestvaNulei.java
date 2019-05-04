package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.numbers.Rational;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class DMaksimizaciyaKolichestvaNulei {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        final int n = in.nextInt();
        final int[] a = in.nextIntArray(n);
        final int[] b = in.nextIntArray(n);
        Map<Rational, Integer> ans = new HashMap<>();

        int any = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == 0 && b[i] == 0) any++;
            else if (a[i] != 0) {
                ans.merge(new Rational(-b[i], a[i]), 1, Integer::sum);
            }
        }

        int max = 0;
        for (Rational key : ans.keySet()) {
            max = max(max, ans.get(key));
        }
        out.printLine(max + any);
    }

}