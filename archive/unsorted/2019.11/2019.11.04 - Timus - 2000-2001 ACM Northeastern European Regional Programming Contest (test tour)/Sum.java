package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class Sum {
    public void solve(int testNumber, InputReader in, OutputWriter out) {
        int N = in.nextInt();
        int ans = 0;
        if(N > 1){
            if((N & 1) == 0){
                ans = (1 + N) * (N / 2);
            }else {
                N++;
                ans = (1 + N) * (N / 2) - N;
            }
        }else if(N == 1){
            ans = 1;
        }else if(N == 0){
            ans = 1;
        }else if(N == -1){
            ans = 0;
        }else if(N < -1){
            N = -N;
            if((N & 1) == 0){
                ans = (1 + N) * (N / 2);
            }else {
                N++;
                ans = (1 + N) * (N / 2) - N;
            }
            ans = -ans + 1;
        }
        out.println(ans);
    }
}