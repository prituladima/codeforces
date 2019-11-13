package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class EasyToHack {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[] s = in.nextToken().toCharArray();
        if (s.length == 0) return;

        int[] a = new int[s.length];

        for (int i = 0; i < s.length; i++) {
            a[i] = (s[i] - 'a');
        }

        if (a[0] < 5) a[0] += 26;

        for (int i = 1; i < s.length; i++) {
            while (a[i] < a[i - 1]) {
                a[i] += 26;
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = s.length - 1; i >= 1; i--) {
            a[i] -= a[i - 1];
            sb.append((char) ('a' + a[i]));
        }

        a[0] -= 5;
        sb.append((char)('a' + a[0]));

//        out.println(Arrays.toString(a));
        out.println(sb.reverse().toString());


    }
}
