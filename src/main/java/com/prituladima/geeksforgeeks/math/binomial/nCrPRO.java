package com.prituladima.geeksforgeeks.math.binomial;

/**
 * @see "https://www.geeksforgeeks.org/mathematical-algorithms/"
 */
public class nCrPRO {

    /**
     * @see "https://www.geeksforgeeks.org/modulo-1097-1000000007/"
     */
    final int modulo = 1000000007;

    /**
     * @see "https://www.geeksforgeeks.org/probability-three-randomly-chosen-numbers-ap/"
     */
    double probability_three_randomly_chosen_numbers_ap(int n) {
        return 3.0 * n / (4.0 * n * n - 1);
    }

}