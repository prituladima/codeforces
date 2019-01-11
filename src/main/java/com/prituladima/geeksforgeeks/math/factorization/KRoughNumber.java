package com.prituladima.geeksforgeeks.math.factorization;

import static java.lang.Math.min;

/**
 * Created by prituladima on 8/5/18.
 *
 * @see "https://www.geeksforgeeks.org/k-rough-number-k-jagged-number/"
 */
public class KRoughNumber {

    static int minPrimeFactor(int n) {

        int ans = Integer.MAX_VALUE;

        while (n % 2 == 0) {
            n /= 2;
        }

        int i = 3;
        while (i * i <= n) {
            if (n % i == 0) {
                ans = min(ans, i);
                n /= i;
            } else {
                i += 2;
            }

        }

        if (n != 1) ans = min(n, ans);


        return ans;
    }

    static boolean isKRoughNumber(int n, int k) {
        return k <= minPrimeFactor(n);
    }

}
