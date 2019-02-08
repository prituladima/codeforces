package com.prituladima.codeforce.contests.contest1104;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.LinkedList;


public class BIgraSoStrokoi {
    String s;
    String YES = "Yes", NO = "No";

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        s = in.nextToken();
        char[] chars = s.toCharArray();
        int ans = 0;
        LinkedList<Character> stack = new LinkedList<>();
//        stack.addLast(chars[0]);
        for (int i = 0; i < chars.length; i++) {
            if (!stack.isEmpty() && stack.getLast() == chars[i]) {
                stack.removeLast();
                ans++;
            } else {
                stack.addLast(chars[i]);
            }
        }

        out.println(ans % 2 != 0 ? YES : NO);

    }

}