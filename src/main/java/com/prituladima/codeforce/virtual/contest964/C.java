package com.prituladima.codeforce.virtual.contest964;

import java.io.*;
import java.util.*;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public final class C {

    private void solve() {

        long modulo = 1000000009;
        int n = nextInt();
        long a = nextLong(), b = nextLong();
        int k = nextInt();
        String s = nextToken();

        long[] ai = new long[n + 1];
        ai[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            ai[i + 1] = (ai[i + 1] % modulo + modulo) % modulo;
            ai[i] = ai[i + 1] * ((a % modulo + modulo) % modulo);
        }

        long[] bi = new long[n + 1];
        bi[0] = 1;
        for (int i = 1; i <= n; i++) {
            bi[i - 1] = (bi[i - 1] % modulo + modulo) % modulo;
            bi[i] = bi[i - 1] * ((b % modulo + modulo) % modulo);
        }


        long ans = 0L;
        for (int i = 0; i <= n; i++) {
            char ch = s.charAt(i % k);
            long mul = ch == '-' ? -1 : 1;

            long A = mul * ai[i];
            long B = bi[i];

            A = (A % modulo + modulo) % modulo;
            B = (B % modulo + modulo) % modulo;

            long sum = A * B;
            sum = (sum % modulo + modulo) % modulo;

            ans += sum;
            ans = (ans % modulo + modulo) % modulo;


        }

        soutnl(ans);

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