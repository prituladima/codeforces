package com.prituladima.codeforce.contests.contest1072;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.LinkedList;


public class BLyubopitstvuNetPredela {
    int n, m;
    int[] a, b;
    int[][][] dp;
    LinkedList<Integer> stack = new LinkedList<>();

    public void solve(int testNumber, InputReader in, PrintWriter out) {
        n = in.nextInt();
        a = in.nextArr(n - 1);
        b = in.nextArr(n - 1);
        dp = new int[n][4][4];

        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                dp[0][j][k] = 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (a[i - 1] == (k | j) && b[i - 1] == (k & j)) {
                        dp[i][j][k] = 1;
                    }
                }
            }
        }
        for (int from = 0; from < 4; from++) {
            stack.addLast(from);
            dfs(1, from, out);
            if (!noAns) break;
            stack.removeLast();
        }
        if (noAns) {
            out.print("NO");
        }
    }

    boolean noAns = true;
    private void dfs(int numberInPath, int from, PrintWriter out) {
        if (stack.size() == n) {
            out.println("YES");
            for (Integer integer : stack) {
                out.print(integer + " ");
            }
            out.println();
            noAns = false;
            return;
        }
        for (int to = 0; to < 4; to++) {
            if (dp[numberInPath][from][to] == 1) {
                stack.addLast(to);
                dfs(numberInPath + 1, to, out);
                stack.removeLast();
            }
        }
    }

}