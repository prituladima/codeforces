package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 7/3/18.
 */
public class Pro52 {

    private void solve() {

        int n = nextInt();
        int toggle = 0;
        int eo = 0;

        int LS = 0;
        int RS = 0;
        for (int i = 0; i < n; i++) {
            int L = nextInt();
            int R = nextInt();
            toggle += L % 2 != R % 2 ? 1 : 0;
            LS += L;
            RS += R;
        }

        if (LS % 2 == 0 && RS % 2 == 0) {
            System.out.println(0);
        } else if (LS % 2 != 0 && RS % 2 != 0 && toggle >= 1) {
            System.out.println(1);
        } else {
            System.out.println(-1);
        }

    }

    public static void main(String[] args) {
        new Pro52().solve();
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

    int[][] nextIntMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    double[][] nextDoubleMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(double[][]::new);
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
