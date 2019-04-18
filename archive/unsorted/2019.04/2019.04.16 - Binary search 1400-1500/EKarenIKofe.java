package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class EKarenIKofe {
    int MAXN = (int) 2e6 + 3;
    int q, n, k;
    int[] pointsOK = new int[MAXN], countLessOrEq = new int[MAXN];
    boolean[] enough = new boolean[MAXN];

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        k = in.nextInt();
        q = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            pointsOK[l]++;
            pointsOK[r + 1]--;
        }
        int current = 0;
        for (int i = 0; i < MAXN; i++) {
            current += pointsOK[i];
            if (current >= k) enough[i] = true;
        }
        int count = 0;
        for (int i = 0; i < MAXN; i++) {
            if (enough[i]) count++;
            countLessOrEq[i] = count;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            stringBuilder.append(countLessOrEq[b] - countLessOrEq[a - 1]).append('\n');
        }
        out.print(stringBuilder.toString());
    }
}