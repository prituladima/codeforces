package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 6/30/18.
 */
public class Pro48 {

    private void solve() {
        int n = nextInt();

        int[] abc = nextArr(3);
        Arrays.sort(abc);
        int a = abc[0], b = abc[1], c = abc[2];


        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= n / a; i++) {
            for (int j = 0; j <= (n-i*a)/b; j++) {
                int S = n - i * a - j * b;
                if (S % c == 0) {
                    ans = max(ans, i + j + S / c);
                }
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        new Pro48().solve();
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