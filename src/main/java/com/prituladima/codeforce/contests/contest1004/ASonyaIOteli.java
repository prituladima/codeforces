package com.prituladima.codeforce.contests.contest1004;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class ASonyaIOteli {
    int t, n, d, k, ans;
    int[] x, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        d = in.nextInt();
        x = in.nextIntArray(n);

        for (int i = 1; i < n; i++) {
            if(Math.abs(x[i - 1] - x[i]) == 2*d){
            ans ++;
            }
            if(Math.abs(x[i - 1] - x[i]) > 2*d){
                ans += 2;
            }
        }


        out.printLine(ans + 2);


    }

}