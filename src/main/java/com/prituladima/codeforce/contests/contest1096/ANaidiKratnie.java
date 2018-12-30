package com.prituladima.codeforce.contests.contest1096;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

public class ANaidiKratnie {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long T = in.nextLong();
        while (T-- > 0){
            //
            long L = in.nextLong(), R = in.nextLong();
            R = L * 2;
            out.println(L + " " + R);
        }
    }
}
