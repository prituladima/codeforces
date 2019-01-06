package com.prituladima.codeforce.contests.contest1043;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

public class AVibori {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        int[] a = in.nextArr(n);

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            max = Math.max(max, a[i]);
        }

        int all = max * n;
        int sum2 = all - sum;
        int k = max;
        while (sum2 <= sum){
            sum2 += n;
            k++;
        }
        out.println(k);
    }
}
