package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class Recruits {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int nn = in.nextInt();
        int n = nn;
        StringBuilder sb = new StringBuilder();
        while (nn > 0) {
            String str = in.nextToken();
            nn -= str.length();
            sb.append(str);
        }

        char[] s = sb.toString().toCharArray();

        //<
        int[] suff = new int[n];
        if (s[n - 1] == '<')
            suff[n - 1]++;
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1];
            if (s[i] == '<')
                suff[i]++;
        }

        int ans = 0;
        //>
        for (int i = 0; i < n - 1; i++) {
            if (s[i] == '>')
                ans += suff[i];
        }

        out.println(ans);
    }
}
