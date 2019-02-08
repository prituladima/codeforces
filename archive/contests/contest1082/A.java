package com.prituladima.codeforce.contests.contest1082;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public final class A {

    private void solve() {
        int T = nextInt();

        while (T-- > 0) {

            int n = nextInt(), x = nextInt(), y = nextInt(), d = nextInt();

            soutnl(minStep(n, x, y, d, false));
        }

    }


    private int minStep(int n, int x, int y, int d, boolean second) {
        int abs = Math.abs(y - x);
        if (abs % d == 0) {
            return abs / d;
        }

        if (second) {
            return -1;
        }

        int P = minStep(n, 1, y, d, true);
        if (P == -1) {
            P = Integer.MAX_VALUE;
        } else {
            P += ((x - 1) + d - 1) / d;
        }

        int Q = minStep(n, n, y, d, true);
        if (Q == -1) {
            Q = Integer.MAX_VALUE;
        } else {
            Q += ((n - x) + d - 1) / d;
        }

        if (Math.min(P, Q) == Integer.MAX_VALUE) {
            return -1;
        }

        return Math.min(P, Q);
    }

    public static void main(String[] args) {
        new A().run();
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
        return parseInt(nextToken());
    }

    private long nextLong() {
        return parseLong(nextToken());
    }

    private double nextDouble() {
        return parseDouble(nextToken());
    }

    private int[] nextArr(int size) {
        return stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(final int n, final int m) {
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

    private void souf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void sout(Object o) {
        writer.print(o);
    }

    private void newLine() {
        writer.println();
    }

    private void soutnl(Object o) {
        sout(o);
        newLine();
    }

    private int max(int a, int b) {
        return Math.max(a, b);
    }

    private int min(int a, int b) {
        return Math.min(a, b);
    }

}