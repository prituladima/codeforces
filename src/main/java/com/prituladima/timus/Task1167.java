package com.prituladima.timus;

import java.io.*;
import java.util.*;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

/**
 * Don't confuse variables in inner cycles. Don't call variable like (i j k g). Delegate methods.
 */
public class Task1167 {
    // TODO: 12/4/2019 BONUS Build optimal answer

    private static final int MAXN = 501;
    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final int INF = (int) 1e7 + 7;

    private static final String yes = "YES", no = "NO";
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private static final boolean MULTI_TEST = false;

    private static int[][] memo = new int[MAXN][MAXN];

    static {
        for (int i = 0; i < MAXN; i++) {
            for (int j = 0; j < MAXN; j++) {
                memo[i][j] = -1;
            }
        }
    }

    int[] count0 = new int[MAXN];
    int[] count1 = new int[MAXN];

    private void solve() {

        int n = nextInt();
        int k = nextInt();
        int[] a = nextIntArray(n);

        count0[0] = (a[0] == 0) ? 1 : 0;
        count1[0] = (a[0] == 1) ? 1 : 0;

        for (int i = 1; i < n; i++) {
            count0[i] = count0[i - 1];
            count1[i] = count1[i - 1];
            count0[i] += (a[i] == 0) ? 1 : 0;
            count1[i] += (a[i] == 1) ? 1 : 0;
        }

        debug(count0);
        debug(count1);

        printSeparator();
        boolean topDown = false;
        if (topDown) {
            println(minAns(n - 1, k, n));
        } else {

            for (int i = 0; i < n; i++) {
                memo[i][1] = val(0, i, n);
                memo[i][i + 1] = 0;
            }

            for (int g = 2; g <= k; g++) {
                for (int R = g - 1; R < n; R++) {

                    memo[R][g] = Integer.MAX_VALUE;

                    for (int smallerR = R - 1; ; smallerR--) {
                        memo[R][g] = Math.min(memo[R][g], memo[smallerR][g - 1] + val(smallerR + 1, R, n));
                        if (smallerR + 1 == g - 1) {
                            break;
                        }
                    }
                }
            }
            println(memo[n - 1][k]);

        }

    }

    private int minAns(int R, int k, int n) {
        if (memo[R][k] != -1) {
            return memo[R][k];
        } else if (k == 1) {
            return memo[R][1] = val(0, R, n);
        } else {
            int minAns = Integer.MAX_VALUE;
            for (int smallerR = R - 1; ; smallerR--) {
                minAns = Math.min(minAns, minAns(smallerR, k - 1, n) + val(smallerR + 1, R, n));
                if (smallerR + 1 == k - 1) {
                    break;
                }
            }
            return memo[R][k] = minAns;
        }
    }

    private int val(int L, int R, int n) {
        int amountOf0 = count0[R];
        if (isValidIndex(L - 1, n)) {
            amountOf0 -= count0[L - 1];
        }
        int amountOf1 = count1[R];
        if (isValidIndex(L - 1, n)) {
            amountOf1 -= count1[L - 1];
        }
        return amountOf0 * amountOf1;
    }


    private void solveAll() {
        int t = MULTI_TEST ? nextInt() : 1;
        while (t-- > 0) {
            solve();
        }
    }

    public static void main(String[] args) {
        new Task1167().run();
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
    private Map<Integer, Set<Integer>> buildGraph(int amountOfVertex) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
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