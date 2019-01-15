package com.prituladima.codeforce.contests.contest1051;

import com.prituladima.codeforce.GeekLong;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BVzaimnoProstiePari {
    public void solve(int testNumber, InputReader in, PrintWriter out) {

        long L = in.nextLong(), R = in.nextLong();
        long p = R - L + 1;
        p /= 2;

        List<Long> first = new ArrayList<>();
        List<Long> second = new ArrayList<>();

//        out.println("");

        Set<Long> used = new HashSet<>();
        for (long i = L; i <= R; i+=2) {
//            if (!used.contains(i))
//                for (long k = L; k <= R; k++) {
//                    if (!used.contains(k))
//                        if (k != i && GeekLong.gcd(k, i) == 1) {
//                            used.add(k);
//                            used.add(i);
                            first.add(i);
                            second.add(i+1);
//                            break;
//                        }
//                }
//            out.println(i + " " + j);
        }

        if (p != first.size()) {
            out.println("NO");
            return;
        }

        out.println("YES");
        for (int i = 0; i < first.size(); i++) {
            out.printf("%d %d\n", first.get(i), second.get(i));
        }

//        GeekLong.gcd()

    }


//    private long getSumAns(long L, long R) {
//        if (L == 1) return sum(R);
//
//        return sum(R) - sum(L - 1);
//    }
//
//    private long sum(long R) {
//
//        boolean even = R % 2 == 0;
//
//
//        R = (R + 1) / 2;
//        if (even) {
//            return (R);
//        } else {
//            return -R;
//        }
//
//    }
}
