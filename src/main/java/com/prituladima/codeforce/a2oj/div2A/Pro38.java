package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

import static java.lang.Math.abs;
import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 6/30/18.
 */
public class Pro38 {


    private void solve() {

        int a = nextInt(), b = nextInt();

        int[] ans = new int[3];
        for (int i = 1; i <= 6; i++) {
            if (abs(i - a) < abs(i - b)) {
                ans[0]++;
            } else if (abs(i - a) > abs(i - b)) {
                ans[2]++;
            } else {
                ans[1]++;
            }
        }

        System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);


    }

    public static void main(String[] args) {
        new Pro38().solve();
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
