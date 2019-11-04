package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class StonePile {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();

        int[] a = in.nextIntArray(n);
        if (n == 1) {
            out.println(a[0]);
            return;
        }

        int sum = stream(a).sum();
        int ans = sum;
        for (int mask = 0; mask < (1 << n); mask++) {
            int localSubSetSum = 0;
            for (int shift = 1; shift <= n; shift++) {
                if (((mask >> shift) & 1) == 1) {
                    localSubSetSum += a[shift - 1];
                }
            }

            ans = Math.min(ans, Math.abs(Math.abs(sum - localSubSetSum) - localSubSetSum));
        }

        out.println(ans);

    }
}