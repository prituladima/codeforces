package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class AIzmenenieGromkosti {
    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final String yes = "YES", no = "NO";
    private static final boolean MULTI_TEST = true;

    private void solve(InputReader in, OutputWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();

        if (a == b) {
            out.println(0);
        } else {
            int ans = 0;
            int diff = Math.abs(b - a);
            ans += diff / 5;
            int small = diff % 5;
            if(small == 4){
                ans += 2;
            }else if(small == 0){
                ans += 0;
            }else if(small == 3){
                ans += 2;
            }else {
                ans += 1;
            }

            out.println(ans);
        }
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = MULTI_TEST ? in.nextInt() : 1;
        while (t-- > 0) {
            solve(in, out);
        }
    }
}
