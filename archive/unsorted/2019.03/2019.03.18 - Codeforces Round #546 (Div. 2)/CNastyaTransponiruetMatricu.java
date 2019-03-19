package com.prituladima.codeforce;

import com.prituladima.yaal.io.InputReader;
import com.prituladima.yaal.io.OutputWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CNastyaTransponiruetMatricu {
    int n, m;
    int[][] A, B;
    static int R = 3;
    static int C = 3;

    public void solve(int testNumber, InputReader in, OutputWriter out) {
        n = in.nextInt();
        m = in.nextInt();
        A = in.nextIntMatrix(n, m);
        B = in.nextIntMatrix(n, m);

        List<Map<Integer, Integer>> trick1 = new ArrayList<>();
        List<Map<Integer, Integer>> trick2 = new ArrayList<>();

        for (int i = 0; i < 1050; i++) {
            trick1.add(new HashMap<>());
            trick2.add(new HashMap<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                trick1.get(i + j).merge(A[i][j], 1, Integer::sum);
                trick2.get(i + j).merge(B[i][j], 1, Integer::sum);

            }
        }

        for (int i = 0; i < 1050; i++) {
            for (Integer j : trick1.get(i).keySet()) {
                if (trick2.get(i).get(j) == null || !trick2.get(i).get(j).equals(trick1.get(i).get(j))) {
                    out.printLine("NO");
                    return;
                }
            }
            for (Integer j : trick2.get(i).keySet()) {
                if (trick1.get(i).get(j) == null || !trick1.get(i).get(j).equals(trick2.get(i).get(j))) {
                    out.printLine("NO");
                    return;
                }
            }
        }

        out.printLine("YES");

    }

}