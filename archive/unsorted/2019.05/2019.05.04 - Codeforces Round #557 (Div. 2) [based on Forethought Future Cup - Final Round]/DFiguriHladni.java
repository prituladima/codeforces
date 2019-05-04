package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class DFiguriHladni {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        final int n = in.nextInt();
        if (n == 2) {
            out.printLine("YES");
            return;
        }
        final int m = in.nextInt();

        int[] ley = new int[n + 2];

        for (int i = 0; i < m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            a = min;
            b = max;
            int h = n / 2;
            if (b - a > h) {
                color(ley, b, ley.length - 1);
                color(ley, 1, a + 1);
            } else if (b - a < h) {
                color(ley, a, b + 1);
            } else
//                if (n >= 4)
            {
                int Q1 = a + 1, Q2 = b - 1, P1 = b + 1, P2 = a - 1;
                if (P2 == 0) {
                    P2 = n;
                    color(ley, P1, ley.length - 1);
                } else {
                    color(ley, P1, ley.length - 1);
                    color(ley, 1, P2 + 1);
                }


                color(ley, Q1, Q2 + 1);


            }
        }
        for (int i = 1; i < ley.length; i++) {
            ley[i] += ley[i - 1];
        }

//        out.print(ley);
        Set<Integer> divisors = new HashSet<>();
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                divisors.add(n / i);
            }
        }

        divisors.remove(n);
        List<Integer> list = new ArrayList<>(divisors);
        list.sort(Comparator.reverseOrder());

        boolean ok = false;
        for (int div : list) {
            ok |= okWithK(ley, div);
        }
        if (ok) {
            out.printLine("Yes");
        } else {
            out.printLine("No");
        }

    }

    private void color(int[] lay, int L, int R) {
        lay[L]++;
        lay[R]--;
    }

    private boolean okWithK(int[] a, int p) {
        boolean ok = true;
        for (int i = 1; i <= p; i++) {
            int cur = a[i];
            for (int j = i + p; j <= a.length - 2; j += p) {
                ok &= cur == a[j];
            }
        }
        return ok;
    }
}