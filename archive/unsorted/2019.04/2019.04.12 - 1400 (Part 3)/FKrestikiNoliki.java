package com.prituladima.codeforce;

import com.prituladima.yaal.generated.collections.pair.IntIntPair;
import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FKrestikiNoliki {
    int t, n, m, k, ans = 0, INF = Integer.MAX_VALUE;
    int[] a, arrayAns;
    long L, R;
    String s;
    char[] chars;
    IntIntPair[] pairs, pairsAns;
    String YES = "Yes", NO = "No";
    boolean[] used;
    Map<Integer, Set<Integer>> graph;

    public void solve(int testNumber, InputReader in, OutputWriter out) {

        char[][] M = in.nextCharMatrix(9, 9);
        int x = in.nextInt() - 1, y = in.nextInt() - 1;

//        Set<Integer> XX = new HashSet<>();
//        Set<Integer> YY = new HashSet<>();
//        Set<Integer> YY1 = new HashSet<>();
//        Set<Integer> YY2 = new HashSet<>();
//        Set<Integer> YY3 = new HashSet<>();
//        Set<Integer> YY4 = new HashSet<>();
//        Set<Integer> YY5 = new HashSet<>();
//        Set<Integer> YY6 = new HashSet<>();


        int LX, LY, RX, RY;
        if (x % 3 == 0) {
            LX = 0;
            RX = 2;
        } else if (x % 3 == 1) {
            LX = 3;
            RX = 5;
        } else {
            LX = 6;
            RX = 8;
        }

        if (y % 3 == 0) {
            LY = 0;
            RY = 2;
        } else if (y % 3 == 1) {
            LY = 3;
            RY = 5;
        } else {
            LY = 6;
            RY = 8;
        }


        boolean hasPlace = false;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (LX <= i && i <= RX && LY <= j && j <= RY) {
                    if (M[i][j] == '.') hasPlace = true;
                }
            }
        }

        if (!hasPlace) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (M[i][j] == '.') out.print("!");
                    else out.print(M[i][j]);
                    if (j % 3 == 2) out.printSpace();
                }
                out.printLine();
                if (i % 3 == 2) out.printLine();
            }
        } else {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (M[i][j] == '.' && LX <= i && i <= RX && LY <= j && j <= RY) out.print("!");
                    else out.print(M[i][j]);
                    if (j % 3 == 2) out.printSpace();
                }
                out.printLine();
                if (i % 3 == 2) out.printLine();
            }
        }

//        for(char[] C : M)
//        out.printLine(C);

    }

}