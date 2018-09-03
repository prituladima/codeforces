package com.prituladima.codeforce.virtual.contest1029;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public final class C {


    private void solve() {

        int n = nextInt();
        int[] LEFT_RANGE = new int[n];
        int[] RIGHT_RANGE = new int[n];

        for (int i = 0; i < n; i++) {
            int L = nextInt(), R = nextInt();
            LEFT_RANGE[i] = L;
            RIGHT_RANGE[i] = R;
        }

        int[] SEG_PREFIX_L = new int[n + 1];
        int[] SEG_PREFIX_R = new int[n + 1];
        int[] SEG_SUFIX_L = new int[n + 1];
        int[] SEG_SUFIX_R = new int[n + 1];

        SEG_PREFIX_L[0] = SEG_SUFIX_L[n] = 0;
        SEG_PREFIX_R[0] = SEG_SUFIX_R[n] = Integer.MAX_VALUE;


        for (int i = 0; i < n; i++) {
            SEG_PREFIX_L[i + 1] = Integer.max(LEFT_RANGE[i], SEG_PREFIX_L[i]);
            SEG_PREFIX_R[i + 1] = Integer.min(RIGHT_RANGE[i], SEG_PREFIX_R[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            SEG_SUFIX_L[i] = Integer.max(LEFT_RANGE[i], SEG_SUFIX_L[i + 1]);
            SEG_SUFIX_R[i] = Integer.min(RIGHT_RANGE[i], SEG_SUFIX_R[i + 1]);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            ans = max(ans,
                    min(SEG_SUFIX_R[i + 1], SEG_PREFIX_R[i]) - max(SEG_SUFIX_L[i + 1], SEG_PREFIX_L[i])
            );

        }


        sout(ans);
    }

    public static void main(String[] args) {
        new C().run();
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