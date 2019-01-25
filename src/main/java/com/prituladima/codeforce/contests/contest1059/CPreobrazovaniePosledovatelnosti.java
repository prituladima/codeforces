package com.prituladima.codeforce.contests.contest1059;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.prituladima.codeforce.GeekDP.Pair;


public class CPreobrazovaniePosledovatelnosti {
    int n;

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        solve(out, n, 1);
    }

    private void solve(PrintWriter out, int n, int mut) {
        if (n == 1){ out.print(mut + " ");return;}
        if (n == 2){ out.print(mut + " " + mut * 2 + " ");return;}
        if (n == 3){ out.print(mut + " " + mut + " " + mut * 3 + " ");return;}
        for (int i = 0; i < n / 2 + n % 2; i++) {
            out.print(mut + " ");
        }
        solve(out, n / 2, mut * 2);
    }

}