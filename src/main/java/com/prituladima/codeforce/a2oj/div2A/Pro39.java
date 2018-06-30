package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 6/30/18.
 */
public class Pro39 {


    private void solve() {

        int n = nextInt();
        int[] a = nextArr(n);
        int[] d = new int[n - 1];


        for (int i = 0; i < n - 1; i++) {
            d[i] = a[i + 1] - a[i];
        }


        int minP = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int maxCur = Integer.MIN_VALUE;
            maxCur = max(maxCur, d[i] + d[i + 1]);
            for (int j = 0; j < n - 1; j++) {
                maxCur = max(maxCur, d[j]);
            }
            minP = min(minP, maxCur);
        }

        System.out.println(minP);

    }

    public static void main(String[] args) {
        new Pro39().solve();
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
