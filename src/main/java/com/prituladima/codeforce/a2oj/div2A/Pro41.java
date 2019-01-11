package com.prituladima.codeforce.a2oj.div2A;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 6/30/18.
 */
public class Pro41 {


    private void solve() {
        long l = nextLong(), r = nextLong();
        for (long i = l; i <= r; i++) {
            for (long j = l; j <= r; j++) {
                for (long k = l; k <= r; k++) {
                    if (i < j && j < k && gcd(i, j) == 1 && gcd(j, k) == 1 && gcd(i, k) > 1) {
                        System.out.printf("%d %d %d", i, j, k);
                        return;
                    }
                }
            }
        }

        System.out.println(-1);

    }

    long gcd(long a, long b) {
        return b != 0 ? gcd(b, a % b) : a;
    }

    public static void main(String[] args) {
        new Pro41().solve();
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer;
    private PrintWriter writer = new PrintWriter(System.out);

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
