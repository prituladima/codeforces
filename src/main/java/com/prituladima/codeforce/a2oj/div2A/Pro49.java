package com.prituladima.codeforce.a2oj.div2A;

import java.io.*;
import java.util.*;

import static java.util.stream.IntStream.range;

/**
 * Created by prituladima on 7/2/18.
 */
public class Pro49 {

    private void solve() {

        int n = nextInt(), m = nextInt();

        ArrayList<Integer> listA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listA.add(nextInt());
        }

        ArrayList<Integer> listB = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            listB.add(nextInt());
        }

        Collections.sort(listA);
        Collections.sort(listB);

        int v = listA.get(0);
        int p = listA.get(listA.size() -1);
        int c = listB.get(0);




        if (Math.max(2*v, p)>=c) {
            System.out.println(-1);
        } else {
            System.out.println(Math.max(2*v, p));
        }


    }

    public static void main(String[] args) {
        new Pro49().solve();
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
