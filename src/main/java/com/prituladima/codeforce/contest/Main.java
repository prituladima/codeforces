package com.prituladima.codeforce.contest;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

//todo To be tested
public class Main {

    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final int INF = (int) 1e7 + 7;

    private static final String yes = "YES", no = "NO";

    private static final boolean MULTI_TEST = false;

    private void solve() {
//        char[] s = nextToken().toCharArray();
        long n = nextInt();
        long m = nextInt();
        long a = nextInt();

//        int[] a = nextIntArray(n);
//        int[] b = nextIntArray(m);

        long ans = ((n + a - 1) / a) * ((m + a - 1) / a);
        println(ans);
    }

    private void solveAll() {
        int t = MULTI_TEST ? nextInt() : 1;
        while (t-- > 0) {
            solve();
        }
    }

    public static void main(String[] args) {
        new Main().run();
    }

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer;
    private StringBuilder stringBuilder = new StringBuilder();

    private void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            this.reader = reader;
            this.writer = writer;
            solveAll();
            this.writer.print(stringBuilder);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
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


    /**
     * Primitives: int, long, double
     */
    private int nextInt() {
        return parseInt(nextToken());
    }

    private long nextLong() {
        return parseLong(nextToken());
    }

    private double nextDouble() {
        return parseDouble(nextToken());
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
    }

    private void print(Object o) {
        stringBuilder.append(o);
    }

    private void println() {
        stringBuilder.append('\n');
    }

    private void println(Object o) {
        stringBuilder.append(o).append('\n');
    }

    private void flush() {
        writer.print(stringBuilder);
        writer.flush();
        stringBuilder = new StringBuilder();
    }


}
