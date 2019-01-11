package com.prituladima.codeforce.contests.contest1079;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class BImennoiKubok {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        String s = in.nextToken();

        int length = s.length();

        int row = GeekInteger.ceiling(length, 20);

        for (int i = row; i <= 5; i++) {
            for (int j = 1; j <= 20; j++) {
                int diff = j * i - length;
                if (0 <= diff && diff < row) {
                    printRes(out, i, j, length, s, diff);
                    return;
                }
            }
        }


    }

    private void printRes(PrintWriter out, int ansRow, int ansCol, int length, String s, int diff) {
        out.println(ansRow + " " + ansCol);
//        diff
        boolean lastTiim = true;
        int i = 0;
        for (int k = 0; k < ansRow * ansCol; k++) {
            if (lastTiim && diff-- > 0) {
                out.print("*");
                lastTiim = false;
            } else {
                char c = s.charAt(i++);
                out.print(c);
            }
            if ((k + 1) % ansCol == 0) {
                out.println();
                lastTiim = true;
            }
        }
    }
}
