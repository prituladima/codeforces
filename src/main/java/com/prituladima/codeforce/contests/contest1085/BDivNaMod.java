package com.prituladima.codeforce.contests.contest1085;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BDivNaMod {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        long n = in.nextLong(), k = in.nextLong();

        List<Long> ans = new ArrayList<>();
        //for (long i = 1; i <= 1000000L; i++) {
            for (long j = 1; j < k; j++) {
                if(n % j == 0)
                    ans.add( n / j * k + j);

                //                if (i * j == n) {
//                    ans.add(i * k + j);
//                }
            }
        //}
//
//        long asd = Integer.MAX_VALUE;
//        for (int i = 0; i < ans.size(); i++) {
//            asd =
//        }

        out.print(
                ans.stream().min(Comparator.naturalOrder()).get()
        );


    }
}
