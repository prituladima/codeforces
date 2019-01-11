package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 6/29/18.
 */
public class Pro33 {

    private void solve() {

        int n = nextInt();
        char[][] mtx = nextCharMatrix(n);


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int ne = 0;

                if (i - 1 >= 0 && mtx[i - 1][j] == 'o') ne++;
                if (i + 1 < n && mtx[i + 1][j] == 'o') ne++;
                if (j - 1 >= 0 && mtx[i][j - 1] == 'o') ne++;
                if (j + 1 < n && mtx[i][j + 1] == 'o') ne++;

                if (ne % 2 != 0) {
                    System.out.println("NO");
                    return;
                }


            }
        }

        System.out.println("YES");

    }

    public static void main(String[] args) {
        new Pro33().solve();
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer;

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }


    int[] nextArr(int size) {
        return Arrays.stream(new int[size]).map(c -> nextInt()).toArray();
    }

    long[] nextArrL(int size) {
        return Arrays.stream(new long[size]).map(c -> nextLong()).toArray();
    }

    double[] nextArrD(int size) {
        return Arrays.stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }


    String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }
}
