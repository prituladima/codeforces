package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class A1AddOnATree {

    private String yes = "YES", no = "NO";

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        Map<Integer, Set<Integer>> graph = in.readGraph(in.nextInt() - 1);


        for (int v : graph.keySet()) {
                if(graph.get(v).size() == 2) {out.println(no); return;}
        }

        out.println(yes);

    }
}