package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;

import static java.lang.Math.max;

public class CDiametrDereva {

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int tt = in.nextInt();
        while (tt-- > 0) {
            int n = in.nextInt();
            int ans = 0;
            for (int bit = 0; bit < 9; bit++) {
                ArrayList<Integer> a = new ArrayList<>();
                ArrayList<Integer> b = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if ((i >> bit) % 2 == 1) {
                        a.add(i);
                    } else {
                        b.add(i);
                    }
                }
                if (a.isEmpty() || b.isEmpty()) {
                    continue;
                }
                out.print(a.size()).space().print(b.size());
                for (int x : a) {
                    out.space().print(x + 1);
                }
                for (int x : b) {
                    out.space().print(x + 1);
                }
                out.printLine().flush();
                int foo = in.nextInt();
                ans = max(ans, foo);
            }
            out.print(-1).space().print(ans).printLine().flush();
        }
    }

}