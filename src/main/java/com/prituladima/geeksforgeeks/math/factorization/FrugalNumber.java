package com.prituladima.geeksforgeeks.math.factorization;

import java.util.HashMap;
import java.util.Map;

/**
 * @see "https://www.geeksforgeeks.org/frugal-number/"
 */
public class FrugalNumber {


    static boolean isFrugalNumber(long n) {
        return digits(n) > digitsInFactorizationWithExponental(n) && n != 1;
    }


    static long digitsInFactorizationWithExponental(long n) {
        Map<Long, Long> expCounter = new HashMap<>();
        while (n % 2 == 0) {
            expCounter.merge(2L, 1L, (x, y) -> x + y);
            n /= 2;
        }

        long f = 3;
        while (f * f <= n) {
            if (n % f == 0) {
                expCounter.merge(f, 1L, (x, y) -> x + y);
                n /= f;
            } else {
                f += 2;
            }
        }

        if (n != 1) expCounter.merge(n, 1L, (x, y) -> x + y);


        long sum = 0;
        for (long cur : expCounter.keySet()) {
            Long val = expCounter.get(cur);
            sum += digits(cur);
            sum += val != null && val > 1 ? digits(val) : 0;
        }

        return sum;
    }


    static long digits(long n) {
        long amount = 0;
        while (n != 0) {
            amount++;
            n /= 10;
        }
        return amount;
    }

}