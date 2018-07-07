package com.prituladima.codeforce.a2oj.div2A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.util.stream.IntStream.range;

public class Pro80 {

    private void solve() {

        int n = nextInt(), m = nextInt(), k = nextInt();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int next = nextInt();
            if (next != 1) {
                a.add(next);
            }
        }
        Collections.sort(a, Comparator.reverseOrder());
        if (k >= m) {
            sout(0);
        } else {
            int canSupply = 0;
            int ans = 0;
            for (int i = 0; i < a.size(); i++) {
                canSupply += a.get(i) - 1;
                ans++;
                if (canSupply + k >= m) {
                   break;
                }
            }
            sout(canSupply + k >= m ? ans : -1);
        }
    }

    public static void main(String[] args) {
        new Pro80().run();
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
