package com.prituladima.geeksforgeeks.math.gcd;

/**
 * @see "https://www.geeksforgeeks.org/product-given-n-fractions-reduced-form/"
 */
public class ProductOfGivenNFractionsInReducedForm {

    public static void main(String[] args) {

        ProductOfGivenNFractionsInReducedForm o = new ProductOfGivenNFractionsInReducedForm();
        int[] numerator = new int[]{1, 2, 5};
        int[] denominator = new int[]{2, 1, 6};
        int[] res = o.regusedFracrion(numerator, denominator);
        System.out.printf("%d/%d\n", res[0], res[1]);

        numerator = new int[]{1, 2, 5, 9};
        denominator = new int[]{2, 1, 6, 27};
        res = o.regusedFracrion(numerator, denominator);
        System.out.printf("%d/%d\n", res[0], res[1]);

    }

    int[] regusedFracrion(int[] numerator, int[] denominator) {

        int n = numerator.length;
        int resNumerator = 1;
        int resDenominator = 1;

        for (int i = 0; i < n; i++) {

            int currentGCD = gcd(numerator[i], denominator[i]);
            resNumerator *= numerator[i] / currentGCD;
            resDenominator *= denominator[i] / currentGCD;

            currentGCD = gcd(resNumerator, resDenominator);
            resNumerator /= currentGCD;
            resDenominator /= currentGCD;
        }

        return new int[]{resNumerator, resDenominator};
    }

    int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}