package com.prituladima.geeksforgeeks.math.factorization;

import java.util.*;

import static java.lang.Math.min;

/**
 * Created by prituladima on 8/5/18.
 * @see "https://www.geeksforgeeks.org/powerful-number/"
 */
public class PowerfulNumber {


    static int getMinExpOfPrimeDivisor(int n) {

        HashMap<Integer, Integer> counter = new HashMap<>();

        while (n % 2 == 0) {
            counter.merge(2, 1, (x, y) -> x + y);
            n >>= 1;
        }

        int f = 3;
        while (f * f <= n) {
            if (n % f == 0) {
                counter.merge(f, 1, (x, y) -> x + y);
                n /= f;
            } else {
                f += 2;
            }
        }

        if (n != 1) {
            counter.merge(n, 1, (x, y) -> x + y);
        }


        int ans = Integer.MAX_VALUE;
        for (int key : counter.keySet()) {
            int exp = counter.get(key);
            if (exp < 2) {
                ans = min(ans, exp);
            }
        }

        return ans;
    }


    static boolean isPowerfulNumber(int n) {
        return getMinExpOfPrimeDivisor(n) >= 2;
    }

}
