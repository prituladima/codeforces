package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Task1991 {
    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final String yes = "YES", no = "NO";
    private static final boolean MULTI_TEST = false;

    private void solve(InputReader in, OutputWriter out) {

        int n = in.nextInt();
        int m = in.nextInt();

        int notUsed = 0;
        int alive = 0;

        while (n-- > 0){
            int cur = in.nextInt();
            if(m > cur){
                alive += m - cur;
            }else {
                notUsed += cur - m;
            }
        }

        out.printf("%d %d\n", notUsed, alive);
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = MULTI_TEST ? in.nextInt() : 1;
        while (t-- > 0) {
            solve(in, out);
        }
    }
}