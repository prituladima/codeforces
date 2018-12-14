package com.prituladima.codeforce.contests.contest1036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.StrictMath.max;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class D {


    private void solve() {


        int n = nextInt();
        int[] a = nextArr(n);

        int m = nextInt();
        int[] b = nextArr(m);


        long[] sum_a = new long[n];
        long[] sum_B = new long[m];
        sum_a[0] = a[0];
        sum_B[0] = b[0];
        for (int i = 1; i < n; i++) {
            sum_a[i] += sum_a[i - 1] + a[i];
        }
        for (int i = 1; i < m; i++) {
            sum_B[i] += sum_B[i - 1] + b[i];
        }


        if (sum_a[n - 1] != sum_B[m - 1]) {
            sout(-1);
        } else {
            sout(LCSLength(sum_a, sum_B));
        }


    }


    int lcs(long[] X, long[] Y, int m, int n )
    {
        int[][] L = new int[m+1][n+1];
        int i, j;

   /* Following steps build L[m+1][n+1] in bottom up fashion. Note
      that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (i=0; i<=m; i++)
        {
            for (j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;

                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;

                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }

        /* L[m][n] contains length of LCS for X[0..n-1] and Y[0..m-1] */
        return L[m][n];
    }

    public static int LCSLength(long[] X, long[] Y)
    {
        int m = X.length, n = Y.length;

        // allocate storage for one-dimensional array curr
        int[] curr = new int[n + 1];
        int prev;

        // fill the lookup table in bottom-up manner
        for (int i = 0; i <= m; i++)
        {
            prev = curr[0];
            for (int j = 0; j <= n; j++)
            {
                int backup = curr[j];
                if (i == 0 || j == 0) {
                    curr[j] = 0;
                }
                else
                {
                    // if current character of X and Y matches
                    if (X[i - 1] == Y[j - 1]) {
                        curr[j] = prev + 1;
                    }
                    // else if current character of X and Y don't match
                    else {
                        curr[j] = Integer.max(curr[j], curr[j - 1]);
                    }
                }
                prev = backup;
            }
        }

        // LCS will be last entry in the lookup table
        return curr[n];
    }


    public static void main(String[] args) {
        new D().run();
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





}
