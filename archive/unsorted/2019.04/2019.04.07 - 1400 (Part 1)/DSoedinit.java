package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.*;

public class DSoedinit {

    int t, n, m, k, ans, INF = Integer.MAX_VALUE;
    int[] array, arrayAns;
    int[][] M;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    int r1, c1, r2, c2;
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();

        r1 = in.nextInt() - 1;
        c1 = in.nextInt() - 1;
        r2 = in.nextInt() - 1;
        c2 = in.nextInt() - 1;

        M = new int[n][n];
        for (int i = 0; i < n; i++) {
            chars = in.nextToken().toCharArray();
            for (int j = 0; j < n; j++) {
                M[i][j] = chars[j] == '1' ? 1 : 0;
            }
        }
//        M = in.nextIntMatrix(n, n);

        used = new boolean[50 * 100];
        graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph.computeIfAbsent(i * 50 + j, (ignore) -> new HashSet<Integer>());
                if (M[i][j] == 0) {
                    if (i > 0 && M[i - 1][j] == 0) {
                        graph.get(i * 50 + j).add((i - 1) * 50 + j);
                    }
                    if (i < n - 1 && M[i + 1][j] == 0) {
                        graph.get(i * 50 + j).add((i + 1) * 50 + j);
                    }
                    if (j > 0 && M[i][j - 1] == 0) {
                        graph.get(i * 50 + j).add(i * 50 + j - 1);
                    }
                    if (j < n - 1 && M[i][j + 1] == 0) {
                        graph.get(i * 50 + j).add(i * 50 + j + 1);
                    }
                }
            }
        }

        dfs(r1 * 50 + c1);

        if (used[r2 * 50 + c2]) {
            out.printLine(0);
        } else {
            Set<IntIntPair> fistCom = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (used[i * 50 + j]) {
                        fistCom.add(IntIntPair.makePair(i, j));
                    }
                }
            }

            Arrays.fill(used, false);

            dfs(r2 * 50 + c2);

            Set<IntIntPair> secCom = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (used[i * 50 + j]) {
                        secCom.add(IntIntPair.makePair(i, j));
                    }
                }
            }

            int min  = INF;
            for (IntIntPair from : secCom) {
                for (IntIntPair to : fistCom) {
                    min = Math.min(min, (from.first - to.first)*(from.first - to.first) + (from.second - to.second)*(from.second - to.second));
                }
            }
            out.printLine(min);
        }
    }

    private void dfs(int from) {
        used[from] = true;
        for (int to : graph.get(from)) if (!used[to]) dfs(to);
    }

}