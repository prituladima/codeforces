package com.prituladima.geeksforgeeks.math.factorization;

import static java.util.Arrays.fill;

/**
 * Created by prituladima on 8/4/18.
 */
public class BlumInteger {


    static boolean isBlumInteger(int n) {
        boolean[] prime = prime(n);

        for (int i = 2; i <= n; i++) {

            if (prime[i]) {

                if (n % i == 0 && (i - 3) % 4 == 0) {
                    int q = n / i;
                    return prime[q] && (q - 3) % 4 == 0;
                }

            }

        }

        return false;
    }


    static boolean[] prime(int n) {
        boolean[] prime = new boolean[n + 1];
        fill(prime, true);
        prime[1] = prime[0] = false;

        for (int i = 2; i <= n; i++)
            if (prime[i])
                if (i * 1L * i <= n)
                    for (int j = i * i; j <= n; j += i)
                        prime[j] = false;


        return prime;
    }

}
