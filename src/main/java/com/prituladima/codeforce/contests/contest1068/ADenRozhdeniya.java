package com.prituladima.codeforce.contests.contest1068;

import com.prituladima.codeforce.GeekLong;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.prituladima.codeforce.GeekDP.Pair;


public class ADenRozhdeniya {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    long N, M;
    int[] a;
    long L, K;
    int ans;
    int min = INF, max = -INF;
    String s;
    private List<Pair> pairs = new ArrayList<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        N = in.nextLong();
        M
                = in.nextLong();
        K = in.nextLong();
        L = in.nextLong();

        if (M > N) {
            out.print(-1);
            return;
        }

        if (K + L > N) {
            out.print(-1);
            return;
        }

        if(N - N% M  < K +L){
            out.print(-1);
            return;
        }

        
        out.println(GeekLong.ceiling(K+L, M));

    }

}