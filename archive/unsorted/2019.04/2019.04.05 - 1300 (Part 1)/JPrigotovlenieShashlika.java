package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class JPrigotovlenieShashlika {
    int INF = Integer.MAX_VALUE;
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        if (k == 0) {
            out.printLine(n);
            for (int i = 0; i < n; i++) {
                out.print(i + 1).print(" ");
            }
            out.printLine();
        } else if (n <= k + 1) {
            out.printLine(1);
            out.printLine(1);
        } else {
            ans = GeekInteger.ceiling(n, 2 * k + 1);
            List<Integer> list = new ArrayList<>();
            int last = k + 1;
            list.add(last);
            for (int i = 2; i <= ans; i++) {
                last += 2 * k + 1;
                list.add(last);
            }
            int diff = 0;
            int mod = n % (2 * k + 1);
            if (mod <= k && mod != 0) {
                diff = k + 1 - mod;
            }

            out.printLine(ans);

            for (int value : list) {
                out.print(value - diff).print(" ");
            }
            out.printLine();
        }
    }

}