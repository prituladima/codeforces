package com.prituladima.codeforce.contests.contest1072;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.prituladima.codeforce.GeekDP.Pair;


public class CUspetVse {
    int a, b;
    int ans;

    String s;
    private List<Pair> pairs = new ArrayList<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        a = in.nextInt();
        b = in.nextInt();

        long sum = a + b;
        int X = 0;
        for (long x = 1; (x * (x + 1)) / 2 <= sum; x++) {
            X = (int) x;
        }

        boolean[] used = new boolean[X + 1];
        List<Integer> ansN = new ArrayList<>();
        for (int i = X; i > 0; i--) {
            if (!used[i] && a >= i) {
                used[i] = true;
                a -= i;
                ansN.add(i);
            }
        }

        List<Integer> ansM = new ArrayList<>();
        for (int i = X; i > 0; i--) {
            if (!used[i] && b >= i) {
                used[i] = true;
                b -= i;
                ansM.add(i);
            }
        }


//        if(a)

        out.println(ansN.size());
        for (int i = 0; i < ansN.size(); i++) {
            out.print(ansN.get(i) + " ");
        }
        out.println();
        out.println(ansM.size());
        for (int i = 0; i < ansM.size(); i++) {
            out.print(ansM.get(i) + " ");
        }

//        out.println(ans);

    }

}