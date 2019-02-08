package com.prituladima.codeforce.contests.contest1080;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BMargaritaILuchshiiPodarok {

    List<Long> list = new ArrayList<>();

    private void precalc() {

    }


    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int q = in.nextInt();

        while (q-- > 0) {
            long L = in.nextLong(), R = in.nextLong();
            out.println(getSumAns(L, R));
        }

    }

    private long getSumAns(long L, long R) {
        if (L == 1) return sum(R);

        return sum(R) - sum(L - 1);
    }

    private long sum(long R) {

        boolean even = R % 2 == 0;


        R = (R + 1) / 2;
        if (even) {
            return (R);
        } else {
            return -R;
        }

    }
}
