package com.prituladima.codeforce.contests.contest1059;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static com.prituladima.codeforce.GeekDP.Pair;


public class AKassir {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    int n, m;
    int a;
    long L, R;
    long ans;
    int min = INF, max = -INF;
    String s;
    private List<Pair> pairs = new ArrayList<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextInt();
        L = in.nextInt();
        a = in.nextInt();

        if (n == 0) {
            out.print(L / a);
            return;
        }

        for (int i = 0; i < n; i++) pairs.add(new Pair(i, in.nextInt(), in.nextInt()));

        pairs.sort(Comparator.comparing(Pair::getFirst));

        ans += pairs.get(0).getFirst() / a;
        ans += (L - (pairs.get(pairs.size() - 1).getFirst() + pairs.get(pairs.size() - 1).getSecond())) / a;

        for (int i = 0; i < pairs.size() - 1; i++) {
            ans += (pairs.get(i + 1).getFirst() - (pairs.get(i).getFirst() + pairs.get(i).getSecond())) / a;
        }

        out.println(ans);

    }

}