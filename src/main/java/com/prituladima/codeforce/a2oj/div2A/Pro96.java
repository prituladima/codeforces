package com.prituladima.codeforce.a2oj.div2A;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.max;
import static java.lang.Integer.min;
import static java.lang.Math.abs;
import static java.util.stream.IntStream.range;


public class Pro96 {

    int n, m, i, j, a, b;
    int INF = Integer.MAX_VALUE;

    private void solve() {

        n = nextInt();
        m = nextInt();
        i = nextInt();
        j = nextInt();
        a = nextInt();
        b = nextInt();
        int ans = INF;

        ans = min(check(1, m), check(n, 1));
        ans = min(ans, check(n, m));
        ans = min(ans, check(1, 1));


        sout(ans == Integer.MAX_VALUE ? "Poor Inna and pony!" : ans);

    }


    int check(int x, int y) {
        if (x == i && y == j) {
            return 0;
        }
        if (i - a < 1 && i + a > n) return INF;
        if (j - b < 1 && j + b > m) return INF;
        if (abs(x - i) % a != 0) return INF;
        if (abs(y - j) % b != 0) return INF;

        int cost = 0;
        cost = max(abs(x - i) / a, abs(y - j) / b);
        int tmp = abs(x - i) / a + abs(y - j) / b;
        if ((tmp & 1) != 0) return INF;
        return cost;
    }

    public static void main(String[] args) {
        new Pro96().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
            writer = new PrintWriter(System.out);
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
    }

    private int[] nextArr(int size) {
        return Arrays.stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return Arrays.stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return Arrays.stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    private double[][] nextDoubleMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(double[][]::new);
    }

    private String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

    private void soutn() {
        writer.println();
    }

    private void soutn(Object o) {
        writer.println(o);
    }

    private void sout(Object o) {
        writer.print(o);
    }

    private void souf(String format, Object... args) {
        writer.printf(format, args);
    }

    private <Param> void sout(Param[] arr) {
        writer.println(Arrays.toString(arr));
    }

}
