package com.prituladima.timus;

import java.io.*;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Random;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class Task1635 {
    private static final int BITS = 31;
    private static final int MODULO = (int) 1e9 + 7;
    private static final int INF = (int) 1e7 + 7;

    private static final String yes = "YES", no = "NO";
    private static final boolean ONLINE_JUDGE = System.getProperty("ONLINE_JUDGE") != null;
    private static final boolean MULTI_TEST = false;

    class Manacher {
        private int[] p;  // p[i] = length of longest palindromic substring of t, centered at i
        private String s;  // original string
        private char[] t;  // transformed string

        public Manacher(String s) {
            this.s = s;
            preprocess();
            p = new int[t.length];

            int center = 0, right = 0;
            for (int i = 1; i < t.length - 1; i++) {
                int mirror = 2 * center - i;

                if (right > i)
                    p[i] = Math.min(right - i, p[mirror]);

                // attempt to expand palindrome centered at i
                while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                    p[i]++;

                // if palindrome centered at i expands past right,
                // adjust center based on expanded palindrome.
                if (i + p[i] > right) {
                    center = i;
                    right = i + p[i];
                }
            }

        }

        // Transform s into t.
        // For example, if s = "abba", then t = "$#a#b#b#a#@"
        // the # are interleaved to avoid even/odd-length palindromes uniformly
        // $ and @ are prepended and appended to each end to avoid bounds checking
        private void preprocess() {
            t = new char[s.length() * 2 + 3];
            t[0] = '$';
            t[s.length() * 2 + 2] = '@';
            for (int i = 0; i < s.length(); i++) {
                t[2 * i + 1] = '#';
                t[2 * i + 2] = s.charAt(i);
            }
            t[s.length() * 2 + 1] = '#';
        }

        // longest palindromic substring
        public String longestPalindromicSubstring() {
            int length = 0;   // length of longest palindromic substring
            int center = 0;   // center of longest palindromic substring
            for (int i = 1; i < p.length - 1; i++) {
                if (p[i] > length) {
                    length = p[i];
                    center = i;
                }
            }
            return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
        }

        // longest palindromic substring centered at index i/2
        public String longestPalindromicSubstring(int i) {
            int length = p[i + 2];
            int center = i + 2;
            return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
        }

        //len must be <= with palindrome len
        public boolean isPalindrome(int l, int r) {
            if (r < l) {
                return isPalindrome(r, l);
            }

            return r - l + 1 <= p[l + r + 2];
        }
    }

    private void solve() {
        char[] s = nextToken().toCharArray();

        int N = s.length;
        int[][] ans = new int[N][N];

        final Manacher manacher = new Manacher(String.valueOf(s));
        for (int L = N - 1; L >= 0; L--) {
            for (int R = L; R < N; R++) {
                if (manacher.isPalindrome(L, R)) {
                    ans[L][R] = 1;
                } else {
                    ans[L][R] = ans[L][R - 1] + ans[R][R];
                }
            }
            ans[L][N - 1] = Integer.MAX_VALUE;
            if (manacher.isPalindrome(L, N - 1)) {
                ans[L][N - 1] = 1;
                continue;
            }
            for (int R = L; R + 1 <= N - 1; R++) {
                ans[L][N - 1] = Math.min(ans[L][N - 1], ans[L][R] + ans[R + 1][N - 1]);
            }
        }
        int finalAns = ans[0][N - 1];
        println(finalAns);
        finalAns--;
        for (int i = 0; i < N; i++) {
            if (ans[i][N - 1] == finalAns) {
                print(' ');
                finalAns--;
            }
            print(s[i]);
        }

        //Fails for "dfffdd"
        //outputs is
        //dfff dd

        //zzzqxx
        //n = 6
        //ans[5][5] = 1;
        //ans[4][5]


        //adfgh asdsa fnkjnsdvjfks

/**
 //1. [L..R] palindrome ? O(1)
 //2. iterate over all pref that palindromes
 // i - end pref pal
 // ans[1][1] = 1
 // ans[1][2] = ans[1][1] + ans[2][2] or [1..2] palindrome -> 1
 // ans[1][3] = ans[1][2] + ans[3][3] or [1..3] pal -> 1 or ans[1][1] + ans[2][3]

 // L <= R
 // ans[1][R] = if([1..R] is ok) -> 1
 //             else
 // for(int L = 1; L < R; L++)
 //  ans[1][R] = min(ans[1][L], ans[L+1][R])

 ans[1][n]

 ans[n][n] = 1

 1..n ans[i][i] = 1

 ans[n-1][n] = ans[n][n] + ans[n-1][n-1] or pal
 ans[n-2][n] = ans[n-1][n] + ans[n-2][n-2] or pal or ans[n][n] + ans[n-2][n-1]




 // ans[1][j] = min(1 + ans[i + 1][j])
 // ans[n-1][n-1] = 1

 ans[1][n] =



 */


        //Find the answer
//        int[] ans = new int[4001];
//        int[] cur = new int[4001];
        //O(n^2) run
        //O(n)
//        for (int i = 1; i < s.length; i++) {
//
//        }

        //Constructive answer
        // TODO: 11/26/2019

        //sasdjknfskjlanf

        //[i..n)
    }

    private void solveAll() {
        int t = MULTI_TEST ? nextInt() : 1;
        while (t-- > 0) {
            solve();
        }
    }

    public static void main(String[] args) {
        new Task1635().run();
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
