package com.prituladima.geeksforgeeks.math.factorization;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * Created by prituladima on 8/5/18.
 * @see "https://www.geeksforgeeks.org/betrothed-numbers/"
 */
public class BetrothedNumber {

    static int divisorSum(int n) {
        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int f = n / i;
                if (f == i) {
                    sum += i;
                } else {
                    sum += i + f;
                }
            }
        }

        return sum;
    }

    static int aliquotSum(int n) {
        return divisorSum(n) - n;
    }

    static int[][] getBetrothedNumbers(int n) {
        Map<Integer, int[]> ans = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (aliquotSum(i) == j + 1 && aliquotSum(j) == i + 1) {
                    int[] next = new int[]{min(i, j), max(i, j)};
                    ans.put(Arrays.hashCode(next), next);
                }
            }
        }
        int[][] res = new int[ans.size()][];
        int index = 0;
        for (int cur : ans.keySet()) {
            res[index++] = ans.get(cur);
        }
        return res;
    }


}
