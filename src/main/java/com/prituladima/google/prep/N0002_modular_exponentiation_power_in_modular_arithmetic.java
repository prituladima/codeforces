package com.prituladima.google.prep;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class N0002_modular_exponentiation_power_in_modular_arithmetic {

    private void solve() {
        int T = nextInt();
        for (int qq = 0; qq < T; qq++) {
            int N = nextInt();
            int[] A = nextArr(N);
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                min = Math.min(min, A[i]);
                max = Math.max(max, A[i]);
            }
            int minC = 0;
            int maxC = 0;
            for (int i = 0; i < N; i++) {
                minC += A[i] == min ? 1 : 0;
                maxC += A[i] == max ? 1 : 0;
            }
            soutnl((binpow(2, maxC) - 1) + " " +
                    (binpow(2, minC) - 1));
        }
    }

    int MODULO = (int) 1e9 + 7;

    long pow(long base, long pow) {
        if (pow == 1) return base;
        if (pow == 0) return 1;
        if (pow % 2 == 0) {
            long temp = pow(base, pow / 2) % MODULO;
            temp *= temp;
            temp %= MODULO;
            return temp;
        } else {
            long temp = pow(base, pow - 1) % MODULO;
            temp *= base;
            temp %= MODULO;
            return temp;
        }
    }

    long binpow (long a, long n) {
        long res = 1;
        while (n != 0) {
            if ((n & 1) != 0){
                res *= a;
                res %= MODULO;
            }
            a *= a;
            a %= MODULO;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new N0002_modular_exponentiation_power_in_modular_arithmetic().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out))) {
            this.reader = reader;
            this.writer = writer;
            this.tokenizer = null;
            solve();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    private int nextInt(int radix) {
        return parseInt(nextToken(), radix);
    }

    private int nextInt() {
        return parseInt(nextToken());
    }

    private long nextLong(int radix) {
        return parseLong(nextToken(), radix);
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

    private double[][] nextDoubleMatrix(final int n, final int m) {
        return range(0, n).mapToObj(i -> nextArrD(m)).toArray(double[][]::new);
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

    private void flush() {
        writer.flush();
    }


}
