package com.prituladima.codeforce.contests.contest1091;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.*;


public class CNoviiGodISfericheskayaPeredacha {
    public void solve(int testNumber, InputReader in, PrintWriter out) {


        long n = in.nextLong();

        Set<Long> ans = new HashSet<>();
//        ans.add(1L);
//        ans.add(n * (n + 1) / 2);

//        long up = (int) Math.sqrt(n) + 1;
//        up = n / 2;
        for (int K = 1; K * K <= n; K++) {
            if (n % K == 0) {
                long KD = n / K;
                solve(ans, K, KD);
                solve(ans, KD, K);
            }
        }
        List<Long> list = new ArrayList<>(ans);

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            out.print(list.get(i) + " ");
        }
    }

    private void solve(Set<Long> set, long a, long b) {
        long res = a* (b*(b-1))/2 + b;
        set.add(res);

    }
}
