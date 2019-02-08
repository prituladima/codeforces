package com.prituladima.codeforce.contests.contest1068;

import static com.prituladima.codeforce.GeekDP.Pair;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

import java.util.*;


public class BNOK {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    int n, m;
    int[] a;
    long L, b;
    int ans;
    int min = INF, max = -INF;
    String s;
    private List<Pair> pairs = new ArrayList<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        b = in.nextLong();

//        ans = 1;
        Set<Long> res = new HashSet<>();
        for(long i = 2; i*i <= b;i++){
            if(b % i == 0){
               long temp = b /i;
               res.add(temp);
               res.add(i);
            }
        }

        res.add(1L);
        res.add(b);

        out.println(res.size());

    }

}