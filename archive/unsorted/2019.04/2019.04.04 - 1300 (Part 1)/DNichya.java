package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class DNichya {
    int t, n, m, k, ans;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns, p, buf;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        pairs = in.nextIntPairArray(n);
        pairsAns = new IntIntPair[n + 1];
        pairsAns[0] = new IntIntPair(0, 0);
        for (int i = 1; i < pairsAns.length; i++) {
            pairsAns[i] = pairs[i - 1];
        }
        pairs = pairsAns;
        for (int i = 0; i < pairs.length - 1; i++) {
            int min = Math.min(pairs[i + 1].first, pairs[i + 1].second);
            int max = Math.max(pairs[i].first, pairs[i].second);
            ans += Math.max(0, min - max + ((pairs[i].first == pairs[i].second) ? 0 : 1));
        }
        out.printLine(ans + 1);

    }

}