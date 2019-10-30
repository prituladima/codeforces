package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;
import com.prituladima.yaal.numbers.IntegerUtils;

import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class DPrimeGraph {

    private int MAXN = 1000;
    private int MAXM = MAXN * (MAXN - 1) / 2;
    boolean[] primes = IntegerUtils.generatePrimarilyTable(MAXM + 1);

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int m = n + n / 2;
        for(int e = n; e <= m; e++) {
            if(primes[e]){
                int diff = e - n;
                out.println(e);
                Set<Integer> rem = new LinkedHashSet<>();
                for(int i = 1; i <= n; i++){
                    out.printf("%d %d\n", i, (i+1) == (n + 1) ? 1 : i + 1  );

                }
                for (int i = n; i > 0; i--) {
                    rem.add(i);
                }
                for(int i = 1; i <= diff; i ++){
                    rem.remove(i);
                }

                for(int i = 1; i <= diff; i++){
                    int toRem = -1;
                    for(int to: rem){
                        if(Math.abs(to - i) == 1 || Math.abs(to - i) == n - 1)continue;
                        else {toRem = to; out.printf("%d %d\n", i, to ); break;}
                    }
                    rem.remove(toRem);
                }

                return;

            }
        }

        out.println(-1);
    }

    private boolean ansCanBeBuild(int v, int e) {

        return false;
    }
}