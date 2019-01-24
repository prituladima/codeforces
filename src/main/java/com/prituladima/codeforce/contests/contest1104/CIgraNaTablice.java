package com.prituladima.codeforce.contests.contest1104;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;


public class CIgraNaTablice {
    String s;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        s = in.nextToken();
        char[] chars = s.toCharArray();

        int state1 = 0;
        int state2 = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                if (state1 == 0) {
                    out.printf("%d %d\n", 1, 1);
                    state1 = 1;
                    continue;
                } else if (state1 == 1) {
                    out.printf("%d %d\n", 3, 1);
                    state1 = 0;
                    continue;
                }
            } else {
                if (state2 == 0) {
                    out.printf("%d %d\n", 1, 2);
                    state2 = 1;
                    continue;
                } else if (state2 == 1) {
                    out.printf("%d %d\n", 2, 2);
                    state2 = 2;
                    continue;
                } else if (state2 == 2) {
                    out.printf("%d %d\n", 3, 2);
                    state2 = 3;
                    continue;
                } else if (state2 == 3) {
                    out.printf("%d %d\n", 4, 2);
                    state2 = 0;
                    continue;
                }
            }

        }


//        out.println(ans);

    }

}