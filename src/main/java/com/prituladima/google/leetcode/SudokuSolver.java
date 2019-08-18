package com.prituladima.google.leetcode;

import java.util.*;

public class SudokuSolver {
    public static void main(String[] args) {

        char[][] sudocu = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},

                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},

                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},

        };

        char[][] sudocu1 = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},

                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},

                {'.', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '7', '.', '.', '.', '.'}
        };
        new SudokuSolver().solveSudoku(sudocu1);

    }

    /**
     * d[i][j] represent does j'th number is restricted to use or not at i'th place
     * <p>
     * as there will be 81 state with 9 different numbers.
     */
    private boolean row[][];
    private boolean col[][];
    private boolean box[][];
    private boolean solved = false;

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;

        row = new boolean[9][9];
        col = new boolean[9][9];
        box = new boolean[9][9];
        solved = false;

        fillRestrictedNumbers(board, board.length);
        solveSudoku(board, 0);

        print(board);

    }

    private void fillRestrictedNumbers(char[][] board, int length) {

        for (int r = 0; r < length; r++) {
            for (int c = 0; c < length; c++) {
                if (board[r][c] != '.') {
                    int currentNum = board[r][c] - '1';

                    //row restriction ; we can't use this number in any of the row 0..9
                    row[r][currentNum] = true;

                    //col restriction ; we can't use this number in any of the col 0..9
                    col[c][currentNum] = true;

                    //box restriction ; we can't use this number in any of the box
                    box[boxIndex(r, c)][currentNum] = true;
                }
            }
        }
    }

    int count = 0;
    private void solveSudoku(char[][] board, int n) {
        count++;
        /**
         * We have placed all numbers
         */
        if (n == 81) {
            solved = true;
            System.out.println(count);
            return;
        }

        int r = n / 9;
        int c = n % 9;
        int boxIndex = boxIndex(r, c);

        /**
         * Is this place available
         */
        if (board[r][c] == '.') {

            /**
             * Try all possible number
             */
            for (int num = 0; num < 9; num++) {

                /**
                 * Is this number allowed in this row,col and box?
                 */
                if (!row[r][num] && !col[c][num] && !box[boxIndex][num]) {
                    //Allowed, then try

                    board[r][c] = (char) (num + '1');
                    row[r][num] = col[c][num] = box[boxIndex][num] = true;

                    solveSudoku(board, n + 1);

                    /**
                     * Current value can or can not be in the answer
                     */
                    if (solved)
                        return;

                    /**
                     * Backtrack
                     */

                    board[r][c] = '.';
                    row[r][num] = col[c][num] = box[boxIndex][num] = false;
                }
            }
        } else
        /**
         * Above row and col is already been occupied
         */ {
            solveSudoku(board, n + 1);
        }


    }



    private void print(char[][] M) {
        for (char[] chars : M) System.out.println(Arrays.toString(chars));
    }


    private int boxIndex(int i, int j) {
        return (i / 3) * 3 + j / 3;
    }
}
