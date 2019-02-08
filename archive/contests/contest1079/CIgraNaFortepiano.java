package com.prituladima.codeforce.contests.contest1079;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class CIgraNaFortepiano {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        int[] a = in.nextArr(n);
        int[] b = new int[n];

        if (n == 1) {
            out.println(1);
            return;
        }

        int curLenNatural = 0;
        int maxLenNatural = Integer.MIN_VALUE;

        int curLenReverce = 0;
        int maxLenReverce = Integer.MIN_VALUE;

        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                curLenNatural++;
                maxLenNatural = Math.max(maxLenNatural, curLenNatural);
            } else {
                curLenNatural = 0;
            }

            if (a[i - 1] > a[i]) {
                curLenReverce++;
                maxLenReverce = Math.max(maxLenReverce, curLenReverce);
            } else {
                curLenReverce = 0;
            }

        }

        if (maxLenNatural > 5 || maxLenReverce > 5) {
            out.println(-1);
            return;
        }

        if (a[0] < a[1]) {
            b[0] = 1;
        }
        if (a[0] > a[1]) {
            b[0] = 5;
        }


        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] < a[i]) {
                if (b[i - 1] != 0)
                    b[i] = b[i - 1] + 1;
                else
                    b[i] = 2;
            }
            if (a[i - 1] > a[i]) {
                if (b[i - 1] != 0)
                    b[i] = b[i - 1] - 1;
                else
                    b[i] = 4;
            }
        }

        for (int i = 1; i < b.length; i++) {
            if (b[i - 1] == 0) {
                if (b[i - 1] < b[i]) {

                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            out.print(b[i] + " ");
        }

    }
}
