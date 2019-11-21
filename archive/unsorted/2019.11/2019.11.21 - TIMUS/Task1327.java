package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Task1327 {
    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final String yes = "YES", no = "NO";
    private static final boolean MULTI_TEST = false;

    private void solve(InputReader in, OutputWriter out) {
        int A = in.nextInt();
        int B = in.nextInt();
        
        out.println(ans(B) - ans(A - 1));

    }

    private int ans(int n){
        return n /2 + n%2;
    }

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int t = MULTI_TEST ? in.nextInt() : 1;
        while (t-- > 0) {
            solve(in, out);
        }
    }
}