package com.prituladima.codeforce.contests.contest1073;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

public class BVasyaIKnigi {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        int[] a = in.nextArr(n);
        int[] b = in.nextArr(n);

        int startNext = 0;

        Set<Integer> removed = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int ans = 0;
            if (!removed.contains(b[i]))
                for (int j = startNext; j < n; j++) {
                    removed.add(a[j]);
                    ans++;
                    if (b[i] == a[j]) {
                        startNext = j + 1;
                        break;
                    }
                }

            out.print((ans) + " ");

        }


    }
}
