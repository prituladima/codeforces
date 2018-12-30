package com.prituladima.codeforce.contests.contest1091;

import com.prituladima.codeforce.InputReader;
import com.prituladima.codeforce.util.delete.Pre;

import java.io.PrintWriter;
import java.util.*;

public class CNoviiGodISfericheskayaPeredacha {
    public void solve(int testNumber, InputReader in, PrintWriter out) {


        long n = in.nextLong();

        Set<Long> ans = new HashSet<>();
        ans.add(1L);
        ans.add(n * (n + 1) / 2);

        long up = (int) Math.sqrt(n) + 1;
        up = n / 2;
        for (int K = 2; K <= up; K++) {
            if (n % K == 0) {
                long res = 1L;
                long counter = 1L;
                long j = 1L;
                while (counter + K <= n) {
                    counter += K;
                    res += j * K + 1;
                    j++;
                }
                ans.add(res);
            }
        }
        List<Long> list = new ArrayList<>(ans);

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            out.print(list.get(i) + " ");
        }

    }
}
