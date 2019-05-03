package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class FSortingTheCoins {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int[] p = in.nextIntArray(n);
        int[] r = GeekInteger.reverse(p);
        List<Integer> list = new ArrayList<>();
        int stable = n;
        int removed = 0;
        list.add(1);
        for (int i = 0; i < r.length; i++) {
            removed++;
            stable = min(stable, n - r[i]);
            int local = n - stable - removed + 1;
            list.add(local);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            out.print(list.get(i)).space();
        }



    }
}