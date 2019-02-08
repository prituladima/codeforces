package com.prituladima.codeforce.contests.contest1085;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class APravoLevoeShifrovanie {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        String s = in.nextToken();
        int n = s.length();
        if (n % 2 != 0) {
            s = s + "-";
            n++;
        }

        String ans = "";
        int len = n / 2;
        for (int i = 0; i < len; i++) {
            ans += s.charAt(n - 1 - i);
            ans += s.charAt(i);
        }

        out.println(new StringBuilder().append(ans).reverse().toString().replaceAll("-", ""));


    }
}
