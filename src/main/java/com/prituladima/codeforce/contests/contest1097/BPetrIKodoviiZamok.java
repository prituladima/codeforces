package com.prituladima.codeforce.contests.contest1097;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class BPetrIKodoviiZamok {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        int[] a = in.nextArr(n);

        int MAX = 1 << n;

        for (int i = 1; i < MAX; i++) {
            long res = 0L;
            char[] arr = toBi(i, n).toCharArray();
            int k = 0;
            for (char c : arr) {
                res += (c == '1') ? a[k] : -a[k];
                k++;
            }
            if (res % 360 == 0) {
                out.print("YES");
                return;
            }
        }
        out.print("NO");
    }

    private String toBi(int i, int n) {
        String bits = Integer.toString(i, 2);
        StringBuilder sb = new StringBuilder();

        for (int toPrepend = n - bits.length(); toPrepend > 0; toPrepend--) {
            sb.append('0');
        }
        sb.append(bits);
        return sb.toString();
    }
}
