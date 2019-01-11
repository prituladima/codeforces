package com.prituladima.codeforce.contests.contest1043;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class CNaimensheeSlovo {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        String s = in.nextToken();
        boolean[] write = new boolean[s.length()];
        for (int i = 1; i < s.length(); ++i)
            if (s.charAt(i) == 'a') {
                write[i - 1] ^= true;
                write[i] = true;
            }
        for (int i = 0; i < s.length(); i++) {
            out.print((write[i] ? 1 : 0) + " ");
        }

    }

}
