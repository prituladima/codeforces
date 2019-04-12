package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class ETriGirlyandi {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes".toUpperCase(), NO = "No".toUpperCase();
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int k1 = in.nextInt();
        int k2 = in.nextInt();
        int k3 = in.nextInt();

        if (Math.min(k1, Math.min(k2, k3)) == 1) {
            out.printLine(YES);
        } else {
            int[] a = new int[]{k1, k2, k3};
            Arrays.sort(a);
            if (a[0] == 2 && a[1] == 2)
                out.printLine(YES);
            else if(a[0] == 3 && a[1] == 3 && a[2]==3)
                out.printLine(YES);
            else if(a[0] == 2 && a[1] == 4 && a[2]==4)
                out.printLine(YES);
            else
                out.printLine(NO);
        }


    }

}