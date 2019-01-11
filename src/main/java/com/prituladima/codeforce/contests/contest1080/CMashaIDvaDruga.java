package com.prituladima.codeforce.contests.contest1080;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class CMashaIDvaDruga {


    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long T = in.nextLong();
        while (T-- > 0) {
            long n = in.nextLong(), m = in.nextLong();
            long
                    x1 = in.nextLong(),
                    y1 = in.nextLong(),
                    x2 = in.nextLong(),
                    y2 = in.nextLong(),

                    x3 = in.nextLong(),
                    y3 = in.nextLong(),
                    x4 = in.nextLong(),
                    y4 = in.nextLong();

            long whiteCounter = calcWhite(n, m);
            long blackCounter = calvBlack(n, m);

            long excludeBlack = GeekInteger.equalParity(x1, y1)
                    ?
                    calvBlack(y2 - y1 + 1, x2 - x1 + 1)
                    :
                    calcWhite(y2 - y1 + 1, x2 - x1 + 1);
            whiteCounter += excludeBlack;
            blackCounter -= excludeBlack;


            long excludeWhite = GeekInteger.equalParity(x3, y3)
                    ?
                    calcWhite(y4 - y3 + 1, x4 - x3 + 1)
                    :
                    calvBlack(y4 - y3 + 1, x4 - x3 + 1);
            whiteCounter -= excludeWhite;
            blackCounter += excludeWhite;

            long xc1 = Math.max(x1, x3),
                    yc1 = Math.max(y1, y3),
                    xc2 = Math.min(x2, x4),
                    yc2 = Math.min(y2, y4);

            if (xc1 <= xc2 && yc1 <= yc2) {
                long includeBlack = GeekInteger.equalParity(xc1, yc1)
                        ?
                        calvBlack(yc2 - yc1 + 1, xc2 - xc1 + 1)
                        :
                        calcWhite(yc2 - yc1 + 1, xc2 - xc1 + 1);
                whiteCounter -= includeBlack;
                blackCounter += includeBlack;
            }
            out.println(whiteCounter + " " + blackCounter);
        }
    }

    private long calcWhite(long n, long m) {
        return (n * m) / 2 + (n * m) % 2;
    }

    private long calvBlack(long n, long m) {
        return (n * m) / 2;
    }
}