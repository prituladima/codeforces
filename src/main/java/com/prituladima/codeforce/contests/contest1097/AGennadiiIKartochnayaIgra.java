package com.prituladima.codeforce.contests.contest1097;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

public class AGennadiiIKartochnayaIgra {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        String[] input = new String[6];
        for (int i = 0; i < 6; i++) {
            input[i] = in.nextToken();
        }

        for (int i = 1; i < 6; i++) {
            if(input[0].charAt(0) == input[i].charAt(0) || input[0].charAt(1) == input[i].charAt(1)){
                out.print("YES");
                return;
            }
        }

        out.print("NO");
    }
}
