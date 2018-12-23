package com.prituladima.codeforce.contests.contest1085;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CPrefiksiISuffiksi {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        int psn = n * 2 - 2;

        String[] first = new String[n];
        String[] second = new String[n];

        int[] pointer1 = new int[n];
        int[] pointer2 = new int[n];


        int k = 0;
        while (psn-- > 0) {
            String s = in.nextToken();
            int len = s.length();
            if (first[len] == null) {
                first[len] = s;
                pointer1[len] = k++;
            } else {
                second[len] = s;
                pointer2[len] = k++;
            }
        }

        Map<String, Integer> set = new HashMap<>();

        for (int i = 1; i < n; i++) {
            String can = first[i] + second[n - i];
            set.merge(can, 1, Integer::sum);

            can = first[i] + first[n - i];
            set.merge(can, 1, Integer::sum);

            can = second[i] + first[n - i];
            set.merge(can, 1, Integer::sum);

            can = first[i] + second[n - i];
            set.merge(can, 1, Integer::sum);
        }


        String s = null;
        for (String cur : set.keySet()) {
            if (set.get(cur) == n) {
                s = cur;
                out.println(s);
//                return;
            }
        }

        char[] res = new char[2 * n - 2];
        for (int i = 1; i < n; i++) {
            if (s.substring(0, i).equals(first[i])) {
                res[pointer1[i]] = 'P';
//                res += "S";
            } else if (s.substring(0, i).equals(second[i])) {
//                res += "P";
                res[pointer2[i]] = 'P';
            }

            if (s.substring(i, n).equals(first[i])) {
                res[pointer2[i]] = 'S';
            } else if (s.substring(i, n).equals(second[i])){
                res[pointer2[i]] = 'S';
            }

        }


        out.println(new StringBuilder().append(res).toString());

    }
}
