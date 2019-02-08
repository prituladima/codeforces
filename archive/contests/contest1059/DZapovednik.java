package com.prituladima.codeforce.contests.contest1059;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.prituladima.codeforce.GeekDP.Pair;


public class DZapovednik {
    int n;
    private List<Pair> pairs = new ArrayList<>();
    double ans;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextInt();
        for (int i = 0; i < n; i++) pairs.add(new Pair(i, in.nextInt(), in.nextInt()));
        boolean anyPositive = false;
        boolean anyNegative = false;
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).getSecond() > 0) anyPositive = true;
            if (pairs.get(i).getSecond() < 0) anyNegative = true;
        }
        if (anyNegative && anyPositive) {
            out.print(-1);
            return;
        }

        if (anyNegative) {
            for (int i = 0; i < pairs.size(); i++) {
                pairs.get(i).setSecond(pairs.get(i).getSecond() + 1);
            }
        }

        out.println(ans);

    }

}