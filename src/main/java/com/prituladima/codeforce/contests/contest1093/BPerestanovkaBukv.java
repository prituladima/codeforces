package com.prituladima.codeforce.contests.contest1093;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class BPerestanovkaBukv {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int t = in.nextInt();
        while (t-- > 0) {
            String s = in.nextToken();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                set.add(s.charAt(i));
            }
            if (set.size() == 1) {
                out.println(-1);
                continue;
            }

            if (!s.equals(new StringBuilder(s).reverse().toString())) {
                out.println(s);
                continue;
            }

            char[] chars = s.toCharArray();

            for (int i = 1; i < chars.length; i++) {
                if (chars[0] != chars[i]) {
                    char buf = chars[0];
                    chars[0] = chars[i];
                    chars[i] = buf;
                    break;
                }
            }

            out.println(new StringBuilder().append(chars).toString());

        }

    }
}
