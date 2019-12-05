package com.prituladima.timus;

import com.prituladima.yaal.graph.Graph;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import static com.prituladima.yaal.graph.GraphAlgorithms.topologicalSort;

public class Task1022 {
    public void solve(int testNumber, InputReader in, OutputWriter out) {

        int n = in.nextInt();
        Graph graph = new Graph(n);

        for (int i = 1; i <= n; i++) {
            int child;
            while ((child = in.nextInt()) != 0){
                graph.addSimpleEdge(i - 1, child - 1);
            }
        }

        int[] sorted = topologicalSort(graph);
        for(int vertex : sorted){
            out.print(vertex + 1);
            out.print(' ');
        }


    }
}
