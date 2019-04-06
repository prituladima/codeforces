package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class AIlyaIKrasochnayaProgulka {
    int INF = Integer.MAX_VALUE;
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
        ans = -INF;
//        for (int i = 0, j = 0; i < n; i++) {
//            if (j + 1 < n && array[i] != array[j + 1]) j++;
//            ans = Math.max(ans, Math.abs(i - j));
//        }
        for(int i = 1; i < n; i++){
            if(array[0] != array[i]){
                ans = Math.max(ans, i);
            }
        }
        for(int i = n-2; i >=0 ; i--){
            if(array[n-1] != array[i]){
                ans = Math.max(ans, n -1 - i);
            }
        }

        out.printLine(ans);

    }

}