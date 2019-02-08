package com.prituladima.codeforce.contests.contest1107;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CBrutality {


    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = in.nextIntArray(n);
        String s = in.nextToken();
        char[] chars = s.toCharArray();

        long ans = 0;
        char last = chars[0];

        List<PriorityQueue<Integer>> ansL = new ArrayList<>();
        PriorityQueue<Integer> cur = new PriorityQueue<>(Comparator.reverseOrder());
        cur.add(a[0]);

        for (int i = 1; i < chars.length; i++) {
            if (last != chars[i]) {
                last = chars[i];
                ansL.add(cur);
                cur = new PriorityQueue<>(Comparator.reverseOrder());
            }
            cur.add(a[i]);
        }
        ansL.add(cur);

        for (int i = 0; i < ansL.size(); i++) {
            PriorityQueue<Integer> z = ansL.get(i);
            int oper = Math.min(k, z.size());
            while (oper-- > 0) {
                ans += z.remove();
            }
        }
        out.printLine(ans);

    }


}