package com.prituladima.codeforce.contests.contest1084;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.GeekLong;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class COrehusIStroka {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int mod = (int) 1e9 + 7;
        String s = in.nextToken();

        char[] chars = s.toCharArray();

        int k = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'b') {
                chars[k++] = chars[i];
            }
        }
        chars = Arrays.copyOf(chars, k);
        int curAAmount = 0;
        List<Long> ans = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == 'a') {
                curAAmount++;
            }
            if ((curAAmount != 0 && chars[i] == 'b') || i == chars.length - 1) {
                ans.add(curAAmount + 1L);
                curAAmount = 0;
            }
        }

        out.println(GeekLong.multiplication(mod, GeekLong.toArray(ans)) - 1);
    }
}
