package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Elections {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt(), m = in.nextInt();
        int[] a = in.nextIntArray(m);

        Map<Integer, Integer> canToVotes = new HashMap<>();

        for (int i = 0; i < m; i++) {
            canToVotes.merge(a[i], 1, Integer::sum);
        }

        for (int i = 1; i <= n; i++) {

            out.printf("%.2f", 100.0 * canToVotes.getOrDefault(i, 0) / m).println("%");
        }

    }
}