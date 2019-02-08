package com.prituladima.codeforce.a2oj.div2A;


import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.stream.IntStream.range;

public class Pro93 {

    private void solve() {

        int[] st = new int[3];
        int i = nextInt();
        st[i - 1] = 1;
        for (int j = 0; j < 3; j++) {
            int f = nextInt(), s = nextInt();
            int buff = st[f - 1];
            st[f - 1] = st[s - 1];
            st[s - 1] = buff;
        }

        for (int j = 0; j < st.length; j++) {
            if (st[j] != 0) {
                sout(j + 1);
            }
        }


    }

    public static void main(String[] args) {
        new Pro93().run();
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
