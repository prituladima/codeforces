package com.prituladima.codeforce.contests.contest1043;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CNaimensheeSlovo {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        String s = in.nextToken();

        int Rindex = 0;
        int curLIndex = 0;
        int Lindex = 0;


        int maxSubArra = 0;
        int cur = 0;
        boolean lasrWasB = true;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                if (lasrWasB) {
                    lasrWasB = false;
                    curLIndex = i;
                }
                cur++;
                if (maxSubArra <= cur) {
                    maxSubArra = cur;
                    Rindex = i;
                    Lindex = curLIndex;
                }
            } else {
                lasrWasB = true;
                cur = 0;
            }
        }

        int max = max(s.substring(0, Lindex), new StringBuilder(s.substring(0, Lindex)).reverse().toString());


        for (int i = 0; i < s.length(); i++) {
            out.print(((i == Lindex - 1 && max == 1) || (i == Rindex) ? 1 : 0) + " ");
        }

    }

    private int max(String s1, String s2) {
        if (s1.compareTo(s2) > 0) {
            return 2;
        }
        return 1;
    }
}
