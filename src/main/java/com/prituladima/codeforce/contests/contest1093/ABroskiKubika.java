package com.prituladima.codeforce.contests.contest1093;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

public class ABroskiKubika {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0){
            int x = in.nextInt();
            int ans = x % 2 != 0 ? 1 + (x - 3)/2 : x/2;
            out.println(ans);
        }

    }
}
