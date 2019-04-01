package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class ADetektiv {
    int t, n, m, k, ans = 0;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        array = in.nextIntArray(n);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
//            while (!set.isEmpty()) {
            set.remove(i + 1);
//                i++;
//            }
            if (set.isEmpty())
                ans++;
        }

        out.printLine(ans);


    }

}