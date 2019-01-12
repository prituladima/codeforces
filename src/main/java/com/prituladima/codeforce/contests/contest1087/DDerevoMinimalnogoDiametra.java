package com.prituladima.codeforce.contests.contest1087;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class DDerevoMinimalnogoDiametra {

    private static class Edge{
        int first;
        int second;

        public Edge(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int n = in.nextInt(), s = in.nextInt();
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            list.add(new Edge(in.nextInt(), in.nextInt()));
        }



    }
}
