package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.numbers.IntegerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CProstiePrefiksnieSummi {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;
    int ones = 0, twos = 0;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        a = in.nextIntArray(n);

        for (int i = 0; i < n; i++) {
            if (a[i] == 1) ones++;
            else twos++;
        }


        if (n == 1) {
            out.printLine(a[0]);
        } else if (twos == 0) {
            for (int i = 0; i < n; i++) {
                out.print(a[i]).space();
            }
            out.printLine();

        } else if (ones == 0) {
            for (int i = 0; i < n; i++) {
                out.print(a[i]).space();
            }
            out.printLine();
        } else {

            final int[] primes = IntegerUtils.generatePrimes(15_000_010);

            List<Integer> diff = new ArrayList<>();
            diff.add(2);
            for (int i = 0; i < primes.length - 1; i++) {
                diff.add(primes[i + 1] - primes[i]);
            }

            List<Integer> res = new ArrayList<>();
            int need = 0;
            for (final Integer val : diff) {
                final List<Integer> cover = get12(val + need);
                if (cover.size() == 0) {
                    need += val;
                    break;
                } else {
                    res.addAll(cover);
                    need = 0;
                }
                if (ones == 0 && twos == 0) break;
            }

            if (ones == 0 || twos == 0) {
                int local2 = twos;
                int local1 = ones;
                for (int i = 0; i < local2; i++) {
                    res.add(2);
                    twos--;
                }
                for (int i = 0; i < local1; i++) {
                    res.add(1);
                    ones--;
                }
            }
            for (Integer re : res) {
                out.print(re).space();
            }
            out.printLine();
        }
    }

    private List<Integer> get12(int diff) {
        List<Integer> res = new ArrayList<>();
        if (diff == 2) {
            if (twos > 0) {
                res.add(2);
                twos--;
            } else if (ones > 1) {
                res.add(1);
                res.add(1);
                ones -= 2;
            } else {
                res.add(1);
                ones--;
            }
        } else if (diff == 1) {
            if (ones > 0) {
                res.add(1);
                ones--;
            }
        } else {
            if (2 * twos >= diff) {
                for (int i = 0; i < diff / 2; i++) {
                    res.add(2);
                    twos--;
                }
            } else if (ones + 2 * twos >= diff) {
                int local2 = twos;
                int local1 = ones;
                for (int i = 0; i < local2; i++) {
                    res.add(2);
                    twos--;
                }
                for (int i = 0; i < diff - 2 * local2; i++) {
                    res.add(1);
                    ones--;
                }

            } else {
                int local2 = twos;
                int local1 = ones;
                for (int i = 0; i < local2; i++) {
                    res.add(2);
                    twos--;
                }
                for (int i = 0; i < local1; i++) {
                    res.add(1);
                    ones--;
                }
            }
        }
        return res;
    }


}