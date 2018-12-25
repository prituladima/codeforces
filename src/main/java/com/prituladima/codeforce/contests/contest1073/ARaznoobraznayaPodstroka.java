package com.prituladima.codeforce.contests.contest1073;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class ARaznoobraznayaPodstroka {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        char[] s = in.nextToken().toCharArray();

        if(s.length == 1){
            out.print("NO");
            return;
        }

        for (int i = 1; i < n; i++) {
            if(s[i - 1] != s[i]){
                out.println("YES");
                out.println(s[i - 1] + ""+ s[i]);
                return;
            }
        }
        out.print("NO");

//        Set<Character> set = new HashSet<>();

//        for (char c : s.toCharArray()) {
//            set.
//        }


    }
}
