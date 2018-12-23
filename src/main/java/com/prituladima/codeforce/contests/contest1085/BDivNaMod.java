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
        for (long j = 1; j < k; j++)
            if (n % j == 0)
                ans.add(n / j * k + j);


        out.print(
                ans.stream().min(Comparator.naturalOrder()).get()
        );

    }
}
