package com.prituladima.codeforce.contests.contest1013;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;

public class TaskC {
    int t, n, m, k, ans;
    int[] array, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        array = in.nextIntArray(2 * n);


        GeekInteger.save_sort(array);
//        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> ms = GeekInteger.multiSet(array);
        if (ms.containsValue(n)) {
            out.print(0);
            return;
        }

        int minInd = 0;
        long min = (array[n - 1] - array[0]) * 1L * (array[2 * n - 1] - array[n]);
        for (int i = n; i <= 2 * n; i++) {
            if (min > (array[i - 1] - array[i - n]) * 1L * (array[2 * n - 1] - array[0])) {
                min = (array[i - 1] - array[i - n]) * 1L * (array[2 * n - 1] - array[0]);
//                minInd = i - 1;
            }
        }


//        if (minInd == 2 * n - 1 || minInd == n - 1) {
//            out.printLine((array[n - 1] - array[0]) * 1L * (array[2 * n - 1] - array[n]));
//            return;
//        }

        out.print(min );


    }

}