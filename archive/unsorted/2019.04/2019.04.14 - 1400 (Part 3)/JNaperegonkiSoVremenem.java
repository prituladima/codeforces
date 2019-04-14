package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class JNaperegonkiSoVremenem {
    int h, m, s, t1, t2;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        h = in.nextInt() * 5 % 60;
        m = in.nextInt() % 60;
        s = in.nextInt() % 60;

        t1 = in.nextInt() * 5 % 60;
        t2 = in.nextInt() * 5 % 60;

        boolean clockWise = true;
        boolean counterClockWise = true;

        for (int t = t1; t != t2; t = (t + 1) % 60) {
            if (t == h || t == m || t == s) clockWise &= false;
        }

        for (int t = t2; t != t1; t = (t + 1) % 60) {
            if (t == h || t == m || t == s) counterClockWise &= false;
        }
        out.printLine((clockWise || counterClockWise) ? "YES" : "NO");
    }

}