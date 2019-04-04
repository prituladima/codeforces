package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class BSbalansirovannayaKomanda {
    int t, n, m, k, ans;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        a = in.nextIntArray(n);
        GeekInteger.save_sort(a);

        if (n == 1) {
            out.printLine(1);
        } else {
            ans = Integer.MIN_VALUE;
            for (int i = 0, j = 0; j < n; j++) {
                while (a[j] - a[i] > 5) {
                    i++;
                }
                ans = Math.max(ans, j - i + 1);
            }
            out.printLine(ans);
        }


    }

}