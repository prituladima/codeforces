package com.prituladima.codeforce.contests.contest1100;

import com.prituladima.codeforce.InputReader;
import java.io.PrintWriter;

public class DDashaIShahmati {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int[][] chess = new int[1000][1000];
        int[][] pieces = new int[668][2];

        for(int i = 0; i < 999; i++) {
            for(int j = 0; j < 999; j++) {
                chess[i][j] = -1;
            }
        }

        for(int i = 0; i < 667; i++) {

            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;

            chess[x][y]  = i;
            pieces[i][0] = x;
            pieces[i][1] = y;

        }

        while(true) {

            int x = pieces[0][0];
            int y = pieces[0][1];

            move:
            for(int i = x - 1; i <= x + 1; i++) {
                for(int j = y - 1; j <= y + 1; j++) {

                    if(i < 0 || i >= 999 || j < 0 || j >= 999) continue;
                    if(i == j) continue;
                    if(chess[i][j] >= 0) continue;

                    pieces[0][0] = i;
                    pieces[0][1] = j;
                    chess[i][j] = 0;
                    out.println((i + 1) + " " + (j + 1));
                    out.flush();
                    break move;
                }
            }

            int k = in.nextInt();
            x = in.nextInt() - 1;
            y = in.nextInt() - 1;

            if(k == -1 && x == -2 && y == -2) return;

            if(k == 0 && x == -1 && y == -1) return;

            chess[pieces[k][0]][pieces[k][1]] = -1;
            chess[x][y] = k;
            pieces[k][0] = x;
            pieces[k][1] = y;
        }




    }
}
