package com.prituladima.geeksforgeeks.geometric_algorithms.lines;

import java.util.*;

/**
 * Created by prituladima on 7/13/18.
 */
public class EquationOfLine {

    int[] getEquationOfLine(int p[], int q[]) {
        if (Arrays.equals(p, q)) return null;

        int A = p[1] - q[1];
        int B = q[0] - p[0];
        int C = -1*(A * p[0] + B * p[1]);

        int gcd = gcd(A, B);
        gcd = gcd(gcd, C);

        return new int[]{A/gcd, B/gcd, C/gcd};
    }

    int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

}
