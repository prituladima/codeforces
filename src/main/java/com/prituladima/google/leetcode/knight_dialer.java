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
            if (N == 1) return 10;
            int[] last = new int[10];
            Arrays.fill(last, 1);
            last[5] = 0;
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
    }
}
