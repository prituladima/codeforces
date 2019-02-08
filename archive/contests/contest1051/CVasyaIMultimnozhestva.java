package com.prituladima.codeforce.contests.contest1051;

import com.prituladima.codeforce.GeekInteger;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CVasyaIMultimnozhestva {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt();
        int[] s = in.nextArr(n);

        Map<Integer, Integer> ms = GeekInteger.multiSet(s);
        Set<Integer> ones = new HashSet<>();
        Set<Integer> doubles = new HashSet<>();
        Set<Integer> many = new HashSet<>();
        for (int key : ms.keySet()) {
            if (ms.get(key) == 1) {
                ones.add(key);
            }
            if (ms.get(key) == 2) {
                doubles.add(key);
            }
            if (ms.get(key) > 2) {
                many.add(key);
            }

        }
        if (ones.size() % 2 != 0 && many.isEmpty()) {
            out.println("NO");
            return;
        }

        int k = Integer.MAX_VALUE;
        if (ones.size() % 2 != 0) {
            k = many.iterator().next();
//            ones.add(many.iterator().next());
        }

        int onesHalf = ones.size() / 2 ;
        int tho = doubles.size();
        out.println("YES");

//        int kos =
        for (int i = 0; i < n; i++) {

            if (ones.contains(s[i])) {
                if (onesHalf > 0) {
                    out.print("B");
                    onesHalf--;
//                    if ()
//                        ones.remove(s[i]);
                } else {
                    out.print("A");
                }
                continue;
            }

            if (k == (s[i])) {
//                if (onesHalf > 0) {
                    out.print("B");
                    k = Integer.MAX_VALUE;
//                    onesHalf--;
//                    if ()
//                        ones.remove(s[i]);
//                } else {
//                    out.print("A");
//                }
                continue;
            }

            if (doubles.contains(s[i])) {
                if (tho > 0) {
                    out.print("B");
                    tho--;
                } else {
                    out.print("A");
                }
                continue;
            }
            out.print("A");


        }


    }
}
