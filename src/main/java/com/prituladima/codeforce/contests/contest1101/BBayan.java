package com.prituladima.codeforce.contests.contest1101;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class BBayan {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    String s;


    public void solve(int testNumber, InputReader in, PrintWriter out) {

        s = in.nextToken();
        char[] chars = s.toCharArray();

        boolean foundF1 = false;
        int indexF1 = -1;

        boolean foundF2 = false;
        int indexF2 = -1;

        boolean foundG1 = false;
        int indexG1 = -1;

        boolean foundG2 = false;
        int indexG2 = -1;


        for (int i = 0; i < chars.length; i++) {
            char ch = s.charAt(i);
            if (ch == '[' && !foundF1) {
                indexF1 = i;
                foundF1 = true;
            }
            if (ch == ':' && foundF1 && !foundF2) {
                indexF2 = i;
                foundF2 = true;
            }

            int j = chars.length - 1 - i;
            ch = s.charAt(j);
            if (ch == ']' && !foundG1) {
                indexG1 = j;
                foundG1 = true;
            }
            if (ch == ':' && foundG1 && !foundG2) {
                indexG2 = j;
                foundG2 = true;
            }

        }

        if (indexF1 == -1 || indexF2 == -1 || indexG1 == -1 || indexG2 == -1) {
            out.println(-1);
            return;
        }


//        if (!(foundF1 && foundF2 && foundG1 && foundG2)) {
//            out.println(-1);
//            return;
//        }

        if (indexF2 >= indexG2) {
            out.println(-1);
            return;
        }

        int ans = 0;
        ans += 4;
        for (int k = indexF2 + 1; k < indexG2; k++) {
            ans += chars[k] == '|' ? 1 : 0;
        }

        out.println(ans);

//        out.println(ans);

    }

}