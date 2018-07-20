package com.prituladima.geeksforgeeks.math.gcd;

import static java.lang.Math.max;

class ReplaceEveryMatrixElementWithMaximumOfGCDOfRowOrColumn {


    int[][] solveNaive(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int currentGCD_J = 0;
                for (int k = 0; k < m; k++) {
                    currentGCD_J = gcd(currentGCD_J, matrix[i][k]);
                }

                int currentGCD_I = 0;
                for (int k = 0; k < n; k++) {
                    currentGCD_I = gcd(currentGCD_I, matrix[k][j]);
                }

                result[i][j] = max(currentGCD_I, currentGCD_J);

            }
        }

        return result;
    }

    int[][] solveEfficient(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;


        int[] rows = new int[n];
        int[] colomns = new int[m];


        for (int i = 0; i < n; i++) {
            int currentGCD_I = 0;
            for (int k = 0; k < m; k++) {
                currentGCD_I = gcd(currentGCD_I, matrix[i][k]);
            }
            rows[i] = currentGCD_I;
        }
        for (int j = 0; j < m; j++) {
            int currentGCD_J = 0;
            for (int k = 0; k < n; k++) {
                currentGCD_J = gcd(currentGCD_J, matrix[k][j]);
            }
            colomns[j] = currentGCD_J;
        }

        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                result[i][j] = max(rows[i], colomns[j]);

            }
        }

        return result;
    }


    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}