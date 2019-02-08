package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Pro76 {

    private void solve() {

        char[] input = nextToken().toCharArray();
        while (true) {
            plusOneMin(input);
            if ((input[0] == input[4] && input[1] == input[3])) {
                break;
            }
        }

        sout(input);
    }


    private void plusOneMin(char[] input) {
        if (input[4] + 1 > '9') {
            input[4] = '0';
            if (input[3] + 1 > '5') {
                input[3] = '0';
                int hh = Integer.parseInt(input[0] + "" + input[1]);
                if (hh + 1 > 23) {
                    input[0] = '0';
                    input[1] = '0';
                } else {
                    char[] newHH = String.format("%02d", hh + 1).toCharArray();
                    input[0] = newHH[0];
                    input[1] = newHH[1];
                }
            } else {
                input[3]++;
            }
        } else {
            input[4]++;
        }
    }

    public static void main(String[] args) {
        new Pro76().run();
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

    private void sout(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            sout(arr[i]);
        }
    }


}
