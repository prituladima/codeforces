package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;

public class ASushiDlyaDvoih {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        array = in.nextIntArray(n);

        List<Integer> AL = new ArrayList<>();

        boolean lastWasOne = false;

        for (int i = 0; i < n; ) {
            int k = 0;
            while (i < n && array[i] == 1 ) {
                k++;
                i++;
            }
            if (k > 0) AL.add(k);
            k = 0;
            while (i < n && array[i] == 2) {
                k++;
                i++;
            }
            if (k > 0) AL.add(k);
        }

        ans = Integer.MIN_VALUE;
        for (int i = 0; i < AL.size() - 1; i++) {
            ans = Math.max(ans, 2 * Math.min(AL.get(i), AL.get(i + 1)));
        }


        out.printLine(ans);

    }

}