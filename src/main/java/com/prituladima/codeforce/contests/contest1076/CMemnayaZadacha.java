package com.prituladima.codeforce.contests.contest1076;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class CMemnayaZadacha {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int d = in.nextInt();//, b = in.nextInt();


            int D = d * d - 4 * d;
            if (D < 0) {
                out.println("N");
            } else {
                double b = d + Math.sqrt(D);
                b /= 2;
                double a = b == 0 ? 0.0 : d / b;
                out.println("Y " + a + " " + b);
            }
        }

    }
}
