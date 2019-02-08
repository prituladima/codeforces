package com.prituladima.codeforce.contests.contest1047;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class ALittleCLyubit3I {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        if (n % 2 != 0) {
            int a = 1;
            int b = 1;
            int c = n - 2;
            if (c % 3 == 0) {
                c--;
                b++;
            }
            out.printLine(String.format("%d %d %d", a, b, c));
        } else {
            int a = 1;
            int b = 2;
            int c = n - 3;
            if (c % 3 == 0) {
                c--;
                a++;
            }
            out.printLine(String.format("%d %d %d", a, b, c));
        }


    }

}