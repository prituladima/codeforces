package com.prituladima.codeforce.contests.contest1028;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.geometry.RectangleUtil;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

import static com.prituladima.yaal.geometry.RectangleUtil.*;
import static com.prituladima.yaal.greedy.GreedyUtil.calculatePrefix;
import static com.prituladima.yaal.greedy.GreedyUtil.calculateSuffix;
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

        List<Rect> list = in.nextRectangleArray(n);

        List<Rect> pref = calculatePrefix(list, RectangleUtil::intersection);
        List<Rect> suff = calculateSuffix(list, RectangleUtil::intersection);

        if (pref.get(n - 1) == null && pref.get(n - 2) != null) {
            out.printLine(pref.get(n - 2).x1 + " " + pref.get(n - 2).y1);
            return;
        }

        if (suff.get(0) == null && suff.get(1) != null) {
            out.printLine(suff.get(1).x1 + " " + suff.get(1).y1);
            return;
        }

        for (int i = 1; i < n - 1; i++) {
            Rect res = RectangleUtil.intersection(pref.get(i - 1), suff.get(i + 1));
            if (res != null) {
                out.printLine(res.x1 + " " + res.y1);
                return;
            }
        }


        if (pref.get(n - 1) != null) {
            out.printLine(pref.get(n - 1).x1 + " " + pref.get(n - 1).y1);
        }


    }


}