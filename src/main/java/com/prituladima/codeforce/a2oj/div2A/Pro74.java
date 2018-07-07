package com.prituladima.codeforce.a2oj.div2A;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.util.stream.IntStream.range;

public class Pro74 {

    private void solve() {

        int r1 = nextInt(), r2 = nextInt();
        int c1 = nextInt(), c2 = nextInt();
        int d1 = nextInt(), d2 = nextInt();

        for (int c11 = 1; c11 < 10; c11++) {
            for (int c12 = 1; c12 < 10; c12++) {
                for (int c21 = 1; c21 < 10; c21++) {
                    for (int c22 = 1; c22 < 10; c22++) {
                        if (c11 + c12 == r1 &&
                                c21 + c22 == r2 &&
                                c11 + c21 == c1 &&
                                c12 + c22 == c2 &&
                                c11 + c22 == d1 &&
                                c12 + c21 == d2
                                ) {

                            Set<Integer> set = new HashSet<>();
                            set.add(c11);
                            set.add(c21);
                            set.add(c12);
                            set.add(c22);
                            if (set.size() == 4) {
                                souf("%d %d \n%d %d", c11, c12, c21, c22);
                                return;
                            }
                        }
                    }
                }
            }
        }

        soutn(-1);


    }

    public static void main(String[] args) {
        new Pro74().run();
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
