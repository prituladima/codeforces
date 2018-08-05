package com.prituladima.geeksforgeeks.math.factorization;

/**
 * Created by prituladima on 8/5/18.
 * @see "https://www.geeksforgeeks.org/superperfect-number/"
 */
public class SuperperfectNumber {


    static int divisorSummatory(int n) {

        int sum = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int f = n / i;
                if (f == i) {
                    sum += f;
                } else {
                    sum += f + i;
                }
            }
        }
        return sum;
    }

    static boolean isSuperPerfect(int n) {
        return 2 * n == divisorSummatory(divisorSummatory(n));
    }


}
