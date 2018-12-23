package com.prituladima.codeforce.contests.contest1036;

import java.util.Scanner;
import java.io.PrintWriter;

public class ATheatreSquare {
    public void solve(int testNumber, Scanner in, PrintWriter out) {

        long n = in.nextLong(), m = in.nextLong(), a = in.nextLong();

        out.print(((n + a - 1) / a) * ((m + a - 1) / a));

    }
}
