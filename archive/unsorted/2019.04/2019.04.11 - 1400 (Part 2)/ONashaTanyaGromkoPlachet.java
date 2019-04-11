package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class ONashaTanyaGromkoPlachet {
    long t, n, m, k, INF = Integer.MAX_VALUE, A, B;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextLong();
        k = in.nextLong();
        A = in.nextLong();
        B = in.nextLong();

        if(k == 1){
            out.printLine(A*(n-1));
        }else {

            long ans = 0;
            while (n != 1) {
                if (n % k == 0) {
                    ans += Math.min(B, (n - n / k) * A);
                    n /= k;
                } else {
                    if (n / k == 0) {
                        ans += (n % k - 1) * A;
                        n = 1;
                    } else {
                        ans += (n % k) * A;
                        n -= n % k;
                    }
                }
            }

            out.printLine(ans);
        }
    }

}