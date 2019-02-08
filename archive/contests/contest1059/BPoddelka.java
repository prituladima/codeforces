package com.prituladima.codeforce.contests.contest1059;

import com.prituladima.codeforce.InputReader;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static com.prituladima.codeforce.GeekDP.Pair;


public class BPoddelka {
    final long MODULO = (long) 1e9 + 9;
    final int INF = (int) 1e9;
    int n, m;
    int[] a;
    long L, R;
    int ans;
    int min = INF, max = -INF;
    String s;
    private List<Pair> pairs = new ArrayList<>();
    private String YES = "YES", NO = "NO";
    private char AA = '#';
    char[][] mtx;

    public void solve(int testNumber, InputReader in, PrintWriter out) {

        n = in.nextInt();
        m = in.nextInt();

        mtx = in.nextCharMatrix(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mtx[i][j] != AA) continue;
                boolean isCorrect =
                        (j - 1 >= 0 && i - 1 >= 0 && isCorrect(j - 1, i - 1)) ||
                                (j + 1 < m && i + 1 < n && isCorrect(j + 1, i + 1)) ||
                                (i + 1 < n && j - 1 >= 0 && isCorrect(j - 1, i + 1)) ||
                                (j + 1 < m && i - 1 >= 0 && isCorrect(j + 1, i - 1)) ||

                                (i + 1 < n && isCorrect(j, i + 1)) ||
                                (i - 1 >= 0 && isCorrect(j, i - 1)) ||
                                (j - 1 >= 0 && isCorrect(j - 1, i)) ||
                                (j + 1 < m && isCorrect(j + 1, i));

                if (!isCorrect) {
                    out.print(NO);
                    return;
                }

            }
        }

//        out.println(Arrays.toString(sumM));
//        out.println(Arrays.toString(sumN));


        out.println(YES);

    }

    private boolean isCorrect(int x, int y) {
        if (x - 1 >= 0 && y - 1 >= 0 && x + 1 < m && y + 1 < n) {
            return
                    mtx[y - 1][x] == AA &&
                            mtx[y + 1][x] == AA &&
                            mtx[y][x + 1] == AA &&
                            mtx[y][x - 1] == AA &&

                            mtx[y + 1][x - 1] == AA &&
                            mtx[y - 1][x + 1] == AA &&
                            mtx[y - 1][x - 1] == AA &&
                            mtx[y + 1][x + 1] == AA;
        }
        return false;

    }

}