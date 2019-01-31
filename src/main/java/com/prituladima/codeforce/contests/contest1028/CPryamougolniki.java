package com.prituladima.codeforce.contests.contest1028;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.max;
import static java.lang.Math.min;

public class CPryamougolniki {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;


    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        if (n == 2) {
            out.printLine(in.nextInt() + " " + in.nextInt());
            return;
        }

        List<RectS> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new RectS(in.nextInt(), in.nextInt(), in.nextInt(), in.nextInt()));
        }

        List<RectS> pref = new ArrayList<>(list);
        List<RectS> suff = new ArrayList<>(list);

        for (int i = 1; i < n; i++) {
            pref.set(i, common(pref.get(i - 1), pref.get(i)));
        }
        for (int i = n - 2; i >= 0; i--) {
            suff.set(i, common(suff.get(i + 1), suff.get(i)));
        }


        if (pref.get(n - 1) == null && pref.get(n - 2) != null) {
            out.printLine(pref.get(n - 2).x1 + " " + pref.get(n - 2).y1);
            return;
        }

        if (suff.get(0) == null && suff.get(1) != null) {
            out.printLine(suff.get(1).x1 + " " + suff.get(1).y1);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            RectS res = common(pref.get(i - 1), suff.get(i + 1));
            if (res != null) {
                out.printLine(res.x1 + " " + res.y1);
                return;
            }
        }


        if (pref.get(n - 1) != null) {
            out.printLine(pref.get(n - 1).x1 + " " + pref.get(n - 1).y1);
//            return;
        }


    }

    private static RectS common(RectS a, RectS b) {
        if (a == null || b == null) {
            return null;
        }

        int x5 = max(a.x1, b.x1);
        int y5 = max(a.y1, b.y1);

        int x6 = min(a.x2, b.x2);
        int y6 = min(a.y2, b.y2);

        if (x5 > x6 || y5 > y6) {
            return null;
        }

        return new RectS(x5, y5, x6, y6);
    }


    private static class RectS {
        int x1;
        int y1;
        int x2;
        int y2;

        public RectS(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }


    }
}