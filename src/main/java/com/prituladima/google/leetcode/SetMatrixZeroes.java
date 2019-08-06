package com.prituladima.google.leetcode;

import java.util.Map;

public class SetMatrixZeroes {
    class Solution {
        public void setZeroes(int[][] matrix) {
            if (matrix.length == 0) return;

            int rows = matrix.length;
            int cols = matrix[0].length;
            boolean fillFirstRow = false;

            for (int i = 0; i < cols; i++) {
                if (matrix[0][i] == 0) {
                    fillFirstRow = true;
                }
            }

            for (int i = 1; i < rows; i++) {
                boolean changeCurrent = false;
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        changeCurrent = true;
                    }
                }
                if (changeCurrent) {
                    for (int j = 0; j < cols; j++)
                        matrix[i][j] = 0;
                }
            }

            for (int i = 0; i < cols; i++) {
                if (matrix[0][i] == 0)
                    for (int j = 1; j < rows; j++) {
                        matrix[j][i] = 0;
                    }
            }

            if (fillFirstRow) {
                for (int i = 0; i < cols; i++)
                    matrix[0][i] = 0;

            }


        }
    }


}
