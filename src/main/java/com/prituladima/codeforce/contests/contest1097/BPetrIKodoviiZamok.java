package com.prituladima.codeforce.contests.contest1097;

import com.prituladima.codeforce.GeekMath;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class BPetrIKodoviiZamok {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        int[] a = in.nextArr(n);

        int MAX = 1 << n;

        for (int i = 1; i < MAX; i++) {
            long res = 0L;
            char[] arr = GeekMath.toBitString(i, n).toCharArray();
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
}
