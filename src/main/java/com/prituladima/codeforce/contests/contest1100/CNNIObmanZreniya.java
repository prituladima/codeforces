package com.prituladima.codeforce.contests.contest1100;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

public class CNNIObmanZreniya {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        double n = in.nextDouble(), R = in.nextDouble();

//        double a = 2 + 4 * Math.cos(2*Math.PI / n);
//        double b = 4*R*(1 + Math.cos(2*Math.PI / n));
//        double c = 2 * R * R;
//        double D = b*b - 4*a*c;
//
//        double ans = -b + Math.sqrt(D);
//        ans /= 2*a;

        double sin = Math.sin(Math.PI/n);
        out.print(Math.abs(R*sin/(sin-1)));

    }
}
