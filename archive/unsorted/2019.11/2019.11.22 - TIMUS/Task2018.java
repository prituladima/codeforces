package com.prituladima.codeforce.contest;

import java.io.*;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

//todo To be tested
public class Main223538cb {

    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final int INF = (int) 1e7 + 7;
    private static final int MAXN = (int) 5e4 + 1;

    private static final String yes = "YES", no = "NO";
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private static final boolean MULTI_TEST = false;

    private void solve() {

        int n = nextInt();
        int a = nextInt();
        int b = nextInt();


        int[][] ans = new int[2][301];
        ans[0][1] = 1;
        ans[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            int[][] cur = new int[2][301];
            //Calculate new answer
            for (int len = 1; len <= b; len++) {
                cur[0][1] += ans[1][len];
                cur[0][1] %= MODULO;
            }
            for (int len = 2; len <= a; len++) {
                cur[0][len] = ans[0][len - 1];
            }

            for (int len = 1; len <= a; len++) {
                cur[1][1] += ans[0][len];
                cur[1][1] %= MODULO;
            }
            for (int len = 2; len <= b; len++) {
                cur[1][len] = ans[1][len - 1];
            }

            //Update prev ans
            for (int g1 = 0; g1 < 2; g1++) {
                for (int g2 = 0; g2 < 301; g2++) {
                    ans[g1][g2] = cur[g1][g2];
                }
            }

        }

        int finalAns = 0;
        for (int i = 1; i <= a; i++) {
            finalAns += ans[0][i];
            finalAns %= MODULO;
        }

        for (int i = 1; i <= b; i++) {
            finalAns += ans[1][i];
            finalAns %= MODULO;
        }

        print(finalAns);
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

    /**
     * Utils
     */

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

    public static double max(double req, double... opt) {
        if (opt.length == 0) return req;
        double max = req;
        for (double value : opt) max = Math.max(max, value);
        return max;
    }

    public static double min(double req, double... opt) {
        if (opt.length == 0) return req;
        double min = req;
        for (double value : opt) min = Math.min(min, value);
        return min;
    }

    public static double sum(double... a) {
        return Arrays.stream(a).sum();
    }

    public static int max(int req, int... opt) {
        if (opt.length == 0) return req;
        int max = req;
        for (int value : opt) max = Math.max(max, value);
        return max;
    }

    public static int min(int req, int... opt) {
        if (opt.length == 0) return req;
        int min = req;
        for (int value : opt) min = Math.min(min, value);
        return min;
    }

    public static int sum(int... a) {
        return Arrays.stream(a).sum();
    }

    public static long max(long req, long... opt) {
        if (opt.length == 0) return req;
        long max = req;
        for (long value : opt) max = Math.max(max, value);
        return max;
    }

    public static long min(long req, long... opt) {
        if (opt.length == 0) return req;
        long min = req;
        for (long value : opt) min = Math.min(min, value);
        return min;
    }

    public static long sum(long... a) {
        return Arrays.stream(a).sum();
    }


}
