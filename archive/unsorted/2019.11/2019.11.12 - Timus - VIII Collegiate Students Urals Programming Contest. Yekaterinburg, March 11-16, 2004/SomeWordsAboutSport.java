package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class SomeWordsAboutSport {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int N = in.nextInt();
        int[][] M = in.nextIntMatrix(N, N);
        for (int i = 0; i < N; i++) {
            int curI = i;
            int curJ = 0;
            while (curI >= 0 && curJ < N)
                out.printf("%d ", M[curI--][curJ++]);
        }
        for (int j = 1; j < N; j++) {
            int curI = N - 1;
            int curJ = j;
            while (curI >= 0 && curJ < N)
                out.printf("%d ", M[curI--][curJ++]);
        }
    }
}
