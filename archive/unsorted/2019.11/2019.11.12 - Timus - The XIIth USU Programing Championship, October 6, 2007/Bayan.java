package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class Bayan {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        Set<String> used = new HashSet<>();
        int ans = 0;
        while (n-- > 0) {
            final String s = in.readLine();
            if (used.contains(s)) {
                ans++;
            } else {
                used.add(s);
            }
        }

        out.println(ans);
    }
}
