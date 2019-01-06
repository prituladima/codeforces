package com.prituladima.codeforce.contests.contest1043;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class BPoteryanniiMassiv {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        int[] a = new int[n + 1];
        a[0] = 0;
        for (int i = 1; i < a.length; i++) {
            a[i] = in.nextInt();
        }

        int[] b = new int[n];
//        b[0] = 0;
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i + 1] - a[i];
        }

        List<Integer> res = new ArrayList<>();
        for (int k = 1; k <= n; k++) {
            boolean ans = true;
            for (int j = 0; j < b.length; j++) {
                if(b[j] != b[j % k]){
                    ans = false;
                    break;
                }
            }
            if(ans) res.add(k);
        }

        out.println(res.size());
        for (Integer re : res) {
            out.println(re + " ");
        }

    }
}
