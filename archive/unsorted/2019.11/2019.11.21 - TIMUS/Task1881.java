package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

public class Task1881 {
    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final String yes = "YES", no = "NO";
    private static final boolean MULTI_TEST = false;

    private void solve(InputReader in, OutputWriter out) {

        int h = in.nextInt();
        int w = in.nextInt();
        int n = in.nextInt();
        int amountOfLines = 1;

        int curBufferSize = 0;
        for (int i = 0; i < n; i++) {
            String cur = in.nextToken();

            if (curBufferSize == 0) {
                curBufferSize = cur.length();
            } else if (curBufferSize + 1 + cur.length() <= w) {
                curBufferSize += 1 + cur.length();
            } else {
                amountOfLines++;
                curBufferSize = cur.length();
            }


        }

        out.println((amountOfLines + h - 1) / h);

    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = MULTI_TEST ? in.nextInt() : 1;
        while (t-- > 0) {
            solve(in, out);
        }
    }
}