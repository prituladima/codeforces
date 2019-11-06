package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashSet;
import java.util.Set;

public class PsychUpsEigenvalues {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n1 = in.nextInt();
        int[] a1 = in.nextIntArray(n1);
        int n2 = in.nextInt();
        int[] a2 = in.nextIntArray(n2);
        int n3 = in.nextInt();
        int[] a3 = in.nextIntArray(n3);

        Set<Integer> set1 = new HashSet<>();
        for (int i = 0; i < n1; i++) {
            set1.add(a1[i]);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i = 0; i < n2; i++) {
            set2.add(a2[i]);
        }

        Set<Integer> set3 = new HashSet<>();
        for (int i = 0; i < n3; i++) {
            set3.add(a3[i]);
        }

        int ans = 0;
        for(int val : set1){
            ans += set2.contains(val) && set3.contains(val) ? 1 : 0;
        }
        out.println(ans);
    }
}
