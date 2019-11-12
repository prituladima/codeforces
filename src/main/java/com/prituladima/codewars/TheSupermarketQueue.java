package com.prituladima.codewars;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

public class TheSupermarketQueue {
    private void solve() {
        int[] arr = new int[]{5, 3, 4};
        int buffSize = 1;
        println(queueTime(arr, buffSize));

        arr = new int[]{10, 2, 3, 3};
        buffSize = 2;
        println(queueTime(arr, buffSize));

        arr = new int[]{2, 3, 10};
        buffSize = 2;
        println(queueTime(arr, buffSize));
    }

    private int queueTime(int[] arr, int buffSize) {

        if (arr.length < buffSize) {
            int max = 0;
            for (int value : arr) {
                max = max(max, value);
            }
            return max;
        }

        //arr.length >= buffSize

        int[] buff = new int[buffSize];
        int ans = 0;
        int qPointer = 0;

        int used = 0;
        while (qPointer < arr.length) {
            int val = arr[qPointer++];
            for (int i = 0; i < buffSize; i++) {
                if (buff[i] == 0) {
                    buff[i] = val;
                    used++;
                    break;
                }
            }
            if (used == buffSize) {

                int curMin = Integer.MAX_VALUE;
                for (int i = 0; i < buffSize; i++) {
                    curMin = min(curMin, buff[i]);
                }
                ans += curMin;
                for (int i = 0; i < buffSize; i++) {
                    buff[i] -= curMin;
                    if (buff[i] == 0) {
                        used--;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < buffSize; i++) {
            max = max(max, buff[i]);
        }
        ans += max;

        return ans;
    }


    public static void main(String[] args) {
        new TheSupermarketQueue().run();
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
        print(o);
        println();
    }

    private void flush() {
        writer.flush();
    }
}
