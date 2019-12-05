package com.prituladima.yaal.matrix;

public class MatrixUtil {

    private int[][] calculatePrefixSumCol(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] prefSumCol = new int[n][m];
        for (int row = 0; row < n; row++) {
            prefSumCol[row][0] = a[row][0];
            for (int col = 1; col < a[row].length; col++) {
                prefSumCol[row][col] = prefSumCol[row][col - 1];
                prefSumCol[row][col] += a[row][col];
            }
        }
        return prefSumCol;
    }

    private int[][] calculatePrefixSumRow(int[][] a) {
        int n = a.length;
        int m = a[0].length;
        int[][] prefSumRow = new int[n][m];
        for (int col = 0; col < n; col++) {
            prefSumRow[0][col] = a[0][col];
            for (int row = 1; row < n; row++) {
                prefSumRow[row][col] = prefSumRow[row - 1][col];
                prefSumRow[row][col] += a[row][col];
            }
        }
        return prefSumRow;
    }


}
