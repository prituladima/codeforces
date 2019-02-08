package com.prituladima.codeforce.contests.contest1085;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class ATeatralnayaPloshad {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        long n = in.nextLong(), m = in.nextLong(), a = in.nextLong();
        out.println(GeekInteger.ceiling(n, a) * GeekInteger.ceiling(m, a));

    }
}
