package com.prituladima.codeforce.contest1337;

import java.io.*;
import java.util.*;
import java.util.function.Predicate;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

/**
 * Don't confuse variables in inner cycles. Don't call variable like (i j k g). Delegate methods.
 * -Xmx64m maximum heap size allocation
 * Never hardcode MAXN. Always make plus one.
 * 90% errors is copy-paste, wrong indexes and TOO MUCH variables
 */
public class MainD {

    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final int INF = (int) 1e7 + 7;

    private static final String yes = "YES", no = "NO";
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private static final boolean MULTI_TEST = true;

    private void solve() {
        int nr = nextInt(), ng = nextInt(), nb = nextInt();
        int[] r = nextIntArray(nr);
        int[] g = nextIntArray(ng);
        int[] b = nextIntArray(nb);
        safeSort(r);
        safeSort(g);
        safeSort(b);
        long minAns = Long.MAX_VALUE;

        int[][][] vars = {
                {r, g, b},
                {r, b, g},

                {g, r, b},
                {g, b, r},

                {b, r, g},
                {b, g, r}
        };
        for (int[][] comb : vars) {
            minAns = Long.min(getMinAns(comb[0], comb[1], comb[2]), minAns);
        }
//        minAns = Long.min(getMinAns(r, b, g), minAns);
//
//        minAns = Long.min(getMinAns(g, r, b), minAns);
//        minAns = Long.min(getMinAns(g, b, r), minAns);
//
//        minAns = Long.min(getMinAns(b, r, g), minAns);
//        minAns = Long.min(getMinAns(b, g, r), minAns);

        if (minAns == Long.MAX_VALUE) {
            throw new IllegalStateException();
        }

        println(minAns);


    }

    private long getMinAns(int[] X, int[] Y, int[] Z) {
        long minAns = Long.MAX_VALUE;
        for (final int XI : X) {
            int j = lowerBound(-1, Y.length, Y, val -> XI <= val);
            if (j == Y.length) continue;

            int k = upperBound(-1, Z.length, Z, val -> val <= XI);
            if (k == -1) continue;

            minAns = Long.min(minAns, fun(XI, Y[j], Z[k]));
        }
//        if(!ONLINE_JUDGE){
//            println("TRY");
//            println(Arrays.toString(X));
//            println(Arrays.toString(Y));
//            println(Arrays.toString(Z));
//        }

        return minAns;
    }

    private long fun(long x, long y, long z) {
        return (x - y) * (x - y) + (y - z) * (y - z) + (z - x) * (z - x);
    }

    private int upperBound(int inclusiveLeft, int exclusiveRight, int[] array, Predicate<Integer> predicate) {
        while (exclusiveRight - inclusiveLeft > 1) {
            int middle = inclusiveLeft + (exclusiveRight - inclusiveLeft) / 2;
            if (predicate.test(array[middle])) {
                inclusiveLeft = middle;
            } else {
                exclusiveRight = middle;
            }
        }
        return inclusiveLeft;
    }

    private int lowerBound(int exclusiveLeft, int inclusiveRight, int[] array, Predicate<Integer> predicate) {
        while (inclusiveRight - exclusiveLeft > 1) {
            int middle = exclusiveLeft + (inclusiveRight - exclusiveLeft) / 2;
            if (predicate.test(array[middle])) {
                inclusiveRight = middle;
            } else {
                exclusiveLeft = middle;
            }
        }
        return inclusiveRight;
    }


    private boolean isOkey(int an, int an1, int an2) {
        return an + an1 > an2;
    }


    private int minAns(int lev) {

        char[] tabs = new char[lev];
        Arrays.fill(tabs, '\t');
        debug(new StringBuilder().append(tabs).append(" ").append(lev));

        return 0;
    }


    private void solveAll() {
        int t = MULTI_TEST ? nextInt() : 1;
        while (t-- > 0) {
            solve();
        }
    }

    public static void main(String[] args) {
        new MainD().run();
    }

    private BufferedReader reader;
    private PrintWriter writer;
    private StringTokenizer tokenizer;

    private void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)))) {
            this.writer = writer;
            this.reader = reader;
            solveAll();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    /**
     * Base types: Strings, int, long, double
     */
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

    private int nextInt() {
        return Integer.parseInt(nextToken());
    }

    private long nextLong() {
        return Long.parseLong(nextToken());
    }

    private double nextDouble() {
        return Double.parseDouble(nextToken());
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
     * Graphs
     */
    private class Graph extends HashMap<Integer, Collection<Integer>> {

    }

    private Graph buildGraph(int amountOfVertex) {
        Graph graph = new Graph();
        for (int from = 1; from <= amountOfVertex; from++) {
            graph.putIfAbsent(from, new HashSet<>());
        }
        return graph;
    }

    /**
     * Output
     */
    private void printf(String format, Object... args) {
        writer.printf(format, args);
    }

    private void print(Object o) {
        writer.print(o);
    }

    private void println() {
        writer.println();
    }

    private void println(Object o) {
        writer.println(o);
    }

    private void flush() {
        writer.flush();
    }

    /**
     * Utils
     */

    private boolean isValidIndex(int ind, int n) {
        return 0 <= ind && ind < n;
    }

    private void printSeparator() {
        if (ONLINE_JUDGE) return;
        println("--------------Answer-----------------");
    }

    private void debug(Object o) {
        if (ONLINE_JUDGE) return;
        println(o);
    }

    private void debug(int[] array) {
        if (ONLINE_JUDGE) return;
        for (int i = 0; i < array.length; i++) {
            print(array[i]);
            print(' ');
        }
        println();
    }

    private void debug(int[][] matrix) {
        if (ONLINE_JUDGE) return;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                print(matrix[i][j]);
                print(' ');
            }
            println();
        }
    }


    private void debug(char[][] matrix) {
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

    public static Map<Double, Integer> multiSet(double[] arr) {
        Map<Double, Integer> multiSet = new HashMap<>();
        for (int i = 0; i < arr.length; i++) multiSet.put(arr[i], multiSet.getOrDefault(arr[i], 0) + 1);
        return multiSet;
    }

    public static Map<Integer, Integer> multiSet(int[] arr) {
        Map<Integer, Integer> multiSet = new HashMap<>();
        for (int i = 0; i < arr.length; i++) multiSet.put(arr[i], multiSet.getOrDefault(arr[i], 0) + 1);
        return multiSet;
    }

    public static Map<Long, Integer> multiSet(long[] arr) {
        Map<Long, Integer> multiSet = new HashMap<>();
        for (int i = 0; i < arr.length; i++) multiSet.put(arr[i], multiSet.getOrDefault(arr[i], 0) + 1);
        return multiSet;
    }

    public static int[] calculatePrefixSum(int[] a) {
        int[] pref = new int[a.length];
        pref[0] = a[0];
        for (int i = 1; i < a.length; i++) pref[i] = pref[i - 1] + a[i];
        return pref;
    }

    public static int[] calculateSuffixSum(int[] a) {
        int[] suff = new int[a.length];
        suff[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) suff[i] = suff[i + 1] + a[i];
        return suff;
    }

    public static long[] calculatePrefixSum(long[] a) {
        long[] pref = new long[a.length];
        pref[0] = a[0];
        for (int i = 1; i < a.length; i++) pref[i] = pref[i - 1] + a[i];
        return pref;
    }

    public static long[] calculateSuffixSum(long[] a) {
        long[] suff = new long[a.length];
        suff[a.length - 1] = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) suff[i] = suff[i + 1] + a[i];
        return suff;
    }

}