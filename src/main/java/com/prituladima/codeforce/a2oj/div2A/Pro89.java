package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Pro89 {

    private void solve() {

        int n = nextInt();
        char[] input = nextToken().toCharArray();

        char[][] ans = new char[n >> 1][2];
        int[][] ans1 = new int[n >> 1][2];

        for (int i = 0; i < n; i++) {
            ans[i % (n >> 1)][i + 1 > n / 2 ? 1 : 0] = input[i];
            ans1[i % (n >> 1)][i + 1 > n / 2 ? 1 : 0] = i + 1;
        }

        for (int i = 0; i < (n >> 1); i++) {
            if (ans[i][0] == 'R' && ans[i][1] == 'L') {
                char buf = ans[i][0];
                ans[i][0] = ans[i][1];
                ans[i][1] = buf;

                int buf1 = ans1[i][0];
                ans1[i][0] = ans1[i][1];
                ans1[i][1] = buf1;
            }
            souf("%d %d\n", ans1[i][0], ans1[i][1]);
        }
    }

    public static void main(String[] args) {
        new Pro89().run();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private void run() {
        try {
            reader = new BufferedReader(new FileReader(new File("input.txt")));
            tokenizer = null;
            writer = new PrintWriter(new File("output.txt"));
            solve();
            reader.close();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
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

    private int[] nextArr(int size) {
        return Arrays.stream(new int[size]).map(c -> nextInt()).toArray();
    }

    private long[] nextArrL(int size) {
        return Arrays.stream(new long[size]).map(c -> nextLong()).toArray();
    }

    private double[] nextArrD(int size) {
        return Arrays.stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    private char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    private int[][] nextIntMatrix(int n, int m) {
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

    private void soutn() {
        writer.println();
    }

    private void soutn(Object o) {
        writer.println(o);
    }

    private void sout(Object o) {
        writer.print(o);
    }

    private void souf(String format, Object... args) {
        writer.printf(format, args);
    }

    private <Param> void sout(Param[] arr) {
        writer.println(Arrays.toString(arr));
    }

}
