package com.prituladima.geeksforgeeks.math.factorization;

/**
 * Created by prituladima on 8/5/18.
 *
 * @see "https://www.geeksforgeeks.org/deficient-number/"
 */
public class DeficientNumber {


    static int divisorSum(int n) {
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


    static boolean isDeficient(int n) {
        return divisorSum(n) < 2 * n;
    }

}
