package com.prituladima.google.leetcode;

public class RotateImage {
    public void rotate(int[][] matrix) {
        //rotate over main diagonal
        transpMatrix(matrix);
        //rotate over colomn
        revCol(matrix);
    }

    void transpMatrix(int[][] m) {
        int n = m.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int b = m[i][j];
                m[i][j] = m[j][i];
                m[j][i] = b;
            }
        }
    }

    void revCol(int[][] m) {
        int n = m.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0, k = n - 1; j < k; j++, k--) {
                int b = m[i][j];
                m[i][j] = m[i][k];
                m[i][k] = b;
            }
        }
    }
}
