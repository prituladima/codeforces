package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

import static java.util.Arrays.setAll;
import static java.util.Arrays.sort;

public class EKarenIKofe {
    int q, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairsA, pairsB, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    int MAXN = (int) 2e6;
    int[] t_left = new int[4 * MAXN];
    int[] t_right = new int[4 * MAXN];

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        q = in.nextInt();

        pairsA = in.nextIntPairArray(n);
        pairsB = in.nextIntPairArray(q);

        sort(pairsA);
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = pairsA[i].first;
            right[i] = pairsA[i].second;
        }
        build_max(t_left, left, 1, 0, n - 1);
        build_min(t_right, right, 1, 0, n - 1);

//        List<IntIntPair> list = new ArrayList<>();
        int lastRigth = 1;
        Set<Integer> matchPoints = new HashSet<>();
        for (int i = 0; i + k - 1 < n; i++) {
            int l = i;
            int r = i + k - 1;
            int posLeft = max(t_left, 1, 0, n-1, l, r);
            int posRight = min(t_right, 1, 0, n-1, l, r);
            posLeft = Math.max(lastRigth, posLeft);
            if(posLeft <= posRight){
                for (int j = posLeft; j <= posRight; j++) {
                    matchPoints.add(j);
                }
//                list.add(IntIntPair.makePair(posLeft, posRight));
                lastRigth = posRight;
            }
        }





    }

    void build_min(int[] t, int a[], int v, int tl, int tr) {
        if (tl == tr)
            t[v] = a[tl];
        else {
            int tm = (tl + tr) / 2;
            build_min(t, a, v * 2, tl, tm);
            build_min(t, a, v * 2 + 1, tm + 1, tr);
            t[v] = Math.min(t[v * 2], t[v * 2 + 1]);
        }
    }

    int min(int[] t, int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return Math.min(min(t, v * 2, tl, tm, l, Math.min(r, tm)), min(t, v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
    }

    void build_max(int[] t, int a[], int v, int tl, int tr) {
        if (tl == tr)
            t[v] = a[tl];
        else {
            int tm = (tl + tr) / 2;
            build_max(t, a, v * 2, tl, tm);
            build_max(t, a, v * 2 + 1, tm + 1, tr);
            t[v] = Math.max(t[v * 2], t[v * 2 + 1]);
        }
    }

    int max(int[] t, int v, int tl, int tr, int l, int r) {
        if (l > r)
            return 0;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return Math.max(min(t, v * 2, tl, tm, l, Math.min(r, tm)), min(t, v * 2 + 1, tm + 1, tr, Math.max(l, tm + 1), r));
    }
}