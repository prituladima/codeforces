package com.prituladima.codeforce.contests.contest1004;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;

public class DSonyaIMatrica {
    int t, n, m, k, ans;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    Map<Integer, Integer> ms;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        t = in.nextInt();
        a = in.nextIntArray(t);

        ms = GeekInteger.multiSet(a);
        if (ms.get(0) == null || ms.get(0) != 1) {
            out.printLine(-1);
            return;
        }
        for (int i = 1; i * i <= t; i++) {
            if (t % i == 0) {
                IntIntPair opt = option(i, t / i);
                if (opt != null) {
                    out.printFormat("%d %d\n%d %d", i, t / i, opt.first + 1, opt.second + 1);
                    return;
                }
            }
        }

        out.printLine(-1);
    }

    private IntIntPair option(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean allMatch = true;
                for (int dist = 1; dist < ms.keySet().size(); dist++) {
                    int mustBe = 0;
                    int x, y;
                    for (int k = 0; k < dist; k++) {
                        x = i - dist + k;
                        y = j + k;
                        if (x >= 0 && y < m) {
                            mustBe++;
                        }
                        x = i + k;
                        y = j + dist - k;
                        if (x < n && y < m) {
                            mustBe++;
                        }

                        x = i + dist - k;
                        y = j - k;
                        if (x < n && y >= 0) {
                            mustBe++;
                        }

                        x = i - k;
                        y = j - dist + k;
                        if (x >= 0 && y >= 0) {
                            mustBe++;
                        }

                    }
                    allMatch &= ms.get(dist) != null && mustBe == ms.get(dist);
                }
                if (allMatch) {
                    return new IntIntPair(i, j);
                }
            }
        }

        return null;
    }

}