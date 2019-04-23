package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;
import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.util.Comparator.*;

public class MPoryadokChatov {
    int t, n, m, k, ans = 0, ansInd = -1, INF = Integer.MAX_VALUE;
    int[] a, b;
    long L, R;
    char[] s;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        t = in.nextInt();
        Set<String> lhs = new LinkedHashSet<>();
        while(t-- > 0){
            final String elem = in.nextToken();
            if (lhs.contains(elem)) {
                lhs.remove(elem);
            }
            lhs.add(elem);
        }

        ArrayDeque<String> deque = new ArrayDeque<>();
        for (String lh : lhs) {
            deque.addFirst(lh);
        }
        out.printListSeparatedLines(deque);

    }

}