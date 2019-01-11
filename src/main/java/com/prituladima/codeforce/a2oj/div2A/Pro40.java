package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 6/30/18.
 */
public class Pro40 {


    private void solve() {
        int n = nextInt();

        int[] a = nextArr(n);

        int[] ans = new int[3];
        String[] res = {"chest", "biceps", "back"};

        for (int i = 0; i < n; i++) {
            ans[i % 3] += a[i];
        }

        if (ans[0] == max(max(ans[0], ans[1]), ans[2])) {
            System.out.println(res[0]);
        }


        if (ans[1] == max(max(ans[0], ans[1]), ans[2])) {
            System.out.println(res[1]);
        }


        if (ans[2] == max(max(ans[0], ans[1]), ans[2])) {
            System.out.println(res[2]);
        }


    }

    public static void main(String[] args) {
        new Pro40().solve();
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
