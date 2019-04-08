package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class DRazdachaKonfet {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, l, r, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes".toUpperCase(), NO = "No".toUpperCase();
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        l = in.nextIntArray(n);
        r = in.nextIntArray(n);
        a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = n - l[i] - r[i];
        }

        for(int i = 0; i< n; i++){
            for(int j = i + 1; j < n; j++ ){
                r[i] -= a[j] > a[i] ? 1 : 0;
            }
            for(int j = 0; j < i; j++){
                l[i] -= a[j] > a[i] ? 1 : 0;
            }
        }
        boolean ok = true;
        for(int i = 0; i < n; i++) ok &= l[i] == 0 && r[i] == 0;

        if(ok) {
            out.printLine(YES);
            out.print(a);
        }else {
            out.printLine(NO);
        }



    }

}