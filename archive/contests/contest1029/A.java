package com.prituladima.codeforce.virtual.contest1029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public final class A {

    private void solve() {

        int n = nextInt(), k = nextInt();
        String t = nextToken();
        List<Integer> p = compute_prefix_function(t);
        soutnl(p);
        int len = n - p.get(n - 1);
        for (int i = 0; i < k - 1; ++i)
            sout(t.substring(0, len));
        sout(t);
    }

    public static List<Integer> compute_prefix_function(String s) {
        int len = s.length();
        List<Integer> p = new ArrayList<>(); // значения префикс-функции
        for (int i = 0; i < len; ++i) {      // заполнение листа нулями default
            p.add(0);
        }
        // индекс листа соответствует номеру последнего символа аргумента
        int k = 0;
        for (int i = 1; i < len; ++i) {
            while ((k > 0) && (s.charAt(k) != s.charAt(i)))
                k = p.get(k - 1);
            if (s.charAt(k) == s.charAt(i))
                ++k;
            p.set(i, k);
        }
        return p;
    }

    public static void main(String[] args) {
        new A().run();
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