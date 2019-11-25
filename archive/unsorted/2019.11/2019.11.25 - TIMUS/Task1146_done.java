package com.prituladima.codeforce.contest;

import java.io.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

import static java.lang.Math.max;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

//todo To be tested
//todo return stringtokenizer
//todo probably remove StringBuilder
public class Main223538cb {

    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final int INF = (int) 1e7 + 7;

    private static final String yes = "YES", no = "NO";
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private static final boolean MULTI_TEST = false;

    private void solve() {
        int n = nextInt();
        //int[][] a = nextIntMatrix(n, n);
        //memory optimized solution
        int[][] prefSum = new int[n][n];

        //1. calculate pref sum for each col
        for (int col = 0; col < n; col++) {
            prefSum[0][col] = nextInt();
            for (int row = 1; row < n; row++) {
                prefSum[row][col] = nextInt() + prefSum[row - 1][col];
            }
        }

        int maxAns = Integer.MIN_VALUE;

        //2. Lets iterate over all matrices with width = n
        //time complexity O(n^2)
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {

                int curSum = 0;
                int localMaxAns = prefSum[right][0] - (left > 0 ? prefSum[left - 1][0] : 0);

                //3. for current matrix upper_bound = left, lower_bound = right
                //time complexity O(n)
                for (int i = 0; i < n; i++) {
                    int value = prefSum[right][i] - (left > 0 ? prefSum[left - 1][i] : 0);

                    curSum += value;
                    localMaxAns = max(localMaxAns, curSum);
                    curSum = max(curSum, 0);

                }

                maxAns = max(maxAns, localMaxAns);

            }
        }


        println(maxAns);
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

    public static double maxn(double req, double... opt) {
        double max = req;
        for (double value : opt) max = Math.max(max, value);
        return max;
    }

    public static double minn(double req, double... opt) {
        double min = req;
        for (double value : opt) min = Math.min(min, value);
        return min;
    }

    public static double sumn(double... a) {
        return stream(a).sum();
    }

    public static int maxn(int req, int... opt) {
        int max = req;
        for (int value : opt) max = Math.max(max, value);
        return max;
    }

    public static int minn(int req, int... opt) {
        int min = req;
        for (int value : opt) min = Math.min(min, value);
        return min;
    }

    public static int sumn(int... a) {
        return stream(a).sum();
    }

    public static long maxn(long req, long... opt) {
        long max = req;
        for (long value : opt) max = Math.max(max, value);
        return max;
    }

    public static long minn(long req, long... opt) {
        long min = req;
        for (long value : opt) min = Math.min(min, value);
        return min;
    }

    public static long sumn(long... a) {
        return stream(a).sum();
    }

    public static void safeSort(long[] array) {
        shuffle(array);
        Arrays.sort(array);
    }

    public static void shuffle(long[] array) {
        Random random = new Random();
        for (int i = 0, j; i < array.length; i++) {
            j = i + random.nextInt(array.length - i);
            long buf = array[j];
            array[j] = array[i];
            array[i] = buf;
        }
    }

    public static void safeSort(int[] array) {
        shuffle(array);
        Arrays.sort(array);
    }

    public static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0, j; i < array.length; i++) {
            j = i + random.nextInt(array.length - i);
            int buf = array[j];
            array[j] = array[i];
            array[i] = buf;
        }
    }
}