package com.prituladima.timus;

import java.io.*;
import java.util.*;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

/**
 * Don't confuse variables in inner cycles. Don't call variable like (i j k g). Delegate methods.
 * -Xmx64m maximum heap size allocation
 * Never hardcode MAXN. Always make plus one.
 * 90% errors is copy-paste and wrong indexes
 */
public class Task1221 {

    private static final int MAXN = 101;
    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final int INF = (int) 1e7 + 7;

    private static final String yes = "YES", no = "NO";
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private static final boolean MULTI_TEST = false;

    private static int[] memo;
    private static int[][] prefSumCol;
    private static int[][] prefSumRow;

    private int solve() {
        int n = nextInt();
        if (n == 0) {
            return 0;
        }

        int[][] a = nextIntMatrix(n, n);

        int ans = -1;


//        for (int row = 0; row < n; row++) {
//            prefSumCol[row][0] = a[row][0];
//            for (int col = 1; col < n; col++) {
//                prefSumCol[row][col] = prefSumCol[row][col - 1];
//                prefSumCol[row][col] += a[row][col];
//            }
//        }
//
//        for (int col = 0; col < n; col++) {
//            prefSumRow[0][col] = a[0][col];
//            for (int row = 1; row < n; row++) {
//                prefSumRow[row][col] = prefSumRow[row - 1][col];
//                prefSumRow[row][col] += a[row][col];
//            }
//        }
        prefSumCol = calculatePrefixSumCol(a);
        prefSumRow = calculatePrefixSumRow(a);

        for (int T = 0; T < n; T++) {
            for (int D = 0; D < n; D++) {
                int high = D - T + 1;
                if (T < D && high > 2 && high % 2 == 1 && high > ans) {
                    if (answerExistForSeriesWithHigh(D, high, n)) {
                        ans = Math.max(high, ans);
                    }

                }
            }
        }


        return ans;
    }

    private boolean answerExistForSeriesWithHigh(int i, int high, int n) {
        for (int j = high - 1; j < n; j++) {
            if (matrixIsOk(i, j, high, n)) {
                return true;
            }
        }
        return false;
    }

    private boolean matrixIsOk(int i, int j, int high, int n) {
        int curShift = -2;
        int mustBeValue = high - 1;

        boolean allMatch = true;
        for (int diff = 0; diff < high; diff++) {
            int pointerI = i - diff;
            int pointerJ = j - diff;

            int sumI = getColSum(pointerI, j, high);
            int sumJ = getRowSum(i, pointerJ, high);

            allMatch &= (sumI == Math.abs(mustBeValue) && sumJ == Math.abs(mustBeValue));
//            if(mustBeValue == 0){
//                curShift -= curShift;
//
//            }
            if (!allMatch) return false;
            mustBeValue += curShift;


        }
        return allMatch;
    }

    private int getColSum(int i, int j, int high) {

        int ans = prefSumCol[i][j];
        if (0 <= j - high) {
            ans -= prefSumCol[i][j - high];
        }

        return ans;


    }

    private int getRowSum(int i, int j, int high) {
        int ans = prefSumRow[i][j];
        if (0 <= i - high) {
            ans -= prefSumRow[i - high][j];
        }
        return ans;
    }

    private int[][] calculatePrefixSumCol(int[][] a){
        int n = a.length;
        int m = a[0].length;
        int[][] prefSumCol = new int[n][m];
        for (int row = 0; row < n; row++) {
            prefSumCol[row][0] = a[row][0];
            for (int col = 1; col < a[row].length; col++) {
                prefSumCol[row][col] = prefSumCol[row][col - 1];
                prefSumCol[row][col] += a[row][col];
            }
        }
        return prefSumCol;
    }

    private int[][] calculatePrefixSumRow(int[][] a){
        int n = a.length;
        int m = a[0].length;
        int[][] prefSumRow = new int[n][m];
        for (int col = 0; col < n; col++) {
            prefSumRow[0][col] = a[0][col];
            for (int row = 1; row < n; row++) {
                prefSumRow[row][col] = prefSumRow[row - 1][col];
                prefSumRow[row][col] += a[row][col];
            }
        }
        return prefSumRow;
    }


//    private


//    private boolean

    private void solveAll() {
        while (true) {
            final int res = solve();
            if (res == 0) {
                return;
            } else if (res == -1) {
                println("No solution");
            } else {
                println(res);
            }
        }
    }

    public static void main(String[] args) {
        new Task1221().run();
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