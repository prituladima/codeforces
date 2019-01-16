package com.prituladima.codeforce.contests.contest1101;

import com.prituladima.codeforce.GeekLong;
import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;

public class AMinimalnoeChislo {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    int n, m;
    int[] a;
    long L, R, D;
    int ans;
    int min = INF, max = -INF;
    String s;
    int t;


    public void solve(int testNumber, InputReader in, PrintWriter out) {
        t = in.nextInt();
//        nes:
        while (t-- > 0) {
            L = in.nextLong();
            R = in.nextLong();
            D = in.nextLong();


            if(D < L){
                out.println(D);
                continue ;
            }else {
                out.println(GeekLong.ceiling(R+1, D) * D);
            }

//            for (long i = D; i < L; i += D) {
//                out.println(i);
//                continue nes;
//            }

//            for (long i = GeekLong.ceiling(R, D) * D; i <= INF; i+=D) {
//                out.println(i);
//                continue nes;
//            }


//            out.println(ans);
        }

    }

}