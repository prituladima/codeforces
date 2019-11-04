package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Factorials {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.nextInt();
        int len = in.nextToken().length();
        int ans = 1;
        for(int i = n; i > 0; i -= len){
            ans *= i;
        }
        out.println(ans);

    }
}