package com.prituladima.codeforce.contests.contest1065;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class DTriFiguri {


    //    int lastUsed =

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int N = in.nextInt();
        int[] is = new int[N*N + 1];
        int[] js = new int[N*N + 1];
        int[][] A = new int[N][N];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = in.nextInt();
                is[A[i][j]] = i;
                js[A[i][j]] = j;
            }
        }

        int ans = 0;
        for (int i = 0; i < is.length - 1; i++) {
            ans += pass(is[i], js[i], is[i + 1], js[i + 1]);
        }
        out.print(ans);
    }

    private int pass(int ix, int iy, int jx, int jy) {
        int ans = 2;
        if (ix == jx) return 1;
        if (jy == iy) return 1;
        if (Math.abs(ix - jx) == Math.abs(iy - jy)) return 1;
        if (Math.abs(ix - jx) == 2 && Math.abs(iy - jy) == 1) return 1;
        if (Math.abs(ix - jx) == 1 && Math.abs(iy - jy) == 2) return 1;
        return ans;
    }

}
