package com.prituladima.geeksforgeeks.math.factorization;

/**
 * Created by prituladima on 8/5/18.
 * @see "https://www.geeksforgeeks.org/aliquot-sum/"
 */
public class AliquotSum {

    static int aliquotSum(int n) {
        int sum = 1;
        for (int i = 2; i * i <= n; i++) {
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

}