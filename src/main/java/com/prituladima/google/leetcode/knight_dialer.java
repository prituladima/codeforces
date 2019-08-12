package com.prituladima.google.leetcode;

import java.util.Arrays;

public class knight_dialer {
    // TODO: 11.08.2019 https://medium.com/@alexgolec/google-interview-questions-deconstructed-the-knights-dialer-impossibly-fast-edition-c288da1685b8
    class Solution {
        int[][] steps = {
                {4, 6},
                {6, 8},
                {7, 9},
                {4, 8},
                {3, 9, 0},
                {},
                {1, 7, 0},
                {2, 6},
                {1, 3},
                {2, 4}
        };
        int M = (int) 1e9 + 7;

        public int knightDialer(int N) {
            int[] last = new int[10];
            Arrays.fill(last, 1);
            for (int i = 2; i <= N; i++) {
                int[] cur = new int[10];
                for (int to = 0; to < 10; to++) {
                    for (int from : steps[to]) {
                        cur[to] += last[from];
                        if (cur[to] >= M) cur[to] -= M;
                    }
                }
                last = cur;
            }

            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += last[i];
                if (sum >= M) sum -= M;
            }
            return sum;
        }

        public int knightDialer2(int N) {
            int[][] ans = new int[2][10];
            Arrays.fill(ans[0], 1);
            int k = 0;
            for (int i = 2; i <= N; i++) {
                Arrays.fill(ans[~k & 1], 0);
                for (int to = 0; to < 10; to++) {
                    for (int from : steps[to]) {
                        ans[~k & 1][to] += ans[k & 1][from];
                        if (ans[~k & 1][to] >= M) ans[~k & 1][to] -= M;
                    }
                }
                k = ~k;
            }

            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += ans[k & 1][i];
                if (sum >= M) sum -= M;
            }
            return sum;
        }
    }
}
