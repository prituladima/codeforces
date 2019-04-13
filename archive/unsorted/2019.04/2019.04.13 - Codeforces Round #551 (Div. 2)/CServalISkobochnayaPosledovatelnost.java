package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.Arrays;

public class CServalISkobochnayaPosledovatelnost {
    int n;
    char[] s;
    String YES = "Yes", NO = "No", NO_ANS = ":(";

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        if (n % 2 == 1) {
            out.print(NO_ANS);
            return;
        }

        s = in.nextToken().toCharArray();
        if (s[0] == ')' || s[n - 1] == '(') {
            out.print(NO_ANS);
            return;
        }
        s[0] = '(';
        s[n - 1] = ')';

        int lev = 0;
        int L_REMIND = 0;


        for (int i = 1; i < n - 1; i++) {
            char c = s[i];
            if (c == '(') L_REMIND++;
        }
        L_REMIND = (n - 2)/2 - L_REMIND;

        if(L_REMIND < 0) {
            out.print(NO_ANS);
            return;
        }

        for (int i = 1; i < n - 1; i++) {

            if (s[i] == '?') {
                if (L_REMIND > 0) {
                    s[i] = '(';
                    L_REMIND--;
                } else {
                    s[i] = ')';
                }
            }

            if (s[i] == '(') {
                lev++;
            } else if (s[i] == ')') {
                lev--;
            }

            if (lev < 0) {
                out.print(NO_ANS);
                return;
            }
        }

        out.printLine(lev != 0 ? NO_ANS : String.valueOf(s));

    }

}