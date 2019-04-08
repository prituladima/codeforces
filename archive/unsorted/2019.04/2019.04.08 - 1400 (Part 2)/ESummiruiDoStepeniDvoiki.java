package com.prituladima.codeforce;

import com.prituladima.yaal.bit.BitUtil;
import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Map;
import java.util.Set;

public class ESummiruiDoStepeniDvoiki {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    long[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        n = in.nextInt();
        a = in.nextLongArray(n);

        Map<Long, Integer> ms = GeekInteger.multiSet(a);

        for (long key : ms.keySet()) {
            if (key >= 2 && BitUtil.isPowerOfTwo(key)) {
                if (ms.get(key) < 2) ans++;
            } else {
                boolean ok = true;
                for (long p = BitUtil.nextPowerOf2(key); p < 1L << 32; p <<= 1) {
                    ok &= !ms.containsKey(p - key);
                }
                if (ok)
                    ans += ms.get(key);
            }
        }

        if (n - ans == 1) out.printLine(n);
        else
            out.printLine(ans);


    }

}