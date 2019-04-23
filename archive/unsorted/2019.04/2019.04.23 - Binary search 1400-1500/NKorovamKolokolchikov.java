package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class NKorovamKolokolchikov {
    int INF = (int) 2e6;

    int n;
    int k;
    int[] s;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        s = in.nextIntArray(n);

        int ansS = INF;
        int L = 1;
        int R = INF;
        while (L <= R) {
            int M = (L + R) >>> 1;
            if (can4(M)) {
                ansS = M;
                R = M - 1;
            } else {
                L = M + 1;
            }
        }

        out.printLine(ansS);
    }


    private boolean can4(int localAns) {
        int y =  Math.min(n, 2 * k - n);
        for (int i = n - 1; i >= n - y; i--) {
            if (localAns < s[i]) return false;
        }

        int len = n - y;
        for (int i = 0; i < len; i++) {
            if (localAns < s[i] + s[len - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}