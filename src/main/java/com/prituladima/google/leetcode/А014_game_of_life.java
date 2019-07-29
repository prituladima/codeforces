package com.prituladima.google.leetcode;

public class А014_game_of_life {
    // 1 0
    // live -> die 2
    // die -> live 3
    private int[][] gos= {
            {-1, -1},
            {-1, 0},
            {0, -1},
            {1, 1},

            {-1, 1},
            {1, -1},
            {1, 0},
            {0, 1}
    };

    public void gameOfLife(int[][] board) {

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j  < board[i].length; j++){
                int count = count(board, i, j)        ;
                if(aliveF(board, i, j) && count < 2) board[i][j] = 2;
                else if(aliveF(board, i, j) && (count == 2 || count == 3)) board[i][j] = 1;
                else if(aliveF(board, i, j) && count > 3)  board[i][j] = 2;
                else if(!aliveF(board, i, j) && count == 3) board[i][j] = 3;
            }
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 0 || board[i][j] == 2) board[i][j] = 0;
                else board[i][j] = 1;
            }
        }
    }

    private int count(int[][] board, int i, int j){
        int count = 0 ;
        for(int[] go: gos)
            count += (in(board, i + go[0], j+ go[1]) && aliveF(board, i + go[0], j+ go[1])) ? 1 : 0;

        return count;
    }

    private boolean aliveF(int[][] board, int i, int j){
        return board[i][j] == 1 || board[i][j] == 2;
    }

    private boolean in(int[][] board, int i, int j){
        return i >=  0 &&  i < board.length &&  j >=  0 &&  j < board[i].length;
    }
}
