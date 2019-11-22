package com.prituladima.codeforce.contest;

import java.io.*;
import java.util.NoSuchElementException;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

//todo To be tested
public class Main223538cb {

    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final int INF = (int) 1e7 + 7;

    private static final String yes = "YES", no = "NO";
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private static final boolean MULTI_TEST = false;

    private void solve() {
        int n = nextInt();
        int[][] a = nextIntMatrix(n, n);
        int[][] prefSum = new int[n][n];
        for (int i = 0; i < n; i++) {
            prefSum[i][0] = a[i][0];
            for (int j = 1; j < n; j++) {
                prefSum[i][j] = a[i][j] + prefSum[i][j - 1];
            }
        }

        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                prefSum[i][j] += prefSum[i - 1][j];
            }
        }

        debugMatrix(prefSum);
        int ans = Integer.MIN_VALUE;

        for (int i1 = 0; i1 < n; i1++) {
            for (int j1 = 0; j1 < n; j1++) {

                for (int i2 = i1; i2 < n; i2++) {
                    for (int j2 = j1; j2 < n; j2++) {

                        int localAns = prefSum[i2][j2];

                        if (isValidIndex(j1 - 1, n)) {
                            localAns -= prefSum[i2][j1 - 1];
                        }

                        if (isValidIndex(i1 - 1, n)) {
                            localAns -= prefSum[i1 - 1][j2];
                        }

                        if (isValidIndex(i1 - 1, n) && isValidIndex(j1 - 1, n)) {
                            localAns += prefSum[i1 - 1][j1 - 1];
                        }

                        ans = Math.max(ans, localAns);

                    }
                }


            }
        }


        println(ans);
    }

    private boolean isValidIndex(int ind, int n) {
        return 0 <= ind && ind < n;
    }

    private void debugMatrix(int[][] matrix) {
        if (ONLINE_JUDGE) return;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                print(matrix[i][j]);
                print(' ');
            }
            println();
        }
    }


    private void solveAll() {
        int t = MULTI_TEST ? nextInt() : 1;
        while (t-- > 0) {
            solve();
        }
    }

    public static void main(String[] args) {
        new Main223538cb().run();
    }

    private PrintWriter writer;
    private StreamTokenizer tokenizer;
    private StringBuilder stringBuilder = new StringBuilder();

    private void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            this.writer = writer;
            this.tokenizer = new StreamTokenizer(reader);
            solveAll();
            this.writer.print(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Base types: Strings, int, long, double
     */
    private String nextToken() {
        try {
            tokenizer.nextToken();
            return tokenizer.sval;
        } catch (IOException e) {
            throw new NoSuchElementException();
        }
    }

    private int nextInt() {
        nextToken();
        return (int) tokenizer.nval;
    }

    private long nextLong() {
        nextToken();
        return (long) tokenizer.nval;
    }

    private double nextDouble() {
        nextToken();
        return tokenizer.nval;
    }


    /**
     * Primitives 1D arrays: char, int, long, double
     */
    private char[] nextCharArray() {
        return nextToken().toCharArray();
    }

    private int[] nextIntArray(int size) {
        return stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextLongArray(int size) {
        return stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextDoubleArray(int size) {
        return stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private String[] nextStringArray(int size) {
        return range(0, size).mapToObj(i -> nextToken()).toArray(String[]::new);
    }


    /**
     * Primitives 2D arrays: char, int, long, double
     */
    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextIntArray(m)).toArray(int[][]::new);
    }

    private long[][] nextLongMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextLongArray(m)).toArray(long[][]::new);
    }

    private double[][] nextDoubleMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextDoubleArray(m)).toArray(double[][]::new);
    }

    /**
     * Output
     */
    private void printf(String format, Object... args) {
        stringBuilder.append(String.format(format, args));
        if (stringBuilder.length() > 1000) {
            flush();
        }
    }

    private void print(Object o) {
        stringBuilder.append(o);
        if (stringBuilder.length() > 1000) {
            flush();
        }
    }

    private void println() {
        stringBuilder.append('\n');
        if (stringBuilder.length() > 1000) {
            flush();
        }
    }

    private void println(Object o) {
        stringBuilder.append(o).append('\n');
        if (stringBuilder.length() > 1000) {
            flush();
        }
    }

    private void flush() {
        writer.print(stringBuilder);
        writer.flush();
        stringBuilder = new StringBuilder();
    }


}
