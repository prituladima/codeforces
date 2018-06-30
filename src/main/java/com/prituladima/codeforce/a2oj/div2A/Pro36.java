package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 6/30/18.
 */
public class Pro36 {

    private static class Laptop {
        int p;
        int q;

        public Laptop(int p, int q) {
            this.p = p;
            this.q = q;
        }

        public int getP() {
            return p;
        }

        public int getQ() {
            return q;
        }
    }

    private void solve() {

        int n = nextInt();
        PriorityQueue<Laptop> pqP = new PriorityQueue<>(Comparator.comparingInt(Laptop::getP));
        PriorityQueue<Laptop> pqQ = new PriorityQueue<>(Comparator.comparingInt(Laptop::getQ));

        for (int i = 0; i < n; i++) {
            int p = nextInt(), q = nextInt();
            pqP.add(new Laptop(p, q));
            pqQ.add(new Laptop(p, q));
        }

        for (int i = 0; i < n; i++) {
            Laptop l1 = pqP.remove(), l2 = pqQ.remove();
            if (l1.p != l2.p && l1.q != l2.q) {
                System.out.println("Happy Alex");
                return;
            }

        }

        System.out.println("Poor Alex");

    }

    public static void main(String[] args) {
        new Pro36().solve();
    }

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer tokenizer;

    int nextInt() {
        return Integer.parseInt(nextToken());
    }

    long nextLong() {
        return Long.parseLong(nextToken());
    }

    double nextDouble() {
        return Double.parseDouble(nextToken());
    }


    int[] nextArr(int size) {
        return Arrays.stream(new int[size]).map(c -> nextInt()).toArray();
    }

    long[] nextArrL(int size) {
        return Arrays.stream(new long[size]).map(c -> nextLong()).toArray();
    }

    double[] nextArrD(int size) {
        return Arrays.stream(new double[size]).map(c -> nextDouble()).toArray();
    }

    char[][] nextCharMatrix(int n) {
        return range(0, n).mapToObj(i -> nextToken().toCharArray()).toArray(char[][]::new);
    }

    int[][] nextIntMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(int[][]::new);
    }

    double[][] nextDoubleMatrix(int n, int m) {
        return range(0, n).mapToObj(i -> nextArr(m)).toArray(double[][]::new);
    }

    String nextToken() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
    }

}
