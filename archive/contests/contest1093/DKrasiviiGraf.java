package com.prituladima.codeforce.contests.contest1093;

import com.prituladima.codeforce.InputReader;
import com.prituladima.geeksforgeeks.graphs.Graph;

import java.io.PrintWriter;

public class DKrasiviiGraf {
    int MODULO = 998244353;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt(), m = in.nextInt();
            int[] u = new int[m];
            int[] v = new int[m];
            for (int i = 0; i < m; i++) {
                u[i] = in.nextInt();
                v[i] = in.nextInt();
            }
            //SOLVE
            Graph g = new Graph(n);
            for (int i = 0; i < m; i++) {
                g.addEdge(u[i], v[i]);
            }

            out.println(g.toString());


//            LinkedList<Integer>[] graph = new LinkedList[n];


        }

    }
}
