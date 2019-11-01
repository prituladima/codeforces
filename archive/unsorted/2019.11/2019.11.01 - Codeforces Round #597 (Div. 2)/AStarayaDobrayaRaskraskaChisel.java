package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import static com.prituladima.codeforce.Geeks.gcd;

public class AStarayaDobrayaRaskraskaChisel {
    String Infinite = "Infinite", Finite = "Finite";

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();

            if(gcd(a, b) != 1) out.println(Infinite);else out.println(Finite);
        }
    }


}
