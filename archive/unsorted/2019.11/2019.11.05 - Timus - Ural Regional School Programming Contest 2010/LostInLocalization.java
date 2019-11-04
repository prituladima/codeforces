package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class LostInLocalization {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        String res;
        if (1 <= n && n <= 4) {
            res = "few";
        } else if (5 <= n && n <= 9) {
            res = "several";
        } else if (10 <= n && n <= 19) {
            res = "pack";
        } else if (20 <= n && n <= 49) {
            res = "lots";
        } else if (50 <= n && n <= 99) {
            res = "horde";
        } else if (100 <= n && n <= 249) {
            res = "throng";
        } else if (250 <= n && n <= 499) {
            res = "swarm";
        } else if (500 <= n && n <= 999) {
            res = "zounds";
        } else if (1000 <= n) {
            res = "legion";
        } else {
            throw new IllegalStateException();
        }

        out.println(res);


    }
}
