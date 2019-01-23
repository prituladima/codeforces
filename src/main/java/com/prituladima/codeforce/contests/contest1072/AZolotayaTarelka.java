package com.prituladima.codeforce.contests.contest1072;

import static com.prituladima.codeforce.GeekDP.Pair;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;



public class AZolotayaTarelka {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    int v, h, k, ans;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        v = in.nextInt();
        h = in.nextInt();
        k = in.nextInt();

        ans = 0;
        while (k -- >0){
            if(h == 1){
                ans += v;
                break;
            }

            if(v == 1){
                ans += h;
                break;
            }

            ans += 2*(v-1) + 2*(h-1);
            v-=4;
            h-=4;

        }

        out.println(ans);

    }

}